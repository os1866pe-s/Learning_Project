package programs.mazegenerator;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Draw {

	public static int w = 20;

	private static int width, height;
	public static int cols, rows;

	private static ArrayList<Cell> cells;
	private static ArrayList<Cell> stack;

	private static Cell current;


	public Draw(){

	}

	public static void setup(GraphicsContext g){
		width = 800;
		height = 800;

		cols = width / w;
		rows = height / w;

		cells = new ArrayList<>();
		stack = new ArrayList<>();

		for (int j = 0; j < rows; j++){
			for (int i = 0; i < cols; i++){
				Cell cell = new Cell(i, j);
				cells.add(cell);
			}
		}
		current = cells.get(0);
		current.setVisited();
	}

	public static void update(GraphicsContext g){

		//Update loop

		for (Cell c : cells){
			c.show(g);
		}
		for (Cell c : stack){
			c.setInStack();
			c.show(g);
		}

		Cell next = current.checkNeighbours(cells);
		if (next != null){
			current.first = false;
			removeWalls(current, next);
			next.setVisited();

			stack.add(current);

			current = next;
			current.first = true;
		}else if(stack.size() > 0){
			current.first = false;
			current = stack.get(stack.size() -1);
			stack.remove(stack.size() -1);

			current.first = true;
			current.setVisited();
		}

	}

	private static int index(int i ,int j){
		return i + j * cols;
	}

	private static void removeWalls(Cell a, Cell b){
		int xi = a.getX() - b.getX();
		int yi = a.getY() - b.getY();

		if (xi == 1){
			a.left = false;
			b.right = false;
		} else if (xi == -1){
			a.right = false;
			b.left = false;
		}else if (xi == 0) {

			if (yi == 1) {
				a.top = false;
				b.bottom = false;
			} else if (yi == -1) {
				a.bottom = false;
				b.top = false;
			}
		}
	}
}
