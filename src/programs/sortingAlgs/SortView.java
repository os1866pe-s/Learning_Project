package programs.sortingAlgs;


import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class SortView extends JPanel implements Runnable {

	protected int x, y, width, height;
	protected int[] a;

	protected int currentIndex = Integer.MAX_VALUE;

	protected int i = -1;
	protected Color background;

	protected int extra = 20;

	public SortView(int x, int y, int width, int height) {
		setSize(width + extra, height + extra);

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		a = new int[100];
		for (int i = 0; i < a.length; i++){
			a[i] = i + 1;
		}
		scrabble(a, a.length * 2);
		background = Color.BLACK;
	}


	@Override
	public abstract void run();

	protected void delay(int sleepTime) {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		System.out.println("painting2");
		int w =  width / a.length;
		int h =  height / a.length;
		//g.clearRect(0, 0, width, height);

		g.setColor(background);
		g.fillRect(0, 0, getWidth(), getHeight());

		for (int i = 0; i < a.length; i++) {
			if (i == currentIndex) {
				g.setColor(Color.RED);
			} else if (i == this.i) {
				g.setColor(Color.BLUE);
			} else if (i > currentIndex) {
				g.setColor(Color.GREEN);
			} else {
				g.setColor(Color.WHITE);
			}


			g.fillRect(i * w + x + extra / 2, height - (a[i] * h) + y + extra / 2, w, h * a[i]);

			g.setColor(Color.DARK_GRAY);
			g.drawRect(i * w + x, height - (a[i] * h) + y, w, h * a[i]);
		}
	}


	protected void scrabble(int[] array, int iterations) {
		Random rand = new Random();
		for (int i = 0; i < 200; i++) {
			int nr1 = rand.nextInt(array.length);
			int nr2 = rand.nextInt(array.length);

			int temp = array[nr1];
			array[nr1] = array[nr2];
			array[nr2] = temp;
		}
	}

	protected void switchItem(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	protected void reset(){
		this.i = - 1;
		currentIndex = -1;

	}

}
