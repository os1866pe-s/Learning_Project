package programs.mazegenerator;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Cell {

	private int x, y;


	public boolean top, right, bottom, left;
	private boolean visited;
	private Color color, highlight;
	public boolean first;

	private static ArrayList<Cell> neighbours;


	public Cell(int x, int y) {
		this.x = x;
		this.y = y;

		top = true;
		right = true;
		bottom = true;
		left = true;
		color = new Color(0.2, 0.2, 0.2, 1);
		highlight = new Color(60d / 255d, 180d / 255d, 240d / 255d, 1);
	}

	public void show(GraphicsContext g) {
		g.setStroke(Color.WHITE);
		g.setLineWidth(0.5);
		double res = g.getLineWidth();
		int w = Draw.w;
		int x = this.x * w;
		int y = this.y * w;

		if (first) {
			g.setFill(highlight);
			g.fillRect(x, y, w, w);

		}else{
			g.setFill(color);
			g.fillRect(x, y, w, w);
		}

		if (top) {
			g.strokeLine(x + res, y + res, x + w, y + res);
		}
		if (right) {
			g.strokeLine(x + w, y + res, x + w, y + w);
		}
		if (bottom) {
			g.strokeLine(x + w, y + w, x + res, y + w);
		}
		if (left) {
			g.strokeLine(x + res, y + w, x + res, y + res);
		}


	}

	public void setVisited() {
		visited = true;
		color = new Color(20 / 255.0, 120 / 255.0, 60 / 255.0, 1);
	}

	public void setInStack(){
		color = new Color(60 / 255d, 180/ 255d, 70/ 255d, 1);
	}


	public Cell checkNeighbours(ArrayList<Cell> cells) {
		neighbours = new ArrayList<>();

		try {
			Cell top = cells.get(index(x, y - 1));
			if (!top.visited && top != null) {
				neighbours.add(top);
			}
		}catch (ArrayIndexOutOfBoundsException ignored){}

		try {
			Cell right = cells.get(index(x + 1, y));
			if (!right.visited && right != null) {
				neighbours.add(right);
			}
		}catch (ArrayIndexOutOfBoundsException ignored){}

		try {
			Cell bottom = cells.get(index(x, y + 1));
			if (!bottom.visited && bottom != null) {
				neighbours.add(bottom);
			}
		}catch (ArrayIndexOutOfBoundsException ignored){}

		try {
			Cell left = cells.get(index(x - 1, y));
			if (!left.visited && left != null) {
				neighbours.add(left);
			}
		}catch (ArrayIndexOutOfBoundsException ignored){}


		if (neighbours.size() > 0){
			int randIndex = (int) (Math.random() * neighbours.size());

			return neighbours.get(randIndex);
		}else{
			return null;
		}

	}

	private static int index(int i, int j) {
		if (i < 0 || j < 0 || i > Draw.cols - 1 || j > Draw.rows - 1) {
			return -1;
		}
		return i + j * Draw.cols;
	}


	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}
}
