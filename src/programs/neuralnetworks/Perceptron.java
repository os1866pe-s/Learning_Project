package programs.neuralnetworks;

import java.util.Random;

public class Perceptron {

	private double[] weights;
	private double learningConstant;

	private static Random rand;

	public Perceptron(int numOfWeights, double learningConstant){
		this.learningConstant = learningConstant;

		weights = new double[numOfWeights];
		for (int i = 0; i < weights.length; i++){
			weights[i] = randRange(-1, 1);
		}
	}

	public void train(double[] inputs, int desired){
		int guess = feedForward(inputs);

		double error = desired - guess;

		for (int i = 0; i < weights.length; i++){
			weights[i] += learningConstant * error * inputs[i];
		}
	}


	public int feedForward(double[] inputs){
		double sum = 0;
		for (int i = 0; i < weights.length; i++){
			sum += inputs[i] * weights[i];
		}

		return activate(sum);
	}


	private int activate(double sum){
		if (sum > 0) return 1;
		else return -1;
	}

	public double[] getWeights(){
		return weights;
	}




	/**Returns a random double from a given range.
	 * @param min startValue
	 * @param max endValue*/
	private double randRange(double min, double max){
		double r = max - min;

		Random rand = new Random();
		double res = rand.nextDouble() * r;
		res += min;
		return res;

	}

}
