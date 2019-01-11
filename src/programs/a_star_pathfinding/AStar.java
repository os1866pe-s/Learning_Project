package programs.a_star_pathfinding;

import Util.DrawProgram;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class AStar extends DrawProgram {

	public static int cols, rows;
	public static int spotWidth, spotHeight;

	private ArrayList<Spot> grid;

	private ArrayList<Spot> openSet;
	private ArrayList<Spot> closedSet;

	private ArrayList<Spot> path;

	private Spot start;
	private Spot end;

	@Override
	public void setup(GraphicsContext g) {
		setSize(700, 700);

		cols = 25;
		rows = 25;

		openSet = new ArrayList<>();
		closedSet = new ArrayList<>();

		path = new ArrayList<>();

		spotWidth = width / cols;
		spotHeight = height / rows;

		//Fill the whole grid
		grid = new ArrayList<>();
		for (int i = 0; i < cols * rows; i++){
			grid.add(new Spot(i % cols, i / rows));
		}
		//Add all the neighbors
		for (int i = 0; i < cols * rows; i++){
			grid.get(i).addNeighbors(grid);
		}

		//Set the start and finish
		start = grid.get(index(0, 0));
		end = grid.get(index(cols -1, rows -10));
		openSet.add(start);

		//Temp solution
		start.wall = false;
		end.wall = false;
		setFrameRate(7);
	}

	@Override
	public void update(GraphicsContext g) {

		if (openSet.size() > 0){
			//Keep going

			int lowest = 0;
			for (int i = 0; i < openSet.size(); i++){
				if (openSet.get(i).f < openSet.get(lowest).f){
					lowest = i;
				}
			}
			Spot current = openSet.get(lowest);

			if (current.equals(end)){
				//Find the path
				path.add(end);
				Spot temp = current;
				while (temp.previous != null){
					path.add(temp.previous);
					temp = temp.previous;
				}
				System.out.println("Done!");
				noLoop();

			}

			openSet.remove(current);
			closedSet.add(current);

			ArrayList<Spot> neighbours = current.getNeighbors();
			for (int i = 0; i < neighbours.size(); i++){
				Spot neighbour = neighbours.get(i);

				if (!closedSet.contains(neighbour) && !neighbour.wall) {
					double tempG;
					if (current.x != neighbour.x && current.y != neighbour.y){
						 tempG = current.g + 14;
					}else{
						tempG = current.g + 10;
					}

					boolean newPath = false;
					if (openSet.contains(neighbour)){
						if (tempG < neighbour.g){
							neighbour.g = tempG;
							newPath = true;
						}
					}else{
						neighbour.g = tempG;
						newPath = true;
						openSet.add(neighbour);
					}

					if (newPath) {
						neighbour.h = heuristic(neighbour, end);
						neighbour.f = neighbour.g + neighbour.h;

						neighbour.previous = current;
					}
				}
			}

		}else {
			//No solution
			System.out.println("No solution");

			noLoop();
		}


		for (int i = 0; i < cols; i++){
			for (int j = 0; j < rows; j++){
				grid.get(index(i, j)).show(g, Color.hsb(200, 0,1));
			}
		}

		for (int i = 0; i < closedSet.size(); i++){
			closedSet.get(i).show(g, Color.hsb(260, .8,1));
		}

		for (int i = 0; i < openSet.size(); i++){
			openSet.get(i).show(g, Color.hsb(120, .7,1));

		}



		for (int i = 0; i < path.size(); i++){
			path.get(i).show(g, Color.hsb(30, 1, 1));
		}
	}

	private double heuristic(Spot neighbour, Spot end) {
		//return Math.abs(neighbour.x - end.x) + Math.abs(neighbour.y - end.y);
		return distance(neighbour.x, neighbour.y ,end.x ,end.y) * 10;
	}

	private double distance(int x1, int y1, int x2, int y2){
		return  Math.sqrt(Math.abs(x1 - x2) * Math.abs(x1 - x2) + Math.abs(y1 - y2) * Math.abs(y1 - y2));
	}


	private int index(int a, int b){
		return a + b * cols;
	}
}
