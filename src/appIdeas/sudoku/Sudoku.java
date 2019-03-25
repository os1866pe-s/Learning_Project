package appIdeas.sudoku;

import java.text.MessageFormat;
import java.util.Arrays;
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
	 * all 81 numbers of the sudoku. <br>The numbers should be ordered like:
	 * (1,1), (1,2), (1,3)...
	 *
	 * @param sudoku a one-dimensional array containing 81 numbers.
	 * */
	public Sudoku(int[] sudoku){
		validateArraySize(sudoku, 81);
		validateValues(0,9, sudoku);
		board = new int[9][9];
		IntStream.range(0, 81).forEach(i -> board[i % 9][i / 9] = sudoku[i]);
	}

	/**
	 * Checks the sudoku and returns false if it found a row, column or
	 * box which is not valid.
	 *
	 * @return true if a valid sudoku.
	 * */
	public boolean validSudoku(){

		for (int i = 1; i <= 9; i++){
			//Row
			if (!validArray(getRow(i))){
				return false;
				//Column
			}else if (!validArray(getBox((i - 1) % 3 + 1, (i - 1) / 3 + 1))){
				return false;
				//Box
			}else if (!validArray(getColumn(i))){
				return false;
			}
		}

		return true;
	}

	/**
	 * Calculates the total amount of numbers matching the sudoku.<br>
	 *
	 * @param sudoku the sudoku to be compared with.
	 *
	 * @return amount of matching numbers.
	 */
	public int matchingNumbers(Sudoku sudoku){
		return IntStream.range(0, 81).filter(i -> this.getNumber(i % 9 + 1, i / 9 + 1) ==
				sudoku.getNumber(i % 9 + 1, i / 9 + 1)).toArray().length;
	}

	/**
	 * Sets every cell of the sudoku to the number zero.
	 * */
	public void clear(){
		IntStream.range(0, 81).forEach(i -> board[i % 9][i / 9] = 0);
	}

	//TODO
	public int[] firstEmptyCell(){

		for (int j = 0; j < 9; j++){
			for (int i = 0; i < 9; i++){
				if (getNumber(i,j) == 0){
					return new int[]{i, j};
				}
			}
		}

		return null;
	}


	//TODO
	public int[] getAllNumbers(){
		return Arrays.stream(board).flatMapToInt(Arrays::stream).toArray();
	}

	/**
	 * @return a two-dimensional array identical to the sudokuboard.
	 * */
	public int[][] getBoard(){
		return board.clone();
	}

	/**
	 * Set a number at x, y in the sudokuboard.
	 *
	 * @param x coordinate(1-9) of the position on the board.
	 * @param y coordinate(1-9) of the position on the board.
	 * @param n the number to be placed at position x, y.
	 * */
	public void setNumber(int x, int y, int n){
		validateValues(1,9, x, y, n);
		board[x - 1][y - 1] = n;
	}

	/**
	 * @return the number at x, y on the sudokuboard.
	 *
	 * @param x the x-coordinate(1-9)
	 * @param y the y-coordinate(1-9)
	 * */
	public int getNumber(int x, int y){
		validateValues(1,9,x,y);
		return board[x - 1][y - 1];
	}

	/**
	 * @param array the list of numbers to be set at the column(1-9).<br>
	 *               Array should have a length of 9 with all numbers between 1-9.
	 * @param y the column(1-9) the array will be set at.
	 * */
	public void setColumn(int[] array, int y){
		validateValues(1, 9, y);
		validateValues(0, 9, array);
		validateArraySize(array, 9);
		board[y - 1] = array;
	}

	/**
	 * @param y the column(1-9) which will be returned.
	 * @return values of column y of the sudokuboard.
	 * */
	public int[] getColumn(int y){
		validateValues(1,9,y);
		return board[y - 1].clone();
	}

	/**
	 * @param array the list of numbers to be set at the row(1-9).<br>
	 *               Array should have a length of 9 with all numbers between 1-9.
	 * @param x the row(1-9) the array will be set at.
	 * */
	public void setRow(int[] array, int x){
		validateValues(1,9,x);
		validateValues(0,9,array);
		validateArraySize(array, 9);
		IntStream.range(0, 9).forEach(i -> board[i][x - 1] = array[i]);
	}

	/**
	 * @param x the row(1-9) which will be returned.
	 * @return values of row x of the sudokuboard.
	 * */
	public int[] getRow(int x){
		validateValues(1, 9, x);
		return IntStream.range(0, 9).map(i -> board[i][x - 1]).toArray();
	}

	/**
	 * This will replace all numbers in the x,y 3*3 box with the values from the array.<br>
	 * Order the values like (x,y): (1,1), (1,2), (1,3), (2,1)...
	 *
	 * @param array the array with values which will be set.
	 * @param x coordinate of box.
	 * @param y coordinate of box.
	 * */
	public void setBox(int[] array, int x ,int y){
		validateValues(1, 3, x, y);
		validateValues(0,9,array);
		validateArraySize(array, 9);
		IntStream.range(0, 9).forEach(i -> {

			int xi = (x - 1) * 3 + (i % 3);
			int yi = (y - 1) * 3 + (i / 3);
			board[xi][yi] = array[i];
		});
	}

	/**
	 * This will gather all numbers in the x,y 3*3 box and return an array
	 * of all the numbers.<br>
	 * Order of values (x,y): (1,1), (1,2), (1,3), (2,1)...
	 *
	 * @param y coordinate of the box.
	 * @param x coordinate of the box.
	 *
	 * @return an array of all numbers in the box.
	 * */
	public int[] getBox(int x, int y){
		validateValues(1, 3, x, y);
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
	 * Switches two rows with each other in the sudoku.
	 *
	 * @param row1 the row switched with row2.(1-9)
	 * @param row2 the row switched with row1.(1-9)
	 */
	public void switchRows(int row1, int row2){
		validateValues(1,9, row1, row2);
		if (row1 == row2){ return; }

		int[] tempRow = getRow(row1);
		setRow(getRow(row2), row1);
		setRow(tempRow, row2);
	}

	/**
	 * Switches two columns with each other in the sudoku.
	 *
	 * @param column1 the column switched with column2.(1-9)
	 * @param column2 the column switched with column1.(1-9)
	 */
	public void switchColumns(int column1, int column2){
		validateValues(1,9,column1, column2);
		int[] tempColumn = getColumn(column1);
		setColumn(getColumn(column2), column1);
		setColumn(tempColumn, column2);
	}

	/**
	 * Switches two big columns with each other in the sudoku.
	 *
	 * @param bc1 the big column switched with bc2.(1-3)
	 * @param bc2 the big column switched with bc1.(1-3)
	 */
	public void switchBigColumns(int bc1, int bc2){
		validateValues(1,3,bc1, bc2);
		int[] temp1 = getColumn(bc1 * 3 - 2);
		setColumn(getColumn(bc2 * 3 - 2), bc1 * 3 - 2);
		setColumn(temp1, bc2 * 3 - 2);

		temp1 = getColumn(bc1 * 3 - 1);
		setColumn(getColumn(bc2 * 3 - 1), bc1 * 3 - 1);
		setColumn(temp1, bc2 * 3 - 1);

		temp1 = getColumn(bc1 * 3);
		setColumn(getColumn(bc2 * 3), bc1 * 3);
		setColumn(temp1, bc2 * 3);
	}

	/**
	 * Switches two big rows with each other in the sudoku.
	 *
	 * @param br1 the big row switched with br2.(1-3)
	 * @param br2 the big row switched with br1.(1-3)
	 */
	public void switchBigRows(int br1, int br2){
		validateValues(1,3,br1, br2);
		int[] temp1 = getRow(br1 * 3 - 2);
		setRow(getRow(br2 * 3 - 2), br1 * 3 - 2);
		setRow(temp1, br2 * 3 - 2);

		temp1 = getRow(br1 * 3 - 1);
		setRow(getRow(br2 * 3 - 1), br1 * 3 - 1);
		setRow(temp1, br2 * 3 - 1);

		temp1 = getRow(br1 * 3);
		setRow(getRow(br2 * 3), br1 * 3);
		setRow(temp1, br2 * 3);
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

	/**
	 * Checks if and array contains all numbers from 1 to 9.
	 *
	 * @return true if all numbers from 1 to 9 exist in the array.
	 * */
	private boolean validArray(int[] array){
		validateArraySize(array, 9);

		int[] amountOfDifferentNumbers = new int[9];
		Arrays.stream(array).forEach(i -> {
			if (i > 0) {amountOfDifferentNumbers[i - 1]++;}
		});
		return Arrays.stream(amountOfDifferentNumbers).anyMatch(i -> i > 1);
	}

	/**
	 * Validates if the values are in the expected range.
	 * If any value is out of range IllegalArgumentException is thrown.
	 *
	 * @param expectedMin the lowest accepted value.
	 * @param expectedMax the highest accpeted value.
	 * @param values the values to be checked.
	 * */
	private void validateValues(int expectedMin, int expectedMax, int... values){
		if (Arrays.stream(values).anyMatch(i -> i < expectedMin || i > expectedMax)){
			throw new IllegalArgumentException(MessageFormat.format(
					"Index is out of range. Expected values {0}-{1} but got {2}"
					,expectedMin, expectedMax, Arrays.toString(values)));
		}
	}

	/**
	 * Validates size of array. If out of bounds IllegalArgument is thrown.
	 *
	 * @param array the array to be checked.
	 * @param expectedLength the expected length of the array.
	 * */
	private void validateArraySize(int[] array, int expectedLength){
		if (array.length != expectedLength){
			throw new IllegalArgumentException(MessageFormat.format(
					"Incorrect length of array. Expected size {0} but got {1}: {2}",
					expectedLength, array.length, Arrays.toString(array)));
		}
	}
}
