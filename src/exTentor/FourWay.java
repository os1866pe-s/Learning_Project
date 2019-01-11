package exTentor;

import java.util.Scanner;

public class FourWay{

	private int[][] board;
	private int n;

	public FourWay(int n){
		board = new int[n][n];
		this.n = n;
	}

	public void init(){
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				board[i][j] = 1;
			}
		}
	}

	public void oneRound(){
		int x = n / 2;
		int y = n / 2;

		while(x >= 0 && x < n && y >= 0 && y < n){
			int num = board[x][y];
			switch(num){
				case 1:
					board[x][y]++;
					y--;
					break;
				case 2:
					board[x][y]++;
					x++;
					break;
				case 3:
					board[x][y]++;
					y++;
					break;
				case 4:
					board[x][y] = 1;
					x--;
					break;
			}

		}
	}

	public boolean allOnes(){
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if (board[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String... args){

		Scanner userInput = new Scanner(System.in);
		int n = userInput.nextInt();
		FourWay fw = new FourWay(n);
		fw.init();

		int games = 0;
		
		while(!fw.allOnes() || games == 0){
			fw.oneRound();

			games++;
		}

		System.out.println("Det krävdes " + games + " antal omgångar.");
	}
}