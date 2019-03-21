package appIdeas.sudoku;

import java.util.List;

/**
 * Created by Oscar on 2019-03-19.<br>
 */
public class SudokuSolver {

	private static SudokuSolver solver;

	private SudokuSolver(){}

	public static SudokuSolver getInstance(){
		if (solver == null){
			solver = new SudokuSolver();
		}
		return solver;
	}

	public Sudoku solve(Sudoku sudoku){
		//TODO
		return null;
	}

	public List<Cell> getPossibleCells(){
		//TODO return a list of cells with there coordinate and number which
		// is supposed to be in the spot.
		return null;
	}



}
