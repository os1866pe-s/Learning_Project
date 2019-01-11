package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTest extends JFrame {

	public static void main(String[] args) {
		Util.Util.setLookDracula();

		new PanelTest();

	}

	public PanelTest(){

		this.setTitle("Test");
		//this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(400, 400);

		this.add(new JTextField("tet"));
		thePanel p = new thePanel();
		//p.setBackground(Color.DARK_GRAY);
		//p.setForeground(Color.DARK_GRAY);


		this.pack();

		this.add(p);
		this.setVisible(true);

	}



	public class thePanel extends JPanel implements ActionListener {

		JButton btn1;

		public thePanel(){


			//If you set the layout to null you will have to set
			// the bounds like int @setPositions otherwise you can't see them on the screen.
			setLayout(null);

			btn1 = new JButton("button1");
			btn1.addActionListener(this);
			add(btn1);

			add(new JButton("button2"));
			add(new JLabel("testLabel"));
			setVisible(true);
			setPositions();
			pack();

		}

		public void setPositions(){
			btn1.setBounds(100, 100, 60, 20);
		}


		/**
		 * Adds a list of components as a parameter.
		 * */
		public void addAll(Component... elements){
			for (Component c : elements) {
				this.add(c);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {

		}


	}
}
