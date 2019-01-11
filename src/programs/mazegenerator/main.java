package programs.mazegenerator;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class main extends Application {

	private GraphicsContext g;

	private Parent createContext() {
		Pane root = new Pane();
		root.setPrefSize(800, 800);

		Canvas canvas = new Canvas(800, 800);
		g = canvas.getGraphicsContext2D();
		Draw.setup(g);


		Timeline timerline = new Timeline(new KeyFrame(Duration.millis(5d), event -> {
			Draw.update(g);
		}));

		timerline.setCycleCount(Animation.INDEFINITE);
		timerline.play();

		root.getChildren().add(canvas);
		return root;
	}


	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(createContext()));
		stage.show();

	}
}
