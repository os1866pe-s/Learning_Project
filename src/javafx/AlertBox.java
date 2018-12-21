package javafx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AlertBox {

	public static void display(String title, String message){
		Stage window = new Stage();
		window.setTitle(title);
		window.setMinWidth(250);
		//Blocks interaction with last window
		window.initModality(Modality.APPLICATION_MODAL);

		Label label = new Label(message);
		Button closeButton = new Button("Close the window");
		closeButton.setOnAction(x -> window.close());

		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		//Show the window and wait til it is closed;
		window.showAndWait();

	}
}
