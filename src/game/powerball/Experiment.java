package game.powerball;

import java.util.Iterator;

public class Experiment {

	public static void main(String[] args) {
		PowerBallLottery pbl = PowerBallLottery.getInstance();

		for (int i = 0; i < 100000; i++) {
			new Player();
		}

		Iterator<Player> it = Player.players.iterator();
		while (it.hasNext()) {
			Player player = it.next();
			int playerWantToBuyTickets = (int) Math.random() * 5 + 1;
			for (int i = 0; i < playerWantToBuyTickets; i++) {
				Ticket ticket = pbl.sellTicket(player, player.crossWhite(), player.crossRed());
				player.addTicket(ticket);
			}
		}

		pbl.rollTheGame();
		pbl.assignTicketWins();
		pbl.compareExperimentalVsTheoretical();
	}

}
