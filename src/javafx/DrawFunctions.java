package javafx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static java.lang.Math.*;

public class DrawFunctions extends Application {

	private GraphicsContext g;

	private double t = -8.0;

	private double oldX = 400, oldY = 300;

	public DrawFunctions(){

	}

	private Parent createContext(){
		Pane root = new Pane();
		root.setPrefSize(800, 600);

		Canvas canvas = new Canvas(800, 600);
		g = canvas.getGraphicsContext2D();

		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				t += 0.017;
				draw();
			}
		};

		timer.start();

		root.getChildren().add(canvas);
		return root;
	}

	private void draw(){
		//g.clearRect(0,0, 800, 600);
		Point2D p = function();

		//g.setStroke(Color.ORANGE);
		g.setLineWidth(1);

		double newX = 400 + p.getX();
		double newY = 300 + p.getY();
		if (oldX != 400 && oldY != 300) {
			g.strokeLine(oldX, oldY, newX, newY);
		}
		//g.strokeOval(newX, newY, 1, 1);
		g.fillRect(10, 100, 100, 100);

		//g.setStroke(new Color(abs((newX -400) * 0.01) % 1,abs((newY- 300) * 0.01) % 1,abs(t * 0.25) % 1,1));
		oldX = newX;
		oldY = newY;
	}

	private Point2D function(){
		//double x = sin(t) * (pow(E, cos(t)) - 2* cos(4*t) - pow(sin(t/12.0), 5));
		//double y = cos(t) * (pow(E, cos(t)) - 2* cos(4*t) - pow(sin(t/12.0), 5));

		double x =t;
		double y = x;
		return new Point2D(x, -y).multiply(50);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(createContext()));
		stage.show();

	}
}
