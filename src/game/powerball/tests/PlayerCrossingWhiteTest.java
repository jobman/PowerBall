package game.powerball.tests;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import game.powerball.Player;
import game.powerball.PowerBallLottery;

public class PlayerCrossingWhiteTest {

	@Test
	public void test() {
		Player player = new Player();
		Set<Integer> crosedWhite = player.crossWhite();
		assertEquals(PowerBallLottery.needToCrossWhite, crosedWhite.size());
	}

}
