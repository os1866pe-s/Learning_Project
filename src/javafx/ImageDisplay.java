package javafx;

import com.sun.javafx.fxml.builder.JavaFXImageBuilder;
import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.stream.IntStream;

public class ImageDisplay extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("ImageTest");
		//stage.setWidth(700);
		//stage.setHeight(400);

		FileInputStream input = new FileInputStream("src/Test/futuristic-city-wallpaper-25.jpg");
		Image img = new Image(input);
		//WritableImage writImg = new WritableImage((int)img.getWidth(), (int)img.getHeight());

//		int rgb = img.getPixelReader().getArgb(0,0);
//		int  red   = (rgb & 0x00ff0000) >> 16;
//		int  green = (rgb & 0x0000ff00) >> 8;
//		int  blue  =  rgb & 0x000000ff;
//		System.out.println("Red Color value = " + red);
//		System.out.println("Green Color value = " + green);
//		System.out.println("Blue Color value = " + blue);


//		AnimationTimer timer = new AnimationTimer() {
//			int time = 0;
//			int extra = 1;
//			@Override
//			public void handle(long now) {
//				IntStream.range(0, (int)img.getWidth() * (int)img.getHeight()).forEach(x -> {
//
//					int width = (int) img.getWidth();
//					int rbg = img.getPixelReader().getArgb(x % width, x / width);
//					rbg = rbg << extra;
//
//
//					//rbg += extra;
//					writImg.getPixelWriter().setArgb(x % width, x / width, rbg);
//				});
//				if (time > 10){
//					extra += 1;
//					System.out.println(extra);
//					time = 0;
//				}
//				time++;
//			}
//		};
//
//		timer.start();
		double scale = 0.2;
		int width = (int) (img.getWidth() / (double) scale);
		int height = (int) (img.getHeight() / (double) scale);

		WritableImage writImg2 = new WritableImage(width, height);


		int[][] rgbSum = new int[width][height];

		IntStream.range(0, (int) img.getWidth() * (int) img.getHeight()).forEach(x -> {

			int widt = (int) img.getWidth();
			int rgb = img.getPixelReader().getArgb(x % widt, x / widt);

			//System.out.println(x % width / 28 + " " +x / width / 28);
			rgbSum[(int)(x % widt / scale)][(int)(x / widt / scale)] += rgb ;

			//rbg += extra;
		});

		IntStream.range(0, width * height).forEach(x -> writImg2.getPixelWriter()
				.setArgb(x % width, x / width, (int)(rgbSum[x % width][x / width] / (scale * scale)) >> 8));

		ImageView imageView = new ImageView(img);
		imageView.setFitWidth(700);
		imageView.setFitHeight(400);
		ImageView imageView2 = new ImageView(writImg2);
		imageView2.setFitWidth(width / 20d);
		imageView2.setFitHeight(height / 20d);


		File file = new File("test.png");

		Button b = new Button("tap");
		b.setOnAction(x -> {
			try {
				RenderedImage renderedImage = SwingFXUtils.fromFXImage(writImg2, null);
				ImageIO.write(
						renderedImage,
						"png",
						file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});


		//ColorAdjust blackout = new ColorAdjust();
		//blackout.setBrightness(.7);

		//imageView.setEffect(blackout);

		VBox layout = new VBox();
		layout.getChildren().addAll(b, imageView, imageView2);

		Scene scene = new Scene(layout, 700, 800);
		stage.setScene(scene);
		stage.show();

	}
}
