package appIdeas.sudoku;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by Oscar on 2019-03-19.<br>
 *
 * Provides some very useful methods for sudoku's.
 */
public class SudokuHelper {

	private static final String TAG = "SudokuHelper";

	private static Sudoku defaultSudoku;

	public SudokuHelper(){}

	/**
	 * @return a generated sudoku from random values.
	 * */
	public static Sudoku getRandomSudoku(){

		return SudokuGenerator.generatedSudoku();
	}

	/**
	 * Creates the default sudoku with an algorithm if not done before.<br>
	 *
	 * 6 9 3 7 1 4 8 2 5 <br>
	 * 7 1 4 8 2 5 9 3 6 <br>
	 * 8 2 5 9 3 6 1 4 7 <br>
	 * 9 3 6 1 4 7 2 5 8 <br>
	 * 1 4 7 2 5 8 3 6 9 <br>
	 * 2 5 8 3 6 9 4 7 1 <br>
	 * 3 6 9 4 7 1 5 8 2 <br>
	 * 4 7 1 5 8 2 6 9 3 <br>
	 * 5 8 2 6 9 3 7 1 4 <br>
	 *
	 * @return a clone of the default sudoku.
	 * */
	public static Sudoku getDefaultSudoku(){

		if (defaultSudoku == null){
			Sudoku sudoku = new Sudoku();

			int k = 0;
			for (int i = 1; i <= 9; i++){
				k = ((i - 1) % 3 == 0) ? k + 1 : k;

				for (int j = 1; j <= 9; j++){
					sudoku.setNumber(i, j, (3 * i + j + k) % 9 + 1);
				}
			}

			defaultSudoku = sudoku;
		}
		return defaultSudoku.clone();
	}

	/**
	 * Checks the sudoku and returns false if it found a row, column or
	 * box which is not valid. If the sudoku is valid then true will be returned.
	 *
	 * @param sudoku the sudoku to check.
	 *
	 * @return true if a valid sudoku.
	 * */
	public static boolean validSudoku(Sudoku sudoku){

		for (int i = 1; i <= 9; i++){
			//Row
			if (!validArray(sudoku.getRow(i))){
				return false;
			//Column
			}else if (!validArray(sudoku.getBox((i - 1) % 3 + 1, (i - 1) / 3 + 1))){
				return false;
			//Box
			}else if (!validArray(sudoku.getColumn(i))){
				return false;
			}
		}

		return true;
	}

	/**
	 * This is supposed to scramble a sudoku but currently is not so
	 * good at creating many different sudoku's.
	 *
	 * */
	@Deprecated
	public static void scrambleSudoku(Sudoku sudoku){

		IntStream.range(0, 500).forEach(i -> {
			int rand;

			switch ((int) (Math.random() * 4 + 1)){
				case 1 :
					rand = (int) (Math.random() * 9 + 1);
					switchSudokuRow(sudoku, rand, (rand % 3 == 0) ? rand - 1 : rand + 1);
					break;
				case 2 :
					rand = (int) (Math.random() * 3 + 1);
					switchBigSudokuColumn(sudoku, rand, (rand == 3) ? rand - 1 : rand + 1);
					break;
				case 3 :
					rand = (int) (Math.random() * 9 + 1);
					switchSudokuColumn(sudoku, rand, (rand % 3 == 0) ? rand - 1 : rand + 1);
					break;
				case 4 :
					rand = (int) (Math.random() * 3 + 1);
					switchBigSudokuRow(sudoku, rand, (rand == 3) ? rand - 1 : rand + 1);
					break;
			}});
	}

	/**
	 * Calculates the total amount of numbers matching both the sudoku's.<br>
	 * For example if two of the same sudoku is passed in it will return 81.
	 *
	 * @param sudoku1 the sudoku to be compared with sudoku2.
	 * @param sudoku2 the sudoku to be compared with sudoku1.
	 *
	 * @return amount of matching numbers.
	 */
	public static int matchingNumbers(Sudoku sudoku1, Sudoku sudoku2){
		return IntStream.range(0, 81).filter(i -> sudoku1.getNumber(i % 9 + 1, i / 9 + 1) ==
											sudoku2.getNumber(i % 9 + 1, i / 9 + 1)).toArray().length;
	}

	public static int[] firstEmptyCell(Sudoku sudoku){

		for (int j = 0; j < 9; j++){
			for (int i = 0; i < 9; i++){
				if (sudoku.getNumber(i,j) == 0){
					return new int[]{i, j};
				}
			}
		}

		return null;
	}


	/**
	 * Switches two rows with each other in the sudoku.
	 *
	 * @param sudoku the sudoku which rows will be switched in.
	 * @param row1 the row switched with row2.(1-9)
	 * @param row2 the row switched with row1.(1-9)
	 */
	private static void switchSudokuRow(Sudoku sudoku, int row1, int row2){
		if (row1 == row2){
			return;
		}
		int[] tempRow = sudoku.getRow(row1);
		sudoku.setRow(sudoku.getRow(row2), row1);
		sudoku.setRow(tempRow, row2);
	}

	/**
	 * Switches two columns with each other in the sudoku.
	 *
	 * @param sudoku the sudoku which columns will be switched in.
	 * @param column1 the column switched with column2.(1-9)
	 * @param column2 the column switched with column1.(1-9)
	 */
	private static void switchSudokuColumn(Sudoku sudoku, int column1, int column2){
		int[] tempColumn = sudoku.getColumn(column1);
		sudoku.setColumn(sudoku.getColumn(column2), column1);
		sudoku.setColumn(tempColumn, column2);
	}

	/**
	 * Switches two big columns with each other in the sudoku.
	 *
	 * @param sudoku the sudoku which columns will be switched in.
	 * @param bc1 the big column switched with bc2.(1-3)
	 * @param bc2 the big column switched with bc1.(1-3)
	 */
	private static void switchBigSudokuColumn(Sudoku sudoku, int bc1, int bc2){

		int[] temp1 = sudoku.getColumn(bc1 * 3 - 2);
		sudoku.setColumn(sudoku.getColumn(bc2 * 3 - 2), bc1 * 3 - 2);
		sudoku.setColumn(temp1, bc2 * 3 - 2);

		temp1 = sudoku.getColumn(bc1 * 3 - 1);
		sudoku.setColumn(sudoku.getColumn(bc2 * 3 - 1), bc1 * 3 - 1);
		sudoku.setColumn(temp1, bc2 * 3 - 1);

		temp1 = sudoku.getColumn(bc1 * 3);
		sudoku.setColumn(sudoku.getColumn(bc2 * 3), bc1 * 3);
		sudoku.setColumn(temp1, bc2 * 3);
	}

	/**
	 * Switches two big rows with each other in the sudoku.
	 *
	 * @param sudoku the sudoku which big rows will be switched in.
	 * @param br1 the big row switched with br2.(1-3)
	 * @param br2 the big row switched with br1.(1-3)
	 */
	private static void switchBigSudokuRow(Sudoku sudoku, int br1, int br2){
		int[] temp1 = sudoku.getRow(br1 * 3 - 2);
		sudoku.setRow(sudoku.getRow(br2 * 3 - 2), br1 * 3 - 2);
		sudoku.setRow(temp1, br2 * 3 - 2);

		temp1 = sudoku.getRow(br1 * 3 - 1);
		sudoku.setRow(sudoku.getRow(br2 * 3 - 1), br1 * 3 - 1);
		sudoku.setRow(temp1, br2 * 3 - 1);

		temp1 = sudoku.getRow(br1 * 3);
		sudoku.setRow(sudoku.getRow(br2 * 3), br1 * 3);
		sudoku.setRow(temp1, br2 * 3);
	}

	/**
	 * Checks if and array contains all numbers from 1 to 9.
	 *
	 * @return true if all numbers from 1 to 9 exist in the array.
	 * */
	private static boolean validArray(int[] array){

		if (array.length != 9){
			throw new IllegalArgumentException(TAG + " : array does not have length of 9.");
		}
		int[] temp = new int[9];

		Arrays.stream(array).forEach(i -> {
			if (i > 0) {temp[i - 1]++;}
		});
		return Arrays.stream(temp).filter(i -> i != 1).toArray().length == 0;
	}
}
