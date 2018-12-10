package games.thegameoflife;

public class Board {

	private int col, row;
	private boolean[][] gameBoard;
	private int gen;


	public Board(int col, int row){
		this.col = col;
		this.row = row;
		gen = 0;
		gameBoard = new boolean[col][row];
	}

	public void setGameBoard(int col, int row, boolean b){
		gameBoard[col][row] = b;
	}

	public boolean get(int col ,int row){
		if (col >= this.col || row >= this.row || col < 0 || row < 0){
			return false;
		}
		return gameBoard[col][row];
	}

	public int getCol(){
		return col;
	}

	public int getRow(){
		return row;
	}

	public int getGeneration(){
		return gen;
	}

	public void increaseGeneration(){
		gen++;
	}

	public void setNewBoard(boolean[][] board){
		gameBoard = board;
	}

	public void fillRandom() {
		for (int i = 0; i < col; i++){
			for (int j = 0; j < row; j++){
				gameBoard[i][j] = Math.round(Math.random()) == 0;
			}
		}
	}
}
