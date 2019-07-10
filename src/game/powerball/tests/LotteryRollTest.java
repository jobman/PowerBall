package game.powerball.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import game.powerball.PowerBallLottery;

public class LotteryRollTest {

	@Test
	public void test() {
		PowerBallLottery pbl = PowerBallLottery.getInstance();
		pbl.rollTheGame();
		int expected = PowerBallLottery.needToCrossWhite;
		int output = pbl.getWinNumberWhite().size();
		assertEquals(expected, output);
	}

}
