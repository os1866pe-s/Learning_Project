package appIdeas.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Oscar on 2019-03-19.
 */
public class Main {

	public static void main(String[] args) {


		//System.out.println(s.toString()  + "Start:" + s.isValid());


//		long startTime = System.currentTimeMillis();
//		for (int i = 0; i < 10000000; i++){
//			boolean t = s.validArray2(new int[]{1,1,3,3,5,6,7,8,9});
//			//System.out.println(t);
//		}
//		long stopTime = System.currentTimeMillis();
//		System.out.println("Time:" + ((stopTime - startTime)));
		//1058,1057,1013,1036,1033, 1030
		//285


//		List<Sudoku> sudokus = new ArrayList<>();
//
//		long startTime = System.currentTimeMillis();
//
//		//int b = SudokuSolver.getSolutionCount(s);
//		for (int i = 0; i < 1000; i++){
//			Sudoku gs = SudokuGenerator.generatedSudoku();
//			sudokus.add(gs);
//		}
//
//		long stopTime = System.currentTimeMillis();
//		System.out.println("Finished: " + (stopTime - startTime));
//
		//18

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++){
			Sudoku s = new Sudoku();
			SudokuGenerator.setRandomStartingValues(s, 7);
			System.out.println("Start:\n" + s.toString() + s.toLineString());
			List<Sudoku> list = SudokuSolver.getAllSolutions(s);

			for (Sudoku g : list){
				//System.out.println(g.toString());
			}
			System.out.println(list.size() + " : " + i);

		}
		long stopTime = System.currentTimeMillis();
		System.out.println("Finished: " + (stopTime - startTime));


		/*long startTime = System.currentTimeMillis();
		List<Sudoku> sudokus = new ArrayList<>();
		int different = 0;
		int total = 10000;
		boolean t = true;
		for (int i = 0; i < total; i++){

			Sudoku temp = SudokuGenerator.generatedSudoku();
			//SudokuHelper.scrambleSudoku(temp);

			for (Sudoku sudoku1 : sudokus){
				int s = temp.matchingNumbers(sudoku1);
				if (s == 81){
					t = false;

					break;
				}
			}
			//System.out.println(t);
			System.out.println(i + ":" + temp.getNumberQuantity());
//			if (temp.getNumberQuantity() >= 60){
//				System.out.println(temp.toString());
//			}

			if (t){
				different++;
			}
			t = true;
			sudokus.add(temp);
		}
		long stopTime = System.currentTimeMillis();
		System.out.println("Finished: " + (stopTime - startTime));
		System.out.println(different + " " + total + " " + (total - different));
*/

		//12ms/sudoku (10000 gen)
	}
}
