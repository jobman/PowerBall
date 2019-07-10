package game.powerball;

import java.util.Objects;
import java.util.Set;

public class Ticket {
	private Set<Integer> crossedWhite;
	private Set<Integer> crossedRed;

	private Player owner;

	public Ticket(Player owner, Set<Integer> crossedWhite, Set<Integer> crossedRed) {
		this.owner = owner;
		this.crossedRed = crossedRed;
		this.crossedWhite = crossedWhite;
	}

	public Set<Integer> getCrossedWhite() {
		return crossedWhite;
	}

	public Set<Integer> getCrossedRed() {
		return crossedRed;
	}

	public Player getOwner() {
		return owner;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket ticket = (Ticket) obj;
		return Objects.equals(owner, ticket.owner) && Objects.equals(crossedWhite, ticket.crossedWhite)
				&& Objects.equals(crossedRed, ticket.crossedRed);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
