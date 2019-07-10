package game.powerball.tests;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.util.Set;

import org.junit.Test;

import game.powerball.Player;
import game.powerball.PowerBallLottery;
import game.powerball.Ticket;

public class AssignPrizeTest {

	@Test
	public void test() {
		PowerBallLottery pbl = PowerBallLottery.getInstance();
		Player player = new Player();
		Set<Integer> crosedWhite = player.crossWhite();
		Set<Integer> crosedRed = player.crossRed();
		Ticket ticket = pbl.sellTicket(player, crosedWhite, crosedRed);
		player.addTicket(ticket);
		pbl.rollTheGame();

		Set<Integer> winNumberWhite = null;
		Set<Integer> winNumberRed = null;
		try {
			Field fieldWinNumberWhite = PowerBallLottery.getInstance().getClass().getDeclaredField("winNumberWhite");
			Field fieldWinNumberRed = PowerBallLottery.getInstance().getClass().getDeclaredField("winNumberRed");
			fieldWinNumberWhite.setAccessible(true);
			fieldWinNumberRed.setAccessible(true);
			winNumberWhite = (Set<Integer>) fieldWinNumberWhite.get(PowerBallLottery.getInstance());
			winNumberRed = (Set<Integer>) fieldWinNumberWhite.get(PowerBallLottery.getInstance());
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
		if (winNumberWhite != null) {
			winNumberWhite.clear();
		}
		if (winNumberRed != null) {
			winNumberRed.clear();
			winNumberRed.addAll(crosedRed);
		}
		pbl.assignTicketWins();
		assertEquals(player.getTotalPrize(), 4);

	}

}
