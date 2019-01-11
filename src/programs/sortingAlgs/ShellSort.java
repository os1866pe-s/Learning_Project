package programs.sortingAlgs;

import java.awt.*;

public class ShellSort extends SortView {

	private int j;

	public ShellSort(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void run() {
		reset();

		for (int gap = a.length / 2; gap > 0; gap /= 2){
			repaint();
			delay(2);
			for (int i = gap; i < a.length; i++){



				int temp = a[i];


				for (j = i; j >= gap && a[j - gap] > temp; j -= gap){
					a[j] = a[j - gap];
					currentIndex = (gap < 2) ? j : 0;

					repaint();
					delay(2);
				}
				currentIndex = (gap < 2) ? j : 0;

				repaint();
				delay(2);

				a[j] = temp;
			}
			repaint();
			delay(2);
		}

		j = - 1;
		currentIndex = Integer.MAX_VALUE;

		repaint();
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
			if (i == j) {
				g.setColor(Color.RED);
			} else if (i < currentIndex) {
				g.setColor(Color.GREEN);
			} else {
				g.setColor(Color.WHITE);
			}


			g.fillRect(i * w + x + extra / 2, height - (a[i] * h) + y + extra / 2, w, h * a[i]);

			g.setColor(Color.DARK_GRAY);
			g.drawRect(i * w + x + extra / 2, height - (a[i] * h) + y + extra / 2, w, h * a[i]);
		}
	}

	protected void reset(){
		this.i = - 1;
		currentIndex = -1;

	}
}
