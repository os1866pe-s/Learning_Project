package appIdeas.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Oscar on 2019-03-19.
 */
public class Main {

	public static void main(String[] args) {

		System.out.println(SudokuHelper.getDefaultSudoku().toString());

		/*
		List<Sudoku> sudokus = new ArrayList<>();

		int different = 0;
		int total = 5000;
		boolean t = true;
		for (int i = 0; i < total; i++){

			Sudoku temp = helper.getRandomSudoku();

			for (Sudoku sudoku1 : sudokus){
				if ((helper.matchingNumbers(sudoku1, temp) == 81)){
					t = false;
					break;
				}
			}
			System.out.println(t);

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
