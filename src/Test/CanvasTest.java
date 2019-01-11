package Test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CanvasTest extends Application {

	private Canvas canvas;
	private Group group;
	private Scene scene;
	private GraphicsContext g;

	int x = 0, y = 0, width, height;
	public int[] a;
	int currentIndex = 99;

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("test");
		group = new Group();
		canvas = new Canvas(400, 400);

		g = canvas.getGraphicsContext2D();

		group.getChildren().add(canvas);

		scene = new Scene(group, 400, 400);
		stage.setScene(scene);



		stage.show();

		a = new int[100];
		for (int i = 0; i < 100; i++){
			a[i] = i + 1;
		}

		scrabble(200);






		System.out.println(3 + " " + a.length);
		g.setFill(Color.DARKORANGE);

		ExecutorService executor = Executors.newFixedThreadPool(1);

		gre f = new gre();
		executor.execute(f);

		System.out.println(5);

	}

	public void delay(){
		try {
			Thread.sleep(1);



		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void switchItem(int index1, int index2){
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	public void scrabble(int iterations){
		Random rand = new Random();
		for (int i = 0; i < 200; i++){
			int nr1 = rand.nextInt(a.length);
			int nr2 = rand.nextInt(a.length);

			int temp = a[nr1];
			a[nr1] = a[nr2];
			a[nr2] = temp;
		}
	}



	public class gre implements Runnable{


		@Override
		public void run() {

			scrabble(200);
			for (int j = 0; j < a.length; j++) {
				for (int i = 0; i < currentIndex; i++) {
					if (a[i] > a[i + 1]) {
						switchItem(i, i + 1);

						System.out.println(1);
						g.setFill(Color.DARKORANGE);
						g.fillRect(i,j, 10, 10);
						delay();


					}
				}
				if (currentIndex > 0) {
					currentIndex--;
				}
			}

			System.out.println("DONE!");
		}



//		public void sortAll(GraphicsContext g) {
//			for (int j = 0; j < a.length; j++) {
//				for (int i = 0; i < currentIndex; i++) {
//					if (a[i] > a[i + 1]) {
//						switchItem(i, i + 1);
//
//						System.out.println(1);
//						g.setFill(Color.DARKORANGE);
//						g.fillRect(i,j, 10, 10);
//					}
//				}
//				if (currentIndex > 0) {
//					currentIndex--;
//				}
//			}
//
//		}


	}







}
