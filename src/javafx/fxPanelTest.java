package javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;

public class fxPanelTest extends Application {


	@Override
	public void start(Stage stage) throws Exception {


		//A Group and a Pane works the same but can be within each other.
		Group g = new Group();

		Button b1 = new Button("btn1");
		b1.setLayoutX(200);
		b1.setLayoutY(200);
		b1.setPrefWidth(100);
		//
		b1.setMaxHeight(1);
		//Padding
		b1.setPadding(new Insets(-1,-30,-1,-10));

		//Sets the state of the button
		b1.setDefaultButton(true);
		//Just messes with the button image
		b1.setCancelButton(false);

		b1.setOnAction(x -> {
			JOptionPane.showInputDialog("What do you want form me?");
		} );

		//Probably not a good idea to use JOptionPane because the main window freezes
		b1.setText(JOptionPane.showInputDialog("Enter"));



		g.getChildren().add(b1);

		Pane p = new Pane();
		p.getChildren().add(g);


		p.setPrefSize(300, 300);

		stage.setScene(new Scene(p));
		stage.show();
	}


	public class pan extends Pane{


	}
}
