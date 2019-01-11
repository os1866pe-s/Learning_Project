package exTentor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Player {

	private int iNbr;
	private Dice dice;
	private int position;

	public Player(int iNbr, Dice iD){
		this.iNbr = iNbr;
		dice = iD;
		position = 1;
	}

	public int getNbr(){
		return iNbr;
	}

	public int getPos(){
		return position;
	}

	public void move(){
		position += dice.roll();
	}

	public void setPosToStart(){
		position = 1;
	}


	public static void main(String[] args) {
		Dice dice = new Dice();
		int furthest = 1;

		int nbr = 4;

		List<Player> players = IntStream.rangeClosed(1, nbr)
				.mapToObj(x -> new Player(x, dice))
				.collect(Collectors.toList());

		while (furthest <= 100){
			for (Player current : players){
				current.move();


				players.stream()
						.filter(p -> p.getPos() == current.getPos() && p != current)
						.forEach(Player::setPosToStart);
//				for (Player p : players){
//					if (p.getPos() == current.getPos() && p != current){
//						p.setPosToStart();
//					}
//				}

				if (current.getPos() > furthest){
					furthest = current.getPos();
					if (furthest > 100){
						System.out.println("Player " + current.getNbr() +
									" won the game with " +current.getPos() + " moves.");
						break;
					}
				}
			}
		}

	}
}
