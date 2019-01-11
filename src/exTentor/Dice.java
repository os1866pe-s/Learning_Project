package exTentor;

import java.util.Random;

public class Dice {

	private int dots;
	private Random rand = new Random();

	public Dice(){
		roll();
	}

	public int roll(){
		dots = rand.nextInt(6) + 1;
		return dots;
	}
}
