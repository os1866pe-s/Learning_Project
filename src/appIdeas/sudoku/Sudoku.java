package appIdeas.sudoku;

import java.util.stream.IntStream;

/**
 * Created by Oscar on 2019-03-19.
 */
public class Sudoku {

	private int[][] board;

	public Sudoku(){
		board = new int[9][9];

	}

	public Sudoku(int[] sudoku){
		//TODO
	}

	public Sudoku(Sudoku sudoku){
		this.board = sudoku.board.clone();
	}

	public Sudoku getSudoku(){
		return this;
	}

	public void setSudokuBoard(Sudoku sudoku){
		this.board = sudoku.board.clone();
	}

	/** Set a number in the board.
	 *
	 * @param x (1-9)the x-coordinate of the position on the board.
	 * @param y (1-9)the y-coordinate of the position on the board.
	 * @param n the number at the position x, y.
	 * */
	public void setNumber(int x, int y, int n){
		board[x - 1][y - 1] = n;
	}

	public int getNumber(int x, int y){
		return board[x - 1][y - 1];
	}

	public int[] getColumn(int y){
		return board[y - 1];
	}

	public void setColumn(int[] array, int y){
		board[y - 1] = array;
	}

	public int[] getRow(int x){

		return IntStream.range(0, 9).map(i -> board[i][x - 1]).toArray();
	}

	public void setRow(int[] array, int x){
		IntStream.range(0, 9).forEach(i -> board[i][x - 1] = array[i]);
	}

	public int[] getBox(int x, int y){
		int[] box = new int[9];

		int n = 0;
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				box[n] = board[i + 3 * (x - 1)][j + 3 * (y - 1)];
				n++;
			}
		}
		return box;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				builder.append(board[j][i]).append(" ");
			}
			builder.append("\n");
		}

		return builder.toString();
	}
}
