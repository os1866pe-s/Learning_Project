package Util.LinjarAlgebra;

/**
 * Created by Oscar on 2019-04-13.
 */
public class Vector {

	private double x, y, z;

	public Vector(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double dotProduct(Vector other){
		return (x * other.x) + (y * other.y) + (z * other.z);
	}

	public Vector sumWith(Vector other){
		return new Vector(this.x + other.x, this.y + other.y, this.z + other.z);
	}

	public Vector differenceOf(Vector other){
		return new Vector(this.x - other.x, this.y - other.y, this.z - other.z);
	}

	public double getLength(){
		return Math.sqrt(x * x + y * y + z * z);
	}

	public double getAngle(Vector other){
		return Math.acos((float) (dotProduct(other) / (getLength() * other.getLength())));
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
}
