package appIdeas.sudoku;

import java.util.Arrays;

/**
 * Created by Oscar on 2019-03-19.
 */
public class Main {

	public static void main(String[] args) {

		Sudoku s = new Sudoku();
		Sudoku t = new Sudoku();
		//SudokuGenerator.setRandomStartingValues(s);
		System.out.println(s.toString()  + "Start:" + s.isValid());


//		long startTime = System.currentTimeMillis();
//		for (int i = 0; i < 10000000; i++){
//			boolean t = s.validArray2(new int[]{1,1,3,3,5,6,7,8,9});
//			//System.out.println(t);
//		}
//		long stopTime = System.currentTimeMillis();
//		System.out.println("Time:" + ((stopTime - startTime)));
		//1058,1057,1013,1036,1033, 1030
		//285

		Sudoku gs = SudokuGenerator.generatedSudoku();
		System.out.println(gs.toString() + "Finished:"+SudokuSolver.getSolutionCount(gs));


//		long startTime = System.nanoTime();
//
//		int b = SudokuSolver.getSolutionCount(s);
//		long stopTime = System.nanoTime();
//		System.out.println(b + " Time:" + (stopTime - startTime) / 1000000d );
//



		//18
/*

		List<Sudoku> sudokus = new ArrayList<>();
		int different = 0;
		int total = 14000;
		boolean t = true;
		for (int i = 0; i < total; i++){

			Sudoku temp = SudokuHelper.getDefaultSudoku();
			SudokuHelper.scrambleSudoku(temp);

			for (Sudoku sudoku1 : sudokus){
				int s = temp.matchingNumbers(sudoku1);
				if (s == 81){
					t = false;

					break;
				}
			}
			//System.out.println(t);

			if (t){
				different++;
			}
			t = true;
			sudokus.add(temp);
		}

		System.out.println(different + " " + total + " " + (total - different));
*/



	}
}
