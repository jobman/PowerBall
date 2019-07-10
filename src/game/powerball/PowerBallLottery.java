package game.powerball;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class PowerBallLottery {
	public static final int needToCrossWhite = 5;
	public static final int needToCrossRed = 1;

	public static final int whiteLastNumber = 69;
	public static final int redLastNumber = 26;

	private ArrayList<Ticket> registredTickets = new ArrayList<Ticket>();
	private Set<Integer> winNumberWhite = new TreeSet<Integer>();
	private Set<Integer> winNumberRed = new TreeSet<Integer>();

	// statistics block
	private static int countOfAllRegistredTickets = 0;
	private static ArrayList<Ticket> winTicketsWhite0Red1 = new ArrayList<Ticket>();
	private static ArrayList<Ticket> winTicketsWhite1Red1 = new ArrayList<Ticket>();
	private static ArrayList<Ticket> winTicketsWhite2Red1 = new ArrayList<Ticket>();
	private static ArrayList<Ticket> winTicketsWhite3Red0 = new ArrayList<Ticket>();
	private static ArrayList<Ticket> winTicketsWhite3Red1 = new ArrayList<Ticket>();
	private static ArrayList<Ticket> winTicketsWhite4Red0 = new ArrayList<Ticket>();
	private static ArrayList<Ticket> winTicketsWhite4Red1 = new ArrayList<Ticket>();
	private static ArrayList<Ticket> winTicketsWhite5Red0 = new ArrayList<Ticket>();
	private static ArrayList<Ticket> winTicketsWhite5Red1 = new ArrayList<Ticket>();

	private static PowerBallLottery instance = null;

	private PowerBallLottery() {

	}

	public static PowerBallLottery getInstance() {
		if (instance == null) {
			instance = new PowerBallLottery();
		}
		return instance;

	}

	public Ticket sellTicket(Player owner, Set<Integer> crossedWhite, Set<Integer> crossedRed) {

		if (crossedWhite.size() != needToCrossWhite || crossedRed.size() != needToCrossRed) {
			return null;
		}
		Iterator<Integer> it = crossedWhite.iterator();
		while (it.hasNext()) {
			int next = (int) it.next();
			if (next < 1 || next > whiteLastNumber) {
				return null;
			}
		}

		it = crossedRed.iterator();
		while (it.hasNext()) {
			int next = (int) it.next();
			if (next < 1 || next > redLastNumber) {
				return null;
			}
		}

		Ticket ticket = new Ticket(owner, crossedWhite, crossedRed);
		registredTickets.add(ticket);
		countOfAllRegistredTickets++;
		return ticket;

	}

	public void rollTheGame() {

		winNumberWhite = new TreeSet<Integer>();
		winNumberRed = new TreeSet<Integer>();

		while (winNumberRed.size() < needToCrossRed) {
			Integer randomNumber = (int) (Math.random() * redLastNumber) + 1;
			winNumberRed.add(randomNumber);
		}

		while (winNumberWhite.size() < needToCrossWhite) {
			Integer randomNumber = (int) (Math.random() * whiteLastNumber) + 1;
			winNumberWhite.add(randomNumber);
		}

	}

	public Set<Integer> getWinNumberWhite() {
		return winNumberWhite;
	}

	public Set<Integer> getWinNumberRed() {
		return winNumberRed;
	}

	public void assignTicketWins() {
		for (Ticket ticket : registredTickets) {
			Set<Integer> crossedRed = ticket.getCrossedRed();
			Set<Integer> crossedWhite = ticket.getCrossedWhite();

			crossedWhite.retainAll(winNumberWhite);
			crossedRed.retainAll(winNumberWhite);

			int winWhiteCount = crossedWhite.size();
			int winRedCount = crossedRed.size();

			int prize = 0;
			if (winWhiteCount == 5 && winRedCount == 1) {
				winTicketsWhite5Red1.add(ticket);
				prize = 150000000;
			}
			if (winWhiteCount == 5 && winRedCount == 0) {
				winTicketsWhite5Red0.add(ticket);
				prize = 1000000;
			}
			if (winWhiteCount == 4 && winRedCount == 1) {
				winTicketsWhite4Red1.add(ticket);
				prize = 50000;
			}
			if (winWhiteCount == 4 && winRedCount == 0) {
				winTicketsWhite4Red0.add(ticket);
				prize = 100;
			}
			if (winWhiteCount == 3 && winRedCount == 1) {
				winTicketsWhite3Red1.add(ticket);
				prize = 100;
			}
			if (winWhiteCount == 3 && winRedCount == 0) {
				winTicketsWhite3Red0.add(ticket);
				prize = 7;
			}
			if (winWhiteCount == 2 && winRedCount == 1) {
				winTicketsWhite2Red1.add(ticket);
				prize = 7;
			}
			if (winWhiteCount == 1 && winRedCount == 1) {
				winTicketsWhite1Red1.add(ticket);
				prize = 4;
			}
			if (winWhiteCount == 0 && winRedCount == 1) {
				winTicketsWhite0Red1.add(ticket);
				prize = 4;
			}

			if (prize > 0) {
				ticket.getOwner().takePrize(prize);
			}
		}
		registredTickets = new ArrayList<Ticket>();
	}

	public void compareExperimentalVsTheoretical() {
		System.out.println("White 0; Red 1");
		double experimentalW0R1 = countOfAllRegistredTickets / (float) winTicketsWhite0Red1.size();
		experimentalW0R1 = (double) Math.round(experimentalW0R1 * 100) / 100;
		double theoreticalW0R1 = 38.32;
		System.out.println("Theoretical 1 in " + theoreticalW0R1);
		System.out.println("Experimental 1 in " + experimentalW0R1);
		System.out.println();

		System.out.println("White 1; Red 1");
		double experimentalW1R1 = countOfAllRegistredTickets / (float) winTicketsWhite1Red1.size();
		experimentalW1R1 = (double) Math.round(experimentalW1R1 * 100) / 100;
		double theoreticalW1R1 = 91.98;
		System.out.println("Theoretical 1 in " + theoreticalW1R1);
		System.out.println("Experimental 1 in " + experimentalW1R1);
		System.out.println();

		System.out.println("White 2; Red 1");
		double experimentalW2R1 = countOfAllRegistredTickets / (float) winTicketsWhite2Red1.size();
		experimentalW2R1 = (double) Math.round(experimentalW2R1 * 100) / 100;
		double theoreticalW2R1 = 701.33;
		System.out.println("Theoretical 1 in " + theoreticalW2R1);
		System.out.println("Experimental 1 in " + experimentalW2R1);
		System.out.println();

		System.out.println("White 3; Red 0");
		double experimentalW3R0 = countOfAllRegistredTickets / (float) winTicketsWhite3Red0.size();
		experimentalW3R0 = (double) Math.round(experimentalW3R0 * 100) / 100;
		double theoreticalW3R0 = 579.76;
		System.out.println("Theoretical 1 in " + theoreticalW3R0);
		System.out.println("Experimental 1 in " + experimentalW3R0);
		System.out.println();

		System.out.println("White 3; Red 1");
		double experimentalW3R1 = countOfAllRegistredTickets / (float) winTicketsWhite3Red1.size();
		experimentalW3R1 = (double) Math.round(experimentalW3R1 * 100) / 100;
		double theoreticalW3R1 = 14494.11;
		System.out.println("Theoretical 1 in " + theoreticalW3R1);
		System.out.println("Experimental 1 in " + experimentalW3R1);
		System.out.println();

		System.out.println("White 4; Red 0");
		double experimentalW4R0 = countOfAllRegistredTickets / (float) winTicketsWhite4Red0.size();
		experimentalW4R0 = (double) Math.round(experimentalW4R0 * 100) / 100;
		double theoreticalW4R0 = 36525.17;
		System.out.println("Theoretical 1 in " + theoreticalW4R0);
		System.out.println("Experimental 1 in " + experimentalW4R0);
		System.out.println();

		System.out.println("White 4; Red 1");
		double experimentalW4R1 = countOfAllRegistredTickets / (float) winTicketsWhite4Red1.size();
		experimentalW4R1 = (double) Math.round(experimentalW4R1 * 100) / 100;
		double theoreticalW4R1 = 913129.18;
		System.out.println("Theoretical 1 in " + theoreticalW4R1);
		System.out.println("Experimental 1 in " + experimentalW4R1);
		System.out.println();

		System.out.println("White 5; Red 0");
		double experimentalW5R0 = countOfAllRegistredTickets / (float) winTicketsWhite5Red0.size();
		experimentalW5R0 = (double) Math.round(experimentalW5R0 * 100) / 100;
		double theoreticalW5R0 = 11688053.52;
		System.out.println("Theoretical 1 in " + theoreticalW5R0);
		System.out.println("Experimental 1 in " + experimentalW5R0);
		System.out.println();

		System.out.println("White 5; Red 1");
		double experimentalW5R1 = countOfAllRegistredTickets / (float) winTicketsWhite5Red1.size();
		experimentalW5R1 = (double) Math.round(experimentalW5R1 * 100) / 100;
		double theoreticalW5R1 = 292201338;
		System.out.println("Theoretical 1 in " + theoreticalW5R1);
		System.out.println("Experimental 1 in " + experimentalW5R1);
		System.out.println();
	}
}
