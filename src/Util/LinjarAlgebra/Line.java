package Util.LinjarAlgebra;

/**
 * Created by Oscar on 2019-04-13.
 */
public class Line {

	private Point point;
	private Vector vector;

	public Line(Point point, Vector vector){
		this.point = point;
		this.vector = vector;
	}

	public Point getPoint() {
		return point;
	}

	public Vector getVector() {
		return vector;
	}
}
