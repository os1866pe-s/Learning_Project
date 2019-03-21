package appIdeas.sudoku;

/**
 * Created by Oscar on 2019-03-19.
 */
public class SudokuFactory {

	enum Difficulty{
		Easy, Medium, Hard
	}

	//TODO
	public static Sudoku getGeneratedSudoku(Difficulty difficulty){

		switch (difficulty){
			case Easy:

				break;
			case Medium:

				break;
			case Hard:

				break;
		}

		return null;
	}

	//TODO Get pdf with sudokus
	public void generatePDF(Difficulty... difficulties){
		for (Difficulty dif : difficulties){
			Sudoku sudoku = getGeneratedSudoku(dif);
		}
	}



}
