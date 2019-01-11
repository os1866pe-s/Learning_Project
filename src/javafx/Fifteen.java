package javafx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Fifteen extends Application {

	ListView listView;
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Comboboxes");
		Button button = new Button("Submit");
		button.setOnAction(x -> buttonClick());


		listView = new ListView<>();
		listView.getItems().addAll("Movie 1", "Movie 2", "Movie 3", "Movie 4");
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20,20,20,20));
		layout.getChildren().addAll(listView, button);

		Scene scene = new Scene(layout, 300, 120);
		stage.setScene(scene);
		stage.show();
	}

	private void buttonClick(){
		for (Object i : listView.getSelectionModel().getSelectedItems()){
			System.out.println(i);
		}
	}
}
