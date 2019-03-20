package appIdeas.sudoku;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by Oscar on 2019-03-19.
 */
public class SudokuHelper {

	private String defaultSudoku;

	public SudokuHelper() {
	}

	public Sudoku getRandomSudoku(){
		Sudoku sudoku = new Sudoku();

		int k = 0;

		int numberModifier = (int) (Math.random() * 9 + 1);
		for (int i = 1; i <= 9; i++){
			k = ((i - 1) % 3 == 0) ? k + 1 : k;

			for (int j = 1; j <= 9; j++){
				sudoku.setNumber(i, j, (3 * i + j + k + numberModifier) % 9 + 1);
			}
		}
		scrambleSudoku(sudoku);

		return sudoku;
	}

	public Sudoku getDefaultSudoku(){
		//TODO optimise so it only has to generate it once
		Sudoku sudoku = new Sudoku();

		int k = 0;
		for (int i = 1; i <= 9; i++){
			k = ((i - 1) % 3 == 0) ? k + 1 : k;

			for (int j = 1; j <= 9; j++){
				sudoku.setNumber(i, j, (3 * i + j + k) % 9 + 1);
			}
		}
		return sudoku;
	}

	public boolean validSudoku(Sudoku sudoku){


		for (int i = 1; i <= 9; i++){
			//Row
			if (!validArray(sudoku.getRow(i))){
				return false;
			//Column
			}else if (!validArray(sudoku.getBox((i - 1) % 3 + 1, (i - 1) / 3 + 1))){
				return false;
			//Box
			}else if (!validArray(sudoku.getColumn(i))){
				return false;
			}
		}

		return true;
	}

	public void scrambleSudoku(Sudoku sudoku){

		IntStream.range(0, 100).forEach(i -> {

			int rand = (int) (Math.random() * 9 + 1);
			switchSudokuRow(sudoku, rand, (rand % 3 == 0) ? rand - 1 : rand + 1);

			rand = (int) (Math.random() * 3 + 1);
			switchBigSudokuColumn(sudoku, rand, (rand == 3) ? rand - 1 : rand + 1);


			rand = (int) (Math.random() * 9 + 1);
			switchSudokuColumn(sudoku, rand, (rand % 3 == 0) ? rand - 1 : rand + 1);

			rand = (int) (Math.random() * 3 + 1);
			switchBigSudokuRow(sudoku, rand, (rand == 3) ? rand - 1 : rand + 1);




		});

	}

	public int matchingNumbers(Sudoku sudoku1, Sudoku sudoku2){
		return IntStream.range(0, 81).filter(i -> sudoku1.getNumber(i % 9 + 1, i / 9 + 1) ==
											sudoku2.getNumber(i % 9 + 1, i / 9 + 1)).toArray().length;
	}

	private void switchSudokuRow(Sudoku sudoku, int r1, int r2){
		int[] row1 = sudoku.getRow(r1);
		sudoku.setRow(sudoku.getRow(r2), r1);
		sudoku.setRow(row1, r2);
	}

	private void switchSudokuColumn(Sudoku sudoku, int c1, int c2){
		int[] row1 = sudoku.getColumn(c1);
		sudoku.setColumn(sudoku.getColumn(c2), c1);
		sudoku.setColumn(row1, c2);
	}

	private void switchBigSudokuColumn(Sudoku sudoku, int bc1, int bc2){

		int[] temp1 = sudoku.getColumn(bc1 * 3 - 2);
		sudoku.setColumn(sudoku.getColumn(bc2 * 3 - 2), bc1 * 3 - 2);
		sudoku.setColumn(temp1, bc2 * 3 - 2);

		temp1 = sudoku.getColumn(bc1 * 3 - 1);
		sudoku.setColumn(sudoku.getColumn(bc2 * 3 - 1), bc1 * 3 - 1);
		sudoku.setColumn(temp1, bc2 * 3 - 1);

		temp1 = sudoku.getColumn(bc1 * 3);
		sudoku.setColumn(sudoku.getColumn(bc2 * 3), bc1 * 3);
		sudoku.setColumn(temp1, bc2 * 3);
	}

	private void switchBigSudokuRow(Sudoku sudoku, int br1, int br2){
		int[] temp1 = sudoku.getRow(br1 * 3 - 2);
		sudoku.setRow(sudoku.getRow(br2 * 3 - 2), br1 * 3 - 2);
		sudoku.setRow(temp1, br2 * 3 - 2);

		temp1 = sudoku.getRow(br1 * 3 - 1);
		sudoku.setRow(sudoku.getRow(br2 * 3 - 1), br1 * 3 - 1);
		sudoku.setRow(temp1, br2 * 3 - 1);

		temp1 = sudoku.getRow(br1 * 3);
		sudoku.setRow(sudoku.getRow(br2 * 3), br1 * 3);
		sudoku.setRow(temp1, br2 * 3);
	}

	private boolean validArray(int[] array){

		int[] temp = new int[9];

		Arrays.stream(array).forEach(i -> temp[i - 1]++);
		return Arrays.stream(temp).filter(i -> i != 1).toArray().length == 0;
	}


}
