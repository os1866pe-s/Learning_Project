package appIdeas.sudoku;

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
		SudokuSolver.solveSudoku(sudoku);

		return sudoku;
	}

	/**
	 *
	 * */
	private static void setRandomStartingValues(Sudoku sudoku) {
		//Might need some more starting values.
		for (int i = 1; i <= 9; i++){
			sudoku.setNumber((int) (Math.random() * 9 + 1), (int) (Math.random() * 9 + 1), i);
		}
	}
}
