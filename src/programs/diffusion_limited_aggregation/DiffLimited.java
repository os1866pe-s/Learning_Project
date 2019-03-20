package programs.diffusion_limited_aggregation;

import Util.DrawProgram;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class DiffLimited extends DrawProgram {

	public static int width, height;

	private int iterations = 10;
	private int maxWalkers = 500;

	private ArrayList<Walker> walkers;
	private ArrayList<Walker> stuckWalkers;

	@Override
	public void setup(GraphicsContext g) {
		setSize(1200, 300);
		this.width = super.width;
		this.height = super.height;
		//setTranslate(width / 2, height / 2);

		walkers = new ArrayList<>();
		for (int i = 0; i < maxWalkers; i++) {
			walkers.add(new Walker());
		}

		stuckWalkers = new ArrayList<>();

		/*
		stuckWalkers.add(new Walker(width / 2, height / 2));
		*/

		for (int i = 0; i < width; i+= 8){
			stuckWalkers.add(new Walker(i + 4, height - 4));
		}
		setFrameRate(60);
	}

	@Override
	public void update(GraphicsContext g) {
		g.clearRect(0, 0, width, height);

		for (Walker w : stuckWalkers) {
			w.show(g);
		}

		for (Walker w : walkers) {
			w.show(g);

		}

		for (int i = 0; i < iterations; i++) {
			for (int j = walkers.size() - 1; j >= 0; j--) {
				walkers.get(j).walk();
				walkers.get(j).checkIfStuck(stuckWalkers);
				if (walkers.get(j).stuck) {
					stuckWalkers.add(walkers.get(j));
					walkers.remove(walkers.get(j));
					walkers.trimToSize();
					if (stuckWalkers.size() < 1000)
						walkers.add(new Walker());
				}
			}
		}
	}
}
