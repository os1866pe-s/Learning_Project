package programs.a_star_pathfinding;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Spot {

	double f, g, h;
	int x, y;
	boolean wall;

	Spot previous;

	private ArrayList<Spot> neighbors;

	private Color lineColor;
	private Color backgroundColor;

	public Spot(int x, int y) {
		wall = false;
		this.x = x;
		this.y = y;
		lineColor = Color.hsb(0, 0, .3);
		backgroundColor = Color.hsb(200, 1, 1);
		neighbors = new ArrayList<>();

		if (Math.random() < 0.3){
			wall = true;
		}
	}

	public void show(GraphicsContext g, Color color) {
		g.setFill(color);
		if (wall){
			g.setFill(Color.BLACK);
		}
		g.setStroke(lineColor);
		g.setLineWidth(2);
		g.fillRect(x * AStar.spotWidth, y * AStar.spotHeight, AStar.spotWidth, AStar.spotHeight);
		g.strokeRect(x * AStar.spotWidth, y * AStar.spotHeight, AStar.spotWidth, AStar.spotHeight);

		g.setStroke(Color.BLACK);
		g.setLineWidth(1);
		g.strokeText(String.format("%.0f", this.f), x * AStar.spotWidth, y * AStar.spotHeight + 10);
	}

	public boolean equals(Spot s) {
		return (this.x == s.x && this.y == s.y);
	}

	public void addNeighbors(ArrayList<Spot> grid) {
		if (x > 0){
			neighbors.add(grid.get(index(x - 1, y)));
		}
		if (x < AStar.cols - 1){
			neighbors.add(grid.get(index(x + 1, y)));
		}
		if (y < AStar.rows - 1){
			neighbors.add(grid.get(index(x, y + 1)));
		}
		if (y > 0){
			neighbors.add(grid.get(index(x, y - 1)));
		}


		if (x > 0 && y > 0 && (!grid.get(index(x, y - 1)).wall || !grid.get(index(x - 1, y)).wall)){
			neighbors.add(grid.get(index(x - 1, y - 1)));
		}
		if (x < AStar.cols - 1 && y > 0 && (!grid.get(index(x + 1, y)).wall || !grid.get(index(x, y - 1)).wall)){
			neighbors.add(grid.get(index(x + 1, y - 1)));
		}
		if (x < AStar.cols - 1 && y < AStar.rows - 1 && (!grid.get(index(x + 1, y)).wall || !grid.get(index(x, y + 1)).wall)){
			neighbors.add(grid.get(index(x + 1, y + 1)));
		}
		if (x > 0 && y < AStar.rows - 1 && (!grid.get(index(x - 1, y)).wall || !grid.get(index(x, y + 1)).wall)){
			neighbors.add(grid.get(index(x - 1, y + 1)));
		}



	}

	private int index(int a, int b) {
		return a + b * AStar.cols;
	}

	public ArrayList<Spot> getNeighbors() {
		return neighbors;
	}
}
