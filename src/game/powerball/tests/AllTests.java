package game.powerball.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AssignPrizeTest.class, LotteryRollTest.class, PlayerCreationTest.class, PlayerCrossingRedTest.class,
		PlayerCrossingWhiteTest.class, TicketSellTest.class })
public class AllTests {

}
