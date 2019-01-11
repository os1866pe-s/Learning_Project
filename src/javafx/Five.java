package javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//nr9-10
public class Five extends Application {

	private Stage window;
	private String name, password;

	@Override
	public void start(Stage window) throws Exception {
		this.window = window;
		window.setTitle("Five");

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);

		Label nameLabel = new Label("Username");
		GridPane.setConstraints(nameLabel, 0, 0);

		TextField nameInput = new TextField("Ossy");
		GridPane.setConstraints(nameInput, 1, 0);
		nameInput.setPromptText("Username");

		Label passwordLabel = new Label("Password");
		GridPane.setConstraints(passwordLabel, 0, 1);

		PasswordField passwordInput = new PasswordField();
		passwordInput.setPromptText("Password");
		GridPane.setConstraints(passwordInput, 1, 1);


		Button button = new Button("Log in");
		GridPane.setConstraints(button, 1, 2);
		button.setOnAction(x -> {
			name = nameInput.getText();
			System.out.println(isInt(name));
			password = passwordInput.getText();
			System.out.println(name + " " + password);
		});


		grid.getChildren().addAll(nameLabel, nameInput, passwordLabel, passwordInput, button);

		Scene scene = new Scene(grid, 300, 200);
		window.setScene(scene);

		window.show();
	}

	private boolean isInt(String text){
		if (text.matches("^\\d+$")){
			return true;
		}else {
			return false;
		}
	}


}
