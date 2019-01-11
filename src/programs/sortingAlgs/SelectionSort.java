package programs.sortingAlgs;

import java.awt.*;

public class SelectionSort extends SortView {


	private int biggestIndex = Integer.MAX_VALUE;


	public SelectionSort(int x, int y, int width, int height) {
		super(x, y, width, height);
	}



	@Override
	public void run() {
		reset();
		currentIndex = a.length - 1;
		biggestIndex = 0;
		for (int j = 0; j < a.length - 1; j++) {
			for (int i = 0; i <= currentIndex; i++) {
				this.i = i;
				repaint();
				delay(2);

				if (a[i] > a[biggestIndex]){
					biggestIndex = i;
					delay(2);
				}
			}
			switchItem(a, currentIndex, biggestIndex);

			if(currentIndex > 0){
				currentIndex--;
				//delay(2);
			}
			biggestIndex = 0;
		}
		reset();
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
			if (i == biggestIndex) {
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
			g.drawRect(i * w + x + extra / 2, height - (a[i] * h) + y + extra / 2, w, h * a[i]);
		}
	}

	protected void reset(){
		this.i = - 1;
		currentIndex = -1;
		biggestIndex = - 1;

	}
}
