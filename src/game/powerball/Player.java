package game.powerball;

import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeSet;

public class Player {
	public static ArrayList<Player> players = new ArrayList<Player>();
	private static int nextId;

	private int id;
	private ArrayList<Ticket> tickets;
	private int totalPrize;

	public Player() {
		this.id = nextId++;
		tickets = new ArrayList<Ticket>();
		players.add(this);
	}

	public TreeSet<Integer> crossWhite() {
		TreeSet<Integer> crossedWhite = new TreeSet<Integer>();

		while (crossedWhite.size() < PowerBallLottery.needToCrossWhite) {
			Integer randomNumber = (int) (Math.random() * PowerBallLottery.whiteLastNumber) + 1;
			crossedWhite.add(randomNumber);
		}
		return crossedWhite;
	}

	public TreeSet<Integer> crossRed() {
		TreeSet<Integer> crossedRed = new TreeSet<Integer>();

		while (crossedRed.size() < PowerBallLottery.needToCrossRed) {
			Integer randomNumber = (int) (Math.random() * PowerBallLottery.redLastNumber) + 1;
			crossedRed.add(randomNumber);
		}
		return crossedRed;
	}

	public boolean addTicket(Ticket ticket) {
		return tickets.add(ticket);
	}

	public void takePrize(int prize) {
		totalPrize += prize;
	}

	public int getId() {
		return id;
	}

	public int getTotalPrize() {
		return totalPrize;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player player = (Player) obj;
		return (id == player.id) && Objects.equals(tickets, player.tickets) && (totalPrize == player.totalPrize);
	}

}
