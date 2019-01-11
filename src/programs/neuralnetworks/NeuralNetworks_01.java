package programs.neuralnetworks;

import Util.DrawProgram;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class NeuralNetworks_01 extends DrawProgram {

	private Trainer[] training = new Trainer[2000];

	private Perceptron ptron;

	private int count = 0;

	private double xmin = -400;
	private double ymin = -100;
	private double xmax = 400;
	private double ymax = 100;


	@Override
	public void setup(GraphicsContext g) {
		setSize(640, 360);

		ptron = new Perceptron(3, 0.0001);

		for (int i = 0; i < training.length; i++) {
			double x = randRange(xmin, xmax);
			double y = randRange(ymin, ymax);
			int answer = 1;
			if (y < f(x)) {
				answer = -1;
			}
			training[i] = new Trainer(x, y, answer);
		}
		setTranslate(width / 2, height / 2);
		setBackground(255);

	}

	@Override
	public void update(GraphicsContext g) {
		g.setLineWidth(4);
		g.setStroke(new Color(127 / 255d, 127 / 255d, 127 / 255d, 1));
		double x1 = xmin;
		double y1 = f(x1);
		double x2 = xmax;
		double y2 = f(x2);
		g.strokeLine(x2, y2, x1, y1);

		g.setStroke(new Color(0, 0, 0, 1));
		g.setLineWidth(1);

		double[] weights = ptron.getWeights();
		x1 = xmin;
		y1 = (-weights[2] - weights[0] * x1) / weights[1];
		x2 = xmax;
		y2 = (-weights[2] - weights[0] * x2) / weights[1];
		g.strokeLine(x1, y1, x2, y2);

		System.out.println(String.format("k:%1s%.3f" ,"" ,((y1 - y2) / (x1 - x2))));


		ptron.train(training[count].inputs, training[count].answer);
		count = (count + 1) % training.length;

		for (int i = 0; i < count; i++) {
			g.setFill(new Color(1, 0, 0, 1));
			int guess = ptron.feedForward(training[i].inputs);

			if (training[i].answer == guess) {
				if (guess == 1) {

					g.setFill(new Color(0, 1, 0, 1));
				}else {
					g.setFill(new Color(.4, 0.9, .6, 1));
				}
			}

			g.fillOval(training[i].inputs[0], training[i].inputs[1], 8, 8);
		}


	}

	private double f(double x) {
		return 0.4 * x + 3;
	}

	/**
	 * Returns a random double from a given range.
	 *
	 * @param min startValue
	 * @param max endValue
	 */
	private double randRange(double min, double max) {
		double r = max - min;

		Random rand = new Random();
		double res = rand.nextDouble() * r;
		res += min;
		return res;

	}

}
