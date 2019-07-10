package game.powerball.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import game.powerball.Player;

public class PlayerCreationTest {

	@Test
	public void test() {
		Player output = new Player();
		assertEquals(output, Player.players.get(output.getId()));
	}

}
