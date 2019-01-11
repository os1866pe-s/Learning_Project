package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Three extends Application {

	private Stage window;
	private Button button;

	@Override
	public void start(Stage window) throws Exception {
		this.window = window;
		window.setTitle("Three");

		button = new Button("Close Program");
		button.setOnAction( x -> {
			closeProgram();
		});


		window.setOnCloseRequest(x -> {
			//This mean we got full control what happens next.
			//Only my code will run.
			x.consume();
			closeProgram();
		});

		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();

	}

	private void closeProgram() {
		boolean answer = ConfirmBox.display("Title", "Sure you want to exit?");
		if (answer){
			window.close();
		}

	}
}
