package appIdeas.sudoku;

import java.util.Arrays;

/**
 * Created by Oscar on 2019-03-19.
 */
public class Main {

	public static void main(String[] args) {

		SudokuHelper helper = new SudokuHelper();

		Sudoku sudoku = helper.getDefaultSudoku();


		System.out.println(sudoku.toString());
		System.out.println(helper.validSudoku(sudoku));

		helper.scrambleSudoku(sudoku);
		System.out.println(sudoku.toString());

		double k = 0;
		double same = 0;
		for (int i = 0; i < 10000; i++){
			Sudoku sudoku1 = helper.getRandomSudoku();


			helper.scrambleSudoku(sudoku1);
			int u = helper.matchingNumbers(sudoku1, helper.getDefaultSudoku());
			if (u == 81){
				same++;
			}
			k += u;
			//System.out.println(u);
			//System.out.println(sudoku1.toString());
		}
		System.out.println(k / (10000 * 81) + " " + same);

		//28000 sudoku's until you will solver the same
	}
}
