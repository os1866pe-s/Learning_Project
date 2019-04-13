package appIdeas.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Oscar on 2019-03-19.<br>
 */
public class SudokuSolver {

	public static final String TAG = "SudokuSolver";

	private static List<Integer> in = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

	private static int solutions = 0;

	private static List<Sudoku> sudokuList;

	public SudokuSolver() {
	}

	/**
	 * Solves the sudoku and returns a list of all the solutions to the sudoku.
	 *
	 * @param sudoku the sudoku to be solved.
	 * @return a list of all possible solutions.
	 */

	public static List<Sudoku> getAllSolutions(Sudoku sudoku) {
		sudokuList = new ArrayList<>();

		solveGeneral(sudoku,500,1,1);
		solutions = 0;
		List<Sudoku> solutionList = sudokuList.subList(0, sudokuList.size());
		sudokuList = null;
		return solutionList;
	}

	/**
	 * If the passed sudoku is valid then the sudoku will be solved.
	 * Otherwise nothing will be done to the passed sudoku.
	 *
	 * @param sudoku the sudoku to be solved. This must be a valid sudoku.
	 */
	public static void solveSudoku(Sudoku sudoku) {

		solveGeneral(sudoku, 1, 1,1);
		solutions = 0;
	}

	/**
	 * Checks if the given sudoku has a single solution.
	 *
	 * @return if the sudoku has one and only solution.
	 * */
	public static boolean hasSingleSolution(Sudoku sudoku) {

		solveGeneral(sudoku.clone(), 2, 1, 1);
		boolean t = solutions == 1;
		solutions = 0;
		return t;

	}

	/**
	 * Checks if the given sudoku has more than one solution.
	 *
	 * @return if the sudoku has more than one solution.
	 * */
	public static boolean hasMoreThanOneSolution(Sudoku sudoku){
		solveGeneral(sudoku.clone(), 2, 1, 1);
		boolean t = (solutions > 1);
		solutions = 0;
		return t;
	}

	/**
	 * Checks the amount of solutions to the given sudoku.<br>
	 * If solutions is more than 100 then 100 will be returned.
	 *
	 * @return the total amount of solutions to the sudoku.
	 * */
	public static int getSolutionCount(Sudoku sudoku) {
		if (!sudoku.isValid()){
			return 0;
		}
		solveGeneral(sudoku.clone(), 100, 1, 1);

		int solves = solutions;
		solutions = 0;
		return solves;
	}

	/**
	 * Checks if the given sudoku has no solutions.
	 *
	 * @return if the sudoku has no solution.
	 * */
	public static boolean hasNoSolution(Sudoku sudoku) {
		solveGeneral(sudoku,1,1,1);
		if (solutions == 0){
			return true;
		}
		solutions = 0;
		return false;
	}

	//TODO has to be checked for improvements
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
				if (SudokuSolver.solutions >= solutions && !t) {
					return false;
				}

				//System.out.println("Continued:" + i + "\n" + sudoku.toString() + " " + cell.x + " " + cell.y);

			}

		} else {
			//Sudoku is full and finished

			//System.out.println("Solution\n" + sudoku.toString());
			SudokuSolver.solutions++;
			if (sudokuList != null){
				sudokuList.add(sudoku.clone());
			}
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
