package appIdeas.sudoku;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by Oscar on 2019-03-19.<br>
 */
public class SudokuHelper {

	private static final String TAG = "SudokuHelper";

	private static Sudoku defaultSudoku;

	public SudokuHelper(){}

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
	 * This is supposed to scramble a sudoku but currently is not so
	 * good at creating many different sudoku's.
	 *
	 * */
	public static void scrambleSudoku(Sudoku sudoku){

		IntStream.range(0, 10).forEach(i -> {
			int rand;

			switch ((int) (Math.random() * 4 + 1)){
				case 1 :
					rand = (int) (Math.random() * 9 + 1);
					sudoku.switchRows(rand, (rand % 3 == 0) ? rand - 1 : rand + 1);
					break;
				case 2 :
					rand = (int) (Math.random() * 9 + 1);
					sudoku.switchColumns(rand, (rand % 3 == 0) ? rand - 1 : rand + 1);
					break;

				case 3 :
					rand = (int) (Math.random() * 3 + 1);
					sudoku.switchBigColumns(rand, (rand == 3) ? rand - 1 : rand + 1);
					break;

				case 4 :
					rand = (int) (Math.random() * 3 + 1);
					sudoku.switchBigRows(rand, (rand == 3) ? rand - 1 : rand + 1);
					break;
			}}
		);
	}

}
