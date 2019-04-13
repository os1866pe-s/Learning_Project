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

		//do {
			//sudoku.clear();
			setRandomStartingValues(sudoku, 5);

		//}while (SudokuSolver.hasNoSolution(sudoku));

		//System.out.println("RANDOM VALUES:\n" + sudoku.toString());

		SudokuSolver.solveSudoku(sudoku);

		int xi = 1,yi = 1, lastNumber = 1;
		while (SudokuSolver.hasSingleSolution(sudoku)){
			do {
				xi = (int)(Math.random() * 9) + 1;
				yi = (int)(Math.random() * 9) + 1;

			}while (sudoku.getNumber(xi, yi) == 0);
			lastNumber = sudoku.getNumber(xi,yi);
			sudoku.setNumber(xi,yi,0);
			System.out.println("pe");
		}
		//System.out.println("Solutions before last: " + SudokuSolver.getSolutionCount(sudoku));
		sudoku.setNumber(xi,yi,lastNumber);


		//TODO
		return sudoku;
	}



	/**
	 *
	 * */
	public static void setRandomStartingValues(Sudoku sudoku, int quantity) {
		//Might need some more starting values.
		//TODO limit to 81
		for (int i = 0; i < quantity;){
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
