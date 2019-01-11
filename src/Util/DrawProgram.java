package Util;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.image.BufferedImage;


public abstract class DrawProgram extends Application {
	private GraphicsContext g;

	private Stage stage;

	private Timeline timeline;

	protected int width = 1280, height = 720;
	private double frameRate = 60;

	private boolean resizable = true;

	private int translateX, translateY;

	private Color background;

	private boolean window = true;

	public abstract void setup(GraphicsContext g);

	public abstract void update(GraphicsContext g);

	protected void setSize(int width, int height) {
		this.width = width;
		this.height = height;

	}

	protected void setResizable(boolean value){
		resizable = value;
	}

	protected void setFrameRate(int frameRate) {
		this.frameRate = frameRate;
	}

	protected void noWindow() {
		this.window = false;
	}

	protected void setBackground(int rgb) {
		this.background = new Color(rgb / 255d, rgb / 255d, rgb / 255d, 1);
	}

	public void setTranslate(int x, int y) {
		translateX = x;
		translateY = y;
	}

	protected void noLoop(){
		timeline.stop();
	}

	//public BufferedImage getScreenShot(){}


	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		//Run setup before everything has be initialized
		setup(g);

		stage.setScene(new Scene(createContext()));


		if (window) {
			stage.show();
		}

	}

	private Parent createContext() {
		Pane root = new Pane();

		Canvas canvas = new Canvas(width, height);
		g = canvas.getGraphicsContext2D();
		g.translate(translateX, translateY);

		canvas.setHeight(height);
		canvas.setWidth(width);

		timeline = new Timeline(new KeyFrame(Duration.seconds(1 / frameRate), event -> {

			if (background != null) {
				g.setFill(background);
				g.fillRect(-translateX, -translateY, width, height);
			}
			update(g);
		}));

		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();

		root.getChildren().add(canvas);
		return root;
	}

}
