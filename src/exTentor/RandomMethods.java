package exTentor;

import java.util.Random;

public class RandomMethods {

	public static void main(String[] args) {
		System.out.println(jumpUtilOutside());

	}

	public static int jumpUtilOutside(){
		int x = 10;
		int y = 10;
		int jumps = 0;
		Random rand = new Random();

		while (x <= 20 && x >= 0 && y <= 20 && y >= 0){
			int i = rand.nextInt(4);
			switch (i){
				case 0: x++; break;
				case 1: x--; break;
				case 2: y++; break;
				case 3: y--; break;
			}

			System.out.println("x-" + x + " y-" +
					"" + y);
			jumps++;
		}
		return jumps;
	}
}
