package appIdeas.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Oscar on 2019-03-19.<br>
 */
public class SudokuSolver {

	public static final String TAG = "SudokuSolver";

	private static int[] validNumbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

	private static List<Integer> in = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

	private static int sudokus = 0;


	public SudokuSolver() {
	}

	/**
	 * Solves the sudoku and returns a list of all the solutions to the sudoku.
	 *
	 * @param sudoku the sudoku to be solved.
	 * @return a list of all possible solutions.
	 */

	public static List<Sudoku> getAllSolutions(Sudoku sudoku) {
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
	 */
	public static void solveSudoku(Sudoku sudoku) {
		if (!sudoku.isValid()) {
			return;
		}

		solveGeneral(sudoku, 1, 1,1);
		sudokus = 0;

	}

	//TODO
	public static boolean hasSingleSolution(Sudoku sudoku) {
		if (!sudoku.isValid()){
			return false;
		}
		solveGeneral(sudoku.clone(), 2, 1, 1);
		boolean t = sudokus == 1;
		sudokus = 0;
		return t;

	}

	//TODO
	public static boolean hasMoreThanOneSolution(Sudoku sudoku){
		solveGeneral(sudoku.clone(), 2, 1, 1);
		boolean t = (sudokus > 1);
		sudokus = 0;
		return t;
	}
	//TODO
	public static int getSolutionCount(Sudoku sudoku) {
		if (!sudoku.isValid()){
			return 0;
		}
		solveGeneral(sudoku.clone(), 50, 1, 1);
		System.out.println("solutions: " + sudokus);

		int solves = sudokus;
		sudokus = 0;
		return solves;
	}
	//TODO
	private static boolean solveGeneral(Sudoku sudoku, int solutions, int x, int y) {
		Cell cell = sudoku.getNextEmptyCell(x, y);
		if (cell != null) {
			int[] possibleNumbers = sudoku.getPossibleNumbers(cell.x, cell.y);
			//System.out.println(Arrays.toString(possibleNumbers));
			for (int i : possibleNumbers) {
				sudoku.setNumber(cell.x, cell.y, i);

				//System.out.println(i + Arrays.toString(possibleNumbers) + sudoku.isValid() +  "\n" + sudoku.toString());

				boolean t = solveGeneral(sudoku, solutions, cell.x, cell.y);
				//System.out.println(t);
				if (sudokus >= solutions && !t) {
					return false;
				}

				//System.out.println("Continued:" + i + "\n" + sudoku.toString() + " " + cell.x + " " + cell.y);

			}

		} else {
			//Sudoku is full and finished

			//System.out.println("Solution\n" + sudoku.toString());
			sudokus++;
			return false;
		}
		sudoku.setNumber(cell.x, cell.y, 0);
		return true;
	}


	public static List<Cell> getPossibleCells() {
		//TODO return a list of cells with there coordinate and number which
		// is supposed to be in the spot.
		return null;
	}


}
