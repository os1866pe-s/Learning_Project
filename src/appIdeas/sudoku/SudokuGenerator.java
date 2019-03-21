package appIdeas.sudoku;

/**
 * Created by Oscar on 2019-03-19.
 */
public class SudokuGenerator {


	public SudokuGenerator() {

	}


	public Sudoku generatedSudoku() {

		Sudoku sudoku = new Sudoku();

		setRandomStartingValues(sudoku);

		SudokuSolver.getInstance().solve(sudoku);

		return sudoku;
	}

	private void setRandomStartingValues(Sudoku sudoku) {

		for (int i = 1; i <= 9; i++){
			sudoku.setNumber((int) (Math.random() * 9 + 1), (int) (Math.random() * 9 + 1), i);
		}


	}

}
