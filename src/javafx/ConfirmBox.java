package javafx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

//Nr7
public class ConfirmBox {

	private static boolean close = false;

	public static boolean display(String title, String message){


		Stage window = new Stage();
		window.setTitle(title);
		window.setMinWidth(250);
		//Blocks interaction with last window
		window.initModality(Modality.APPLICATION_MODAL);

		Label label = new Label(message);

		Button okButton = new Button("Yes");
		Button noButton  = new Button("No");

		okButton.setOnAction(x -> {
			System.out.println("ok");
			close = true;
			window.close();
		});
		noButton.setOnAction(x -> {
			close = false;
			window.close();
		});

		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, okButton, noButton);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		//Show the window and wait til it is closed;
		window.showAndWait();

		return close;
	}
}
