package Inl3;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class JulianSetGenerator {

	private int pixelSize;

	private ArrayList<Color> colors;
	private Complex modifier = new Complex(-0.8, 0.156);
	//private Complex modifier = new Complex(-0.624 , 0.435);
	//private Complex modifier = new Complex(-0.4, -0.4);
	//private Complex modifier = new Complex(-0.8, 0.156);


	public JulianSetGenerator() {
		colors = new ArrayList<Color>();

		for (int i = 20; i < 255; i += 10) {
			for (int k = 20; k < 130; k += 10) {
				for (int j = 20; j < 255; j += 10) {
					colors.add(new Color(i,j,k));
				}
			}

		}

		/*
		for(int i =0; i<20000; i++){
			colors.add(new Color((int)(r.nextDouble()*((double)Integer.MAX_VALUE - (double)Integer.MIN_VALUE) + Integer.MIN_VALUE)));
		}
		*/
	}

	/**
	 * Draws an image in the user-interface gui
	 */
	public void render(MandelbrotGUI gui, int iterations) {
		gui.disableInput();

		switch (gui.getResolution()) {
			case MandelbrotGUI.RESOLUTION_VERY_LOW:
				pixelSize = 9;
				break;
			case MandelbrotGUI.RESOLUTION_LOW:
				pixelSize = 7;
				break;
			case MandelbrotGUI.RESOLUTION_MEDIUM:
				pixelSize = 5;
				break;
			case MandelbrotGUI.RESOLUTION_HIGH:
				pixelSize = 3;
				break;
			case MandelbrotGUI.RESOLUTION_VERY_HIGH:
				pixelSize = 1;
				break;
			default:
				pixelSize = 1;
		}

		int height = gui.getHeight();
		int width = gui.getWidth();

		Complex[][] mesh = mesh(gui.getMinimumReal(), gui.getMaximumReal(),
				gui.getMinimumImag(), gui.getMaximumImag(),
				width, height);

		Color[][] picture = new Color[height / pixelSize][width / pixelSize];

		for (int i = 0; i < picture.length; i++) {
			for (int k = 0; k < picture[i].length; k++) {

				Complex cplx = mesh[(pixelSize / 2 + i * pixelSize)][(pixelSize / 2 + k * pixelSize)];
				//Complex temp = new Complex(0,0);
				int h = 0;
				//Is the point going to infinity or to a constant number
				while (h < iterations && cplx.getAbs2() < 2) {
					cplx.mul(cplx);
					cplx.add(modifier);
					h++;
				}
				if (gui.getMode() == MandelbrotGUI.MODE_BW) {
					if (h == iterations) {
						picture[i][k] = Color.BLACK;
					} else {
						picture[i][k] = Color.WHITE;
					}
				} else {
					//Black pixels which has a mandelbrotsum which tend to go below one
					if (h == iterations) {
						picture[i][k] = Color.BLACK;

					} else {
						//Colored pixels which has a mandelbrotsum which tend to go to infinity
						System.out.println(h);
						picture[i][k] = new Color(func(h, 1, 0),func(h, 2, 120),func(h, 1, 240));//colors.get(h);
					}
				}
			}
		}
		gui.putData(picture, pixelSize, pixelSize);
		gui.enableInput();
	}

	private int func(double x, double f, double p){
		return (int) (255*Math.pow((Math.cos(Math.sqrt(x)*f + p)),2));
	}

	/**
	 * Creates a matrix which contains complex numbers
	 * which has correct coordinates.
	 */
	private Complex[][] mesh(double minRe, double maxRe,
							 double minIm, double maxIm,
							 int width, int height) {

		Complex[][] plane = new Complex[height][width];
		double yStep = (maxIm - minIm) / (height - 1);
		double xStep = (maxRe - minRe) / (width - 1);

		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				plane[r][c] = new Complex(minRe + c * xStep, maxIm - r * yStep);
			}
		}
		return plane;
	}
}
