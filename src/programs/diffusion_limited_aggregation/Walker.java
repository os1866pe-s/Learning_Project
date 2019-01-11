package programs.diffusion_limited_aggregation;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class Walker {

	private int x, y;
	private int r;

	public boolean stuck;
	private Color color = Color.hsb(0, 0,0);

	private Random rand = new Random();

	public Walker(int x, int y) {
		this.x = x;
		this.y = y;
		r = 8;
		stuck = true;
		color = Color.hsb(210, 0.07, 0.2);


	}

	/**
	 * Creates a walker in a random spot on the window.
	 */
	public Walker() {
		x = rand.nextInt(DiffLimited.width);
		y = 1;
		//y = rand.nextInt(DiffLimited.height);
		r = 8;





	}

	public void checkIfStuck(ArrayList<Walker> walkers) {
		for (Walker w : walkers){
			if (this.intersects(w)){
				this.stuck = true;
				color = Color.hsb(210, 0.07, 0.2);
			}
		}

	}

	public void walk(){
		x += rand.nextInt(r + 1) - r / 2;
		y += rand.nextInt(r + 1) - r / 2;

		if (x > DiffLimited.width){
			x = DiffLimited.width - 1;
		}else if (x < 0){
			x = 1;
		}

		if (y > DiffLimited.height){
			y = DiffLimited.height - 1;
		}else if (y < 0){
			y = 1;
		}
	}

	public void show(GraphicsContext g) {
		g.setFill(color);
		g.fillOval(x - r, y - r, r, r);
	}

	private boolean intersects(Walker w){

		if ((this.x - w.x) * (this.x - w.x) + (this.y - w.y) * (this.y - w.y) < w.r * this.r){
			return true;
		}
		return false;
	}
}
