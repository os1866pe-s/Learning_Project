package javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//Nr11
public class Six extends Application {

	private Stage window;
	private Button button;

	@Override
	public void start(Stage window) throws Exception {
		window.setTitle("Six");

		CheckBox box1 = new CheckBox("Bacon");
		CheckBox box2 = new CheckBox("Sandwich");
		//Check it by default
		box2.setSelected(true);


		button = new Button("Order Now!");
		button.setOnAction(x ->{
			handleOptions(box1, box2);
		});

		VBox layout = new VBox();
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll( box1, box2, button);

		Scene scene  = new Scene(layout, 300, 300);
		window.setScene(scene);
		window.show();
	}

	private void handleOptions(CheckBox cb1, CheckBox cb2){
		StringBuilder message = new StringBuilder();
		message.append("Users Order:\n");

		if (cb1.isSelected()){
			message.append(cb1.getText()).append(" is selected\n");
		}
		if (cb2.isSelected()){
			message.append(cb2.getText()).append(" is selected\n");
		}

		System.out.println(message);
	}
}
