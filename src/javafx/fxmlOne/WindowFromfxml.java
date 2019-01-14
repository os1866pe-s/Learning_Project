//package javafx.fxmlOne;
//
//import javafx.application.Application;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
//
//
//
//
//public class WindowFromfxml extends Application {
//
//	@FXML private JFXButton button1;
//
//	private GridPane gridPane;
//
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		Parent root = FXMLLoader.load(getClass().getResource("fxml_one.fxml"));
//
//
//		gridPane = FXMLLoader.load(this.getClass().getResource("fxml_one.fxml"));
//
//		Scene scene = new Scene(root, 300, 275);
//
//		primaryStage.setTitle("First FXML");
//		primaryStage.setScene(scene);
//		primaryStage.show();
//
//	}
//
//	public static void main(String[] args) {
//		launch(args);
//	}
//
//	public void changeText(){
//		button1.setText("new text");
//	}
//}
