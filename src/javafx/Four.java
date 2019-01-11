package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//nr8
public class Four extends Application {

	private Stage window;


	@Override
	public void start(Stage window) throws Exception {

		//test(12, 23, 12, 2, 424);


		this.window = window;
		window.setTitle("Four");

		HBox topMenu = new HBox();
		Button button1 = new Button("File");
		Button button2 = new Button("Edit");
		Button button3 = new Button("View");
		topMenu.getChildren().addAll(button1, button2, button3);

		VBox leftMenu = new VBox();
		Button button4 = new Button("Four");
		Button button5 = new Button("Five");
		Button button6 = new Button("Six");
		leftMenu.getChildren().addAll(button4, button5, button6);

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(topMenu);
		borderPane.setLeft(leftMenu);



		Scene scene = new Scene(borderPane, 300, 250);
		window.setScene(scene);
		window.show();


	}

	public void test(int... elements){
		for (int j : elements) {
			System.out.println(j);
		}
	}
}
