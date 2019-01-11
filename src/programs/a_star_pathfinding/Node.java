package programs.a_star_pathfinding;

public class Node {

	private int x, y;
	private int g, h, f;
	private Node parent;


	private boolean wall = false;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Node a, Node b) {
		return (a.getX() == b.getX()) && (a.getY() == b.getY());
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public boolean isWall() {
		return wall;
	}

	public void setWall(boolean wall) {
		this.wall = wall;
	}

}
