package school.EDDA30.Ovn4;

public class Rectangle implements Resizable{

	private double height;
	private double width;


	public Rectangle(double height, double width){
		this.height = height;
		this.width = width;
	}

	@Override
	public void downSize(int scaleFactor) {
		height *= 1/(double)scaleFactor;
		width *= 1/(double)scaleFactor;
	}
}
