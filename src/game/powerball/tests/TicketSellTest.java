package game.powerball.tests;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import game.powerball.Player;
import game.powerball.PowerBallLottery;
import game.powerball.Ticket;

public class TicketSellTest {

	@Test
	public void test() {
		PowerBallLottery pbl = PowerBallLottery.getInstance();
		Player owner = new Player();
		Set<Integer> crosedRed = owner.crossRed();
		Set<Integer> crosedWhite = owner.crossWhite();

		Ticket ticketExpected = new Ticket(owner, crosedWhite, crosedRed);

		Ticket ticketOutput = pbl.sellTicket(owner, crosedWhite, crosedRed);
		assertEquals(ticketExpected, ticketOutput);

	}

}
