package javafx;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//nr12
public class Seven extends Application {
	@Override
	public void start(Stage window) throws Exception {
		window.setTitle("Seven");
		Button button = new Button("Click me");


		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		choiceBox.getItems().addAll("Apple", "Banana", "Kiwi");
		choiceBox.setValue("Apple");

		//Listener for changing ChoiceBox
		choiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> {
			System.out.println(newValue);
		});

		button.setOnAction(x -> getChoice(choiceBox));


		VBox layout = new VBox();
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(choiceBox, button);

		Scene scene = new Scene(layout, 200, 200);
		window.setScene(scene);
		window.show();
	}

	private void getChoice(ChoiceBox<String> choiceBox){
		String fruit = choiceBox.getValue();
		System.out.println(fruit);

	}
}
