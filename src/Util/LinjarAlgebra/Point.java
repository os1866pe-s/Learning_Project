package Util.LinjarAlgebra;

/**
 * Created by Oscar on 2019-04-13.
 */
public class Point{

	private double x, y, z;

	public Point(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj.getClass().isAssignableFrom(Point.class)){
			Point p = (Point) obj;
			return this.x == p.x && this.y == p.y && this.z == p.z;
		}
		return false;
	}
}
