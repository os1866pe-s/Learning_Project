package games.thegameoflife;

import com.bulenkov.darcula.DarculaLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.geom.Rectangle2D;

public class BoardView extends JFrame implements Runnable {

	private JFrame frame;
	private Board board;
	private Life life;
	private JPanel panel;

	private Thread thread;

	private Graphics g;

	private int resolution = 10;
	private boolean running = false;
	private boolean loop = false;
	private boolean editBoard = false;

	private MouseManager mouseManager;

	private JMenuBar menuBar;
	private JMenuItem item1, item2, item3;
	private JMenuItem item11, item12, item13;
	private JMenuItem item21;

	public BoardView() {


		frame = this;
		try {
			UIManager.setLookAndFeel(new DarculaLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(500, 500));

		ListenForButton lForbutton = new ListenForButton();

		mouseManager = new MouseManager();
		this.addMouseListener(mouseManager);
		this.addMouseMotionListener(mouseManager);

		menuBar = new JMenuBar();
		//NEW TAB :: "FILE"
		JMenu menuFile = new JMenu("File");

		//Save the current design to a file
		item1 = new JMenuItem("Save to file");
		item1.addActionListener(lForbutton);
		menuFile.add(item1);

		//Load the current design to the board
		item2 = new JMenuItem("Load");
		item2.addActionListener(lForbutton);
		menuFile.add(item2);


		//Quit the application ctrl+Q
		item3 = new JMenuItem("Quit");
		item3.addActionListener(lForbutton);
		KeyStroke keyStroke5 = KeyStroke.getKeyStroke('Q', InputEvent.CTRL_MASK, false);
		item3.setAccelerator(keyStroke5);
		menuFile.add(item3);

		menuBar.add(menuFile);

		//NEW TAB :: "RUN"
		JMenu menuStart = new JMenu("Run");

		//Start/Stop an infinite loop
		item11 = new JMenuItem("Start/Stop Loop");
		item11.addActionListener(lForbutton);
		KeyStroke keyStroke1 = KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK, false);
		item11.setAccelerator(keyStroke1);
		menuStart.add(item11);

		//Steps 1 generation
		item12 = new JMenuItem("Step");
		item12.addActionListener(lForbutton);
		KeyStroke keyStroke3 = KeyStroke.getKeyStroke('S', InputEvent.ALT_MASK, false);
		//This will make it so the lag dissapears
		item12.registerKeyboardAction(lForbutton, keyStroke3, JComponent.WHEN_IN_FOCUSED_WINDOW);
		item12.setAccelerator(keyStroke3);
		menuStart.add(item12);

		//Creates a new random generation
		item13 = new JMenuItem("New Random Map");
		item13.addActionListener(lForbutton);
		KeyStroke keyStroke4 = KeyStroke.getKeyStroke('R', InputEvent.CTRL_MASK, false);
		item13.setAccelerator(keyStroke4);
		menuStart.add(item13);

		menuBar.add(menuStart);

		//NEW TAB :: "EDIT"
		JMenu menuEdit = new JMenu("Edit");

		//Edit the current board with clicks ctrl+E
		item21 = new JMenuItem("Edit Board");
		item21.addActionListener(lForbutton);
		KeyStroke keyStroke6 = KeyStroke.getKeyStroke('E', InputEvent.CTRL_MASK, false);
		item21.setAccelerator(keyStroke6);
		menuEdit.add(item21);

		menuBar.add(menuEdit);

        board = new Board(100, 60);
        life = new Life(board);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(board.getCol() * resolution + 1, board.getRow() * resolution + 1));


		board.fillRandom();

		this.setMinimumSize(new Dimension(board.getCol() * resolution + 7, board.getRow() * resolution + 53));
		this.add(panel);
		this.add(new Draw());
		this.setJMenuBar(menuBar);

		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		start();

	}

	private class Draw extends JComponent {
		public void paint(Graphics g) {
			//resolution = panel.getWidth() / board.getCol();
			Graphics2D graph2 = (Graphics2D) g;
			graph2.setColor(Color.DARK_GRAY);
			graph2.fill(new Rectangle2D.Float(0, 0, board.getCol() * resolution + 7, board.getRow() * resolution +53));

			graph2.setColor(new Color(0x595757));
			for (int i = 0; i < board.getCol(); i++) {
				for (int j = 0; j < board.getRow(); j++) {
					graph2.draw(new Rectangle2D.Float(i * resolution, j * resolution, resolution, resolution));
				}
			}

			graph2.setColor(Color.WHITE);
			for (int i = 0; i < board.getCol(); i++) {
				for (int j = 0; j < board.getRow(); j++) {
					if (board.get(i, j)) {
						graph2.fill(new Rectangle2D.Float(i * resolution, j * resolution, resolution, resolution));

					}
				}
			}
		}
	}

	private class ListenForButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == item3) {
				System.exit(0);
			}

			//Start/Stop loop with ctrl+S
			if (e.getSource() == item11) {
				loop = !loop;
			}

			//Step alt+S
			if (e.getSource() == item12 && !loop) {
                System.out.println(loop);
			    life.increaseGeneration();
                frame.repaint();

            }
			//Generate new random map ctrl+R
			if (e.getSource() == item13) {
				board.fillRandom();
				frame.repaint();
			}

			//Edit the current gameBoard with mouseClicks ctrl+E
			if (e.getSource() == item21){
				editBoard = !editBoard;
			}
		}
	}

	public void run() {
		boolean lastClicked = false;


		//The amount of time we want to call tick() and render() method every second.
		int fps = 30;
		//The time per frame in ns.
		double timePerTick = 1000000000 / (double) fps;
		//The amount of time we have to call the tick() and render() method again.
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		//How many times the tick() and render() methods were called.
		int ticks = 0;

		while (running) {
			//Current time of our computer in nanoseconds.
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			//if true we have to tick() and render().
			if (delta >= 1) {
				if (loop) {
					life.increaseGeneration();
					frame.repaint();
				}

				//System.out.println(mouseManager.getLeftPressed());
				if (mouseManager.getLeftPressed() && !lastClicked && editBoard && !loop){
					life.flipWithScreenCord(mouseManager.getMouseX(), mouseManager.getMouseY() - 50, resolution);
					System.out.println(mouseManager.getMouseX() + " " + " " + mouseManager.getMouseY());
					frame.repaint();
					System.out.println(1);
				}
				lastClicked = mouseManager.getLeftPressed();

				ticks++;
				delta--;
			}

			//Checks if the timer has exceeded 1 second
			if (timer >= 1000000000) {
				System.out.println("Ticks: " + ticks);
				ticks = 0;
				timer = 0;
			}

		}
		stop();
	}

	public synchronized void start() {

		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
