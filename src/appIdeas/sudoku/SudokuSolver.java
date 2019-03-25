package appIdeas.sudoku;

import java.util.List;

/**
 * Created by Oscar on 2019-03-19.<br>
 */
public class SudokuSolver {

	public static final String TAG = "SudokuSolver";

	public SudokuSolver(){}

	/**
	 * Solves the sudoku and returns a list of all the solutions to the sudoku.
	 *
	 * @param sudoku the sudoku to be solved.
	 *
	 * @return a list of all possible solutions.
	 * */

	public static List<Sudoku> getAllSolutions(Sudoku sudoku){
		//TODO create an algorithm to solve a sudoku, and when it is solved
		// continue try solve it. If another solution is found store it and
		// return all solution when no more possible moves is left.

		return null;
	}

	/**
	 * If the passed sudoku is valid then the sudoku will be solved.
	 * Otherwise nothing will be done to the passed sudoku.
	 *
	 * @param sudoku the sudoku to be solved. This must be a valid sudoku.
	 * */
	public static void solveSudoku(Sudoku sudoku){
		if (!sudoku.validSudoku()){
			return;
		}

		SudokuSolver t = new SudokuSolver();


		//TODO solve the sudoku

	}

	public static boolean solveFirst(Sudoku sudoku, List<Integer> possibleNumbers ,int... coordinates){


		return true;
	}


	public static List<Cell> getPossibleCells(){
		//TODO return a list of cells with there coordinate and number which
		// is supposed to be in the spot.
		return null;
	}



}
