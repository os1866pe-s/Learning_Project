package Test;

import Util.DrawProgram;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class threeDLine extends DrawProgram {


	@Override
	public void setup(GraphicsContext g) {
		Point3D p1 = new Point3D(1,1,1);
		Point3D p2 = new Point3D(5,5,5);
		Point3D p3 = new Point3D(10,10,10);

	}

	@Override
	public void update(GraphicsContext g) {
		
	}
}
