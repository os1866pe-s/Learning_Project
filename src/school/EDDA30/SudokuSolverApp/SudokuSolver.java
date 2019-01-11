package school.EDDA30.SudokuSolverApp;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuSolver {

	//private BoardEvent boardEvent;

	//public static final int TWENTYFIVE = 25;
	public static final int SIXTEN = 16;
	public static final int NINE = 9;
	public static final int FOUR = 4;

	public static int size;
	public static int sizeSqrt;

	private int[][] sudokuBoard;
	private int[][] solvingBoard;

	private int score = 0;

	public SudokuSolver(int size) {
		this.size = size;
		sudokuBoard = new int[size][size];
		sizeSqrt = (int) Math.sqrt(size);
	}

	public void setSudokuBoard(int[][] board) {
		this.sudokuBoard = board.clone();
		this.solvingBoard = board.clone();
	}

	public int getTile(int x, int y) {
		return sudokuBoard[x - 1][y - 1];
	}

	public void setTile(int x, int y, int num) {
		sudokuBoard[x - 1][y - 1] = num;
	}

	public void clearTiles() {
		IntStream.range(0, size * size)
				.forEach(x -> sudokuBoard[x % size][x / size] = 0);

	}


	//TODO create a animated solve
	//TODO create a solve which uses the standard visual rules: if one spot only can contain 1 item add it...
	private boolean solve(int[] xy) {
		if (Arrays.stream(xy).filter(h -> h >= size).count() > 0) {
			return true;
		}
		int[] availableNumbers = getAvailableNumbers(xy[0], xy[1]);

		//DEBUG System.out.println("Available: " + Arrays.toString(availableNumbers));
		for (int i : availableNumbers) {
			setSpot(xy[0], xy[1], i);
			score++;
			System.out.println(score);
			int[] g = nextEmptySpot();

			if (Arrays.stream(g).filter(x -> x >= size).count() > 0 || solve(g)) {
				return true;
			}
			setSpot(xy[0], xy[1], 0);
		}
		return false;
	}


	public int[][] getSolvedBoard() {
		score = 0;
		solvingBoard = new int[size][size];
		IntStream.range(0, size * size).forEach(x ->
				solvingBoard[x % size][x / size] = sudokuBoard[x % size][x / size]);

		solve(nextEmptySpot());

		return solvingBoard;

	}


	private void setSpot(int x, int y, int i) {
		solvingBoard[x][y] = i;
	}

	private int[] nextEmptySpot() {
		try {
			int a = IntStream.range(0, size * size)
					.filter(x -> solvingBoard[x % size][x / size] == 0)
					.findFirst().getAsInt();
			//DEBUG System.out.println(a % size + " " + a / size);
			return new int[]{a % size, a / size};
		} catch (NoSuchElementException e) {
			//e.printStackTrace();
			return new int[]{size, size};
		}
	}

	/**
	 * from 0 - 8
	 */
	private int[] getAvailableNumbers(int x, int y) {
		int[] availableNumbers = new int[size];
		IntStream.range(0, size).forEach(e -> availableNumbers[e] = e + 1);

		int xb = (x / sizeSqrt) * sizeSqrt;
		int yb = (y / sizeSqrt) * sizeSqrt;

		IntStream.range(0, size).forEach(v -> {
			//Check vertical
			if (solvingBoard[x][v] > 0) {
				availableNumbers[solvingBoard[x][v] - 1] = 0;

			}
			//Check horizontal
			if (solvingBoard[v][y] > 0) {
				availableNumbers[solvingBoard[v][y] - 1] = 0;

			}
			//Check box
			if (solvingBoard[xb + v % sizeSqrt][yb + v / sizeSqrt] > 0) {
				availableNumbers[solvingBoard[xb + (v % sizeSqrt)][yb + (v / sizeSqrt)] - 1] = 0;

			}
		});

		int[] t = Arrays.stream(availableNumbers)
				.filter(h -> h != 0)
				.toArray();
		return t;
	}

	public boolean isValid() {
		for (int i = 0; i < size; i++) {
			if (!validVertical(i) || !validHorizontal(i) || !validBox(i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 0 - 8
	 */
	private boolean validVertical(int i) {
		int[] oneToNine = new int[size];
		IntStream.range(0, size).forEach(y -> {
			if (solvingBoard[i][y] > 0) {
				oneToNine[solvingBoard[i][y] - 1]++;
			}
		});

		return !(Arrays.stream(oneToNine)
				.filter(y -> y > 1).count() > 0);
	}

	/**
	 * 0 - 8
	 */
	private boolean validHorizontal(int i) {
		int[] oneToNine = new int[size];
		IntStream.range(0, size).forEach(x -> {
			if (solvingBoard[x][i] > 0) {
				oneToNine[solvingBoard[x][i] - 1]++;
			}
		});

		return !(Arrays.stream(oneToNine)
				.filter(x -> x > 1).count() > 0);
	}

	/**
	 * 0 - 8
	 */
	private boolean validBox(int i) {
		int xi = (i % sizeSqrt) * sizeSqrt;
		int yi = (i / sizeSqrt) * sizeSqrt;

		int[] oneToNine = new int[size];
		IntStream.range(0, size).forEach(b -> {
			if (solvingBoard[xi + b % sizeSqrt][yi + b / sizeSqrt] > 0) {
				oneToNine[solvingBoard[xi + b % sizeSqrt][yi + b / sizeSqrt] - 1]++;

			}
		});

		return !(Arrays.stream(oneToNine)
				.filter(x -> x > 1).count() > 0);
	}
}
