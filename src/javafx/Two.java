package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Two extends Application {

	private Stage window;
	private Button button;

	//nr6
	@Override
	public void start(Stage window) throws Exception {
		window.setTitle("Two");

		button = new Button("Text");
		button.setOnAction(x -> AlertBox.display("Title", "A message"));

		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 300 , 300);
		window.setScene(scene);
		window.show();
	}


}
