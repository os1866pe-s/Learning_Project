package school.EDDA30.SudokuSolverApp;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

/**
 * Made bu Oscar.P 2019-10-(8-9)
 * Took 1 and a half day to complete. (~500 lines of code)
 * The first day the UI was done and then the algorithm
 * was implemented in around ~3h the day after.
 * Some further improvements can be made, just read the TODOs.
 * */


//TODO FUTURE: Make this as android app.

//TODO create a versatile Sudoku with 4 * 4, 9 * 9, 16 * 16...
//TODO create crossSudoku, 5 in 1...

//TODO general refactoring

public class SudokuView extends Application {

	private Pane root;

	private static SudokuSolver sudokuSolver = new SudokuSolver(SudokuSolver.SIXTEN);

	private static final int WIDTH = 600, HEIGHT = WIDTH + 75;
	private final int tilewidth = WIDTH / SudokuSolver.size;
	private final String numberDarkBackgroundColor = "74B8D6";
	private final String numberWhiteBackgroundColor = "BFE7F3";

	private SudokuTile[][] tiles;

	private Button btnSolve, btnClear;


	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("SudokuSolver");
		Scene scene = new Scene(createContext());
		scene.getStylesheets().add("school/EDDA30/SudokuSolverApp/style.css");

		stage.setScene(scene);
		stage.setMaxWidth(WIDTH + 6);

		stage.setResizable(false);
		stage.show();

	}

	private Parent createContext() {
		root = new Pane();
		root.setPrefSize(WIDTH, HEIGHT - 10);

		//Background
		Rectangle rect1 = new Rectangle(0, 0, WIDTH, HEIGHT);
		rect1.setFill(Paint.valueOf("97BD92"));
		root.getChildren().add(rect1);

		Menu menu = new Menu("File");

		MenuItem menuItemSolve = new MenuItem("Solve");
		menuItemSolve.setAccelerator(KeyCombination.valueOf("CTRL + S"));
		menuItemSolve.setOnAction(e -> trieSolveSudoku());

		MenuItem menuItemClear = new MenuItem("Clear");
		menuItemClear.setAccelerator(KeyCombination.valueOf("CTRL + D"));
		menuItemClear.setOnAction(e -> clearTiles());

		//TODO MenuItems: saveAsPDF, generate board with 1 possible solve, animated solve, switch colors and themes
		menu.getItems().addAll(menuItemSolve, menuItemClear);

		MenuBar menuBar = new MenuBar();
		menuBar.setPrefWidth(WIDTH);

		menuBar.getMenus().addAll(menu);
		root.getChildren().add(menuBar);



		//Initialise the tiles.
		tiles = new SudokuTile[SudokuSolver.size][SudokuSolver.size];


		IntStream.range(0, SudokuSolver.size * SudokuSolver.size).forEach(x -> {
			tiles[x % SudokuSolver.size][x / SudokuSolver.size]
					= new SudokuTile((x % SudokuSolver.size) * tilewidth,
					(x / SudokuSolver.size) * tilewidth + 24, tilewidth);
			root.getChildren().add(tiles[x % SudokuSolver.size][x / SudokuSolver.size]);
		});

		//Solve button.
		btnSolve = new Button("Solve");
		btnSolve.setLayoutX(WIDTH / 2f - 45);
		btnSolve.setLayoutY(HEIGHT - 50);
		btnSolve.setOnMouseClicked(x -> trieSolveSudoku());


		//Clear button.
		btnClear = new Button("Clear");
		btnClear.setOnMouseClicked(x -> clearTiles());
		btnClear.setLayoutX(WIDTH / 2f + 5);
		btnClear.setLayoutY(HEIGHT - 50);

		root.getChildren().addAll(btnSolve, btnClear);
		return root;
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void clearTiles() {
		Arrays.stream(tiles).forEach(x -> Arrays.stream(x)
				.forEach(y -> {
					y.clearNumber();
					y.setBackground();
				}));

	}

	/**Tries to solve the current sudoku*/
	private void trieSolveSudoku(){
		int[][] b = new int[SudokuSolver.size][SudokuSolver.size];
		IntStream.range(0, SudokuSolver.size * SudokuSolver.size)
				.forEach(c -> b[c % SudokuSolver.size][c / SudokuSolver.size] = tiles[c % SudokuSolver.size][c / SudokuSolver.size]
						.getNumber());

		sudokuSolver.setSudokuBoard(b);


		if (sudokuSolver.isValid()) {

			int[][] h = sudokuSolver.getSolvedBoard();

			IntStream.range(0, SudokuSolver.size * SudokuSolver.size)
					.forEach(a -> {
						tiles[a % SudokuSolver.size][a / SudokuSolver.size]
								.setNumber(Integer.toString(h[a % SudokuSolver.size][a / SudokuSolver.size]));
						tiles[a % SudokuSolver.size][a / SudokuSolver.size]
								.setBackground();
					});
		} else {
			PopupWindow p = new PopupWindow();
			p.display();
		}
	}

	private class PopupWindow {
		private void display() {
			Stage window = new Stage();
			window.setTitle("Information");
			window.setMinHeight(80);
			window.setResizable(false);
			window.initModality(Modality.APPLICATION_MODAL);

			VBox layout = new VBox(10);
			layout.getChildren().add(new Label("This Sudoku have no valid solution."));


			Button b = new Button("Close");
			b.setOnMouseClicked(e -> window.close());
			layout.getChildren().add(b);

			layout.setAlignment(Pos.CENTER);

			Scene scene = new Scene(layout);
			window.setScene(scene);

			window.show();
		}
	}


	private class SudokuTile extends StackPane {

		private LimitedNumberTextField number;

		/**
		 * Creates a {@link SudokuTile} with a position(x, y) and a WIDTH and HEIGHT.
		 *
		 * @param x the x position of the upper left corner
		 * @param y the y position of the upper left corner
		 */
		private SudokuTile(int x, int y, int width) {

			number = new LimitedNumberTextField(x, y, width, width);
			number.setFont(new Font(190f /SudokuSolver.size));
			number.setText("");

			prefHeight(width);
			prefWidth(width);
			getChildren().add(number);

			setLayoutX(x);
			setLayoutY(y);
			number.setLayoutX(x);
			number.setLayoutY(y);
			number.setStyles();
		}

		/**
		 * Setting the style for the {@link LimitedNumberTextField}.
		 */
		public void setBackground() {
			number.setStyles();
		}

		/**
		 * Tries to set a number for the {@link LimitedNumberTextField}. If it matches
		 * the regex "\\d+" then it will set the number and return true.
		 *
		 * @param num the string which the {@link LimitedNumberTextField} will get if it matches (regex)"\\d"
		 * @return returns true if the number was set
		 */
		public boolean setNumber(String num) {
			if (num.matches("\\d+") && !num.equals("0")) {
				try {
					number.setText(num);

				}catch (NullPointerException e){
					System.out.println("setNumberError");
					e.printStackTrace();
				}
				return true;
			}
			return false;
		}


		public void clearNumber() {
			try {
				number.setText("");

			}catch (NullPointerException e){
				System.out.println("ClearNumberError");
				e.printStackTrace();
			}
		}

		public int getNumber() {
			return number.getNumber();
		}
	}

	/**
	 * A {@link TextField} which only allow one character which has to be a number.
	 */
	private class LimitedNumberTextField extends TextField {

		private int x, y;

		/**
		 * Creates a {@code LimitedNumberTextField} with a position(x, y) and
		 * a WIDTH and HEIGHT.
		 *
		 * @param x      the x for the upper left corner.
		 * @param y      the y for the upper left corner.
		 * @param width  the preferred WIDTH.
		 * @param height the preferred HEIGHT.
		 */
		LimitedNumberTextField(int x, int y, int width, int height) {
			this.x = x;
			this.y = y;
			setPrefSize(width, height);

			UnaryOperator<TextFormatter.Change> integerFilter = change -> {
				String newText = change.getControlNewText();
				//TODO
				String regex = "";


				if (SudokuSolver.size == 9){
					regex = "[1-9]?";
				}else if(SudokuSolver.size == 16){
					regex  = "[1-9]|1[0-6]{0,2}";
				}else if(SudokuSolver.size == 4){
					regex = "[1-4]?";
				}else if(SudokuSolver.size == 25){
					regex =  "[1-9]?|1[0-9]{0,2}|2[0-5]{0,2}";
				}


				if ((getText() + newText).matches(regex)) {
					return change;
				}
				return null;
			};
			setTextFormatter(
					new TextFormatter<Integer>(new IntegerStringConverter(), null, integerFilter));

			//Update color every time someone typed something new
			setOnKeyPressed(e -> IntStream.range(0, SudokuSolver.size * SudokuSolver.size)
					.forEach(num -> tiles[num % SudokuSolver.size][num / SudokuSolver.size]
							.setBackground()));

			setOnKeyReleased(e -> IntStream.range(0, SudokuSolver.size * SudokuSolver.size)
					.forEach(num -> tiles[num % SudokuSolver.size][num / SudokuSolver.size]
							.setBackground()));
		}

		/**
		 * Sets the background color.
		 */
		public void setStyles() {

			int xi = x / tilewidth / SudokuSolver.sizeSqrt + 1;
			int yi = y / tilewidth / SudokuSolver.sizeSqrt + 1;
			if ((xi == 2 && yi == 1) || (xi == 1 && yi == 2) ||
					(xi == 3 && yi == 2) || (xi == 2 && yi == 3) || (xi == 1 && yi == 4) || (xi == 3 && yi == 4) || (xi == 4 && yi == 3) || (xi == 4 && yi == 1)) {
					super.setStyle("-fx-background-color: #FFFFFF");
				if (getText().matches("\\d+")) {
					super.setStyle(String.format(" -fx-background-color: #%s;", numberWhiteBackgroundColor));
				}
			} else {
				super.setStyle("-fx-background-color: #939393");
				if (getText().matches("\\d+")) {
					super.setStyle(String.format(" -fx-background-color: #%s;", numberDarkBackgroundColor));
				}
			}
		}

		/**
		 * Returns the number of the {@link LimitedNumberTextField}.
		 */
		public int getNumber() {
			if (getText().matches("")) {
				return 0;
			}
			return Integer.parseInt(getText());
		}
	}
}
