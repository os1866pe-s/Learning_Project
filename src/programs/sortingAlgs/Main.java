package programs.sortingAlgs;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main extends JApplet {


	private Canvas canvas;
	private Group group;
	private Scene scene;
	private static GraphicsContext g;

	private SortView[] sortViews;

	public Main(){


		setLayout(new GridLayout(1, 1, 0, 0));
		setVisible(true);
		SortPanelsHolder sortPanelHolder = new SortPanelsHolder();
		sortPanelHolder.setLayout(new GridLayout(0, 3, 0, 0));
		sortPanelHolder.setBackground(Color.BLACK);
		sortPanelHolder.setForeground(Color.BLACK);

		sortViews = new SortView[3];
		sortViews[0] = new BubbleSort(0,0, 400, 300);
		sortViews[1] = new SelectionSort(0, 0, 400, 300);
		sortViews[2] = new ShellSort(0,0, 400, 300);

		for (int i = 0; i < sortViews.length; i++) {
			sortViews[i].setVisible(false);
			sortPanelHolder.add(sortViews[i]);
		}

		add(sortPanelHolder);
		sortPanelHolder.setVisible(true);
	}


	class SortPanelsHolder extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLACK);


		}
	}

	public void beginAnimation(){
		try {

			repaint();
			Thread.sleep(2000);
			repaint();

			for (int i = 0; i < sortViews.length; i++) {
				sortViews[i].setVisible(true);
			}


			Thread.sleep(1000);
			ExecutorService executor = Executors.newFixedThreadPool(sortViews.length);
			for (int i = 0; i < sortViews.length; i++) {
				executor.execute(sortViews[i]);
			}



			executor.shutdown();
			while(!executor.isTerminated()) {
				Thread.sleep(100);
			}
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {
		JFrame frame = new JFrame("Sorting Algorithm Animations");
		Main main = new Main();
		frame.add(main);
		//frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(1200, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);



		main.beginAnimation();


	}


}
