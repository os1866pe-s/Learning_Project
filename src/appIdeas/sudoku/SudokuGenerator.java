package appIdeas.sudoku;

import java.util.Arrays;

/**
 * Created by Oscar on 2019-03-19.<br>
 *
 * Provides methods for generating random sudoku's.
 */
public class SudokuGenerator {

	public static final String TAG = "SudokuGenerator";

	public SudokuGenerator(){}

	public static Sudoku generatedSudoku() {

		Sudoku sudoku = new Sudoku();
		setRandomStartingValues(sudoku);

		System.out.println("RANDOM VALUES:\n" + sudoku.toString());
		SudokuSolver.solveSudoku(sudoku);

		//TODO
		return sudoku;
	}



	/**
	 *
	 * */
	public static void setRandomStartingValues(Sudoku sudoku) {
		//Might need some more starting values.

		for (int i = 0; i < 16;){
			int xi, yi;
			do {
				xi = (int)(Math.random() * 9) + 1;
				yi = (int)(Math.random() * 9) + 1;

			}while (sudoku.getNumber(xi, yi) != 0);
			sudoku.setNumber(xi, yi, i % 9 + 1);
			if (!sudoku.isValid()){
				sudoku.setNumber(xi, yi, 0);
			}else{
				i++;
			}

		}
	}
}
