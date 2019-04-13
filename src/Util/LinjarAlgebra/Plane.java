package Util.LinjarAlgebra;

/**
 * Created by Oscar on 2019-04-13.
 */
public class Plane {

	private Vector normal;
	private double normalOffset;

	public Plane(Vector normal, double normalOffset){
		this.normal = normal;
		this.normalOffset = normalOffset;
	}

	/**Check if the plane contains the point.*/
	public boolean containsPoint(Point point){

		//TODO
		return false;
	}

	public Vector getNormal() {
		return normal;
	}

	public double getNormalOffset() {
		return normalOffset;
	}
}
