package exTentor;

import java.util.Random;
import java.util.Scanner;

public class Die {

	private Random rand;
	private int lastResult;

	public Die(){
		rand = new Random();
		//May be a good thing to roll it once at the creation.
		roll();
	}

	/** Kastar tärningen */
	public void roll(){
		lastResult = rand.nextInt(6) + 1;
	}

	public int getResult(){
		return lastResult;
	}

	public static void main(String... args){
		Die d = new Die();

		int antalKast;
		int totalResults = 0;

		Scanner userInput = new Scanner(System.in);
		antalKast = userInput.nextInt();


		for(int i = 0; i < antalKast; i++){
			d.roll();
			totalResults += d.getResult();
		}

		System.out.println("Medelvärdet av " + antalKast + " kast med tärningen: " + (double) totalResults / antalKast);

	}
}