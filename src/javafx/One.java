package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class One extends Application {

	private Button button1, button2;
	private Label label1, label2;

	private Stage window;
	private Scene scene1, scene2;

	@Override
	public void start(Stage window) throws Exception {
		//Main javaFx code
		window.setTitle("One");

		label1 = new Label("Welcome to the first scene!");

		button1 = new Button("Go to scene 2");
		button1.setOnAction(x -> window.setScene(scene2));

		//Layout 1 - children in a vertical column;
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label1, button1);
		scene1 = new Scene(layout, 200, 200);


		button2 = new Button("Go to scene 1");
		button2.setOnAction(x -> window.setScene(scene1));

		StackPane layout2 = new StackPane();
		layout2.getChildren().add(button2);
		scene2 = new Scene(layout2, 300, 300);

		window.setScene(scene1);
		window.show();


		/* Simple Window with a button1 and a clickEvent

		button1 = new Button();
		button1.setText("Click me");
		button1.setOnAction(x -> {
			System.out.println(button1.getText() + "!");
		});


		StackPane layout = new StackPane();
		layout.getChildren().add(button1);

		Scene scene = new Scene(layout, 400, 400);
		window.setScene(scene);
		window.show();
		*/

	}

}
