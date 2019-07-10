package game.powerball.tests;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import game.powerball.Player;
import game.powerball.PowerBallLottery;

public class PlayerCrossingRedTest {

	@Test
	public void test() {
		Player player = new Player();
		Set<Integer> crosedRed = player.crossRed();
		assertEquals(PowerBallLottery.needToCrossRed, crosedRed.size());
	}

}
