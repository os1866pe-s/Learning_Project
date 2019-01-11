package javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FourTeen extends Application {

	ComboBox comboBox;

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Comboboxes");
		Button button = new Button("Submit");
		button.setOnAction(x -> printMovie());


		comboBox = new ComboBox();
		comboBox.getItems().addAll("Movie 1", "Movie 2", "Movie 3", "Movie 4");
		comboBox.setEditable(true);
		comboBox.setPromptText("Favourite movie");
		comboBox.setOnAction(x -> printMovie());

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20,20,20,20));
		layout.getChildren().addAll(comboBox, button);

		Scene scene = new Scene(layout, 300, 300);
		stage.setScene(scene);
		stage.show();
	}


	private void printMovie(){
		if (comboBox.getValue() != null) {
			System.out.println(comboBox.getValue());
		}else{
			System.out.println("Select a value.");
		}
	}
}
