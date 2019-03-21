package appIdeas.sudoku;

import java.util.stream.IntStream;

/**
 * Created by Oscar on 2019-03-19.<Br>
 *
 * A sudoku is a two-dimensional grid with a size of 9*9.
 * Containing various methods to easily manipulate a sudoku.
 */
public class Sudoku {

	/**
	 * The sudokuboard containing all the numbers of the sudoku
	 * in a two-dimensional array.
	 * */
	private int[][] board;

	/**
	 * Creates a empty sudoku filled with zero's.
	 * */
	public Sudoku(){
		board = new int[9][9];
	}

	/**
	 * Creates a sudoku from a one-dimensional array containing
	 * all 81 numbers of the sudoku. <Br>The numbers should be ordered like:
	 * (1,1), (2,1), (3,1)...
	 *
	 * @param sudoku a one-dimensional array containing 81 numbers.
	 * */
	public Sudoku(int[] sudoku){
		board = new int[9][9];
		IntStream.range(0, 81).forEach(i -> board[i % 9][i / 9] = sudoku[i]);
	}

	/** Set a number at x, y in the sudokuboard.
	 *
	 * @param x coordinate(1-9) of the position on the board.
	 * @param y coordinate(1-9) of the position on the board.
	 * @param n the number at the position x, y.
	 * */
	public void setNumber(int x, int y, int n){
		board[x - 1][y - 1] = n;
	}

	/**
	 * @return the number at x, y on the sudokuboard.
	 *
	 * @param x the x-coordinate(1-9)
	 * @param y the y-coordinate(1-9)
	 * */
	public int getNumber(int x, int y){
		return board[x - 1][y - 1];
	}

	/**
	 * @param array the list of numbers to be set at the column(1-9).<br>
	 *               Array should have a length of 9 with all numbers between 1-9.
	 * @param y the column(1-9) the array will be set at.
	 * */
	public void setColumn(int[] array, int y){
		board[y - 1] = array;
	}


	/**
	 * @param y the column(1-9) which will be returned.
	 * @return column y of the sudokuboard.
	 * */
	public int[] getColumn(int y){
		return board[y - 1];
	}

	/**
	 * @param array the list of numbers to be set at the row(1-9).<br>
	 *               Array should have a length of 9 with all numbers between 1-9.
	 * @param x the row(1-9) the array will be set at.
	 * */
	public void setRow(int[] array, int x){
		IntStream.range(0, 9).forEach(i -> board[i][x - 1] = array[i]);
	}

	/**
	 * @param x the row(1-9) which will be returned.
	 * @return row x of the sudokuboard.
	 * */
	public int[] getRow(int x){
		return IntStream.range(0, 9).map(i -> board[i][x - 1]).toArray();
	}

	/**
	 * This will gather all numbers in the x,y 3*3 box and return an array
	 * of all the numbers.
	 *
	 * @param y coordinate of the box.
	 * @param x coordinate of the box.
	 *
	 * @return an array of all numbers in the box.
	 * */
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

	/**
	 * @return a string representing the sudoku.
	 * */
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

	/**
	 * Creates a clone of the sudoku and returns it.
	 *
	 * @return a clone of the sudoku.
	 * */
	@Override
	public Sudoku clone(){
		Sudoku sudoku = new Sudoku();
		sudoku.board = this.board.clone();
		return sudoku;
	}
}
