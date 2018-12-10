package games.thegameoflife;

import com.bulenkov.darcula.DarculaLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.geom.Rectangle2D;

public class BoardView extends JFrame {

    private JFrame frame;
    private Board board;
    private Life life;
    private JPanel panel;

    private Graphics g;

    private int resolution = 10;

    JMenuBar menuBar;
    JMenuItem item1, item2;
    JMenuItem item11, item12, item13;
    JMenuItem item21;

    public BoardView(){

        frame = this;
        try {
            UIManager.setLookAndFeel(new DarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 500));

        ListenForButton lForbutton = new ListenForButton();


        menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");

        //Save the current design to a file
        item1 = new JMenuItem("Save to file");
        item1.addActionListener(lForbutton);
        menuFile.add(item1);

        //Load the current design to the board
        item2 = new JMenuItem("Load");
        item2.addActionListener(lForbutton);
        menuFile.add(item2);
        menuBar.add(menuFile);

        JMenu menuStart = new JMenu("Run");

        //Starts an infinite loop
        item11 = new JMenuItem("Start Loop");
        item11.addActionListener(lForbutton);
        KeyStroke keyStroke1 = KeyStroke.getKeyStroke('S', InputEvent.ALT_MASK, false);
        item11.registerKeyboardAction(lForbutton,keyStroke1,JComponent.WHEN_IN_FOCUSED_WINDOW);

        menuStart.add(item11);

        //Stops the loop
        item12 = new JMenuItem("Stop Loop");
        item12.addActionListener(lForbutton);
        KeyStroke keyStroke2 = KeyStroke.getKeyStroke('Q', InputEvent.CTRL_MASK, false);
        item12.registerKeyboardAction(lForbutton,keyStroke2,JComponent.WHEN_IN_FOCUSED_WINDOW);

        menuStart.add(item12);

        //Steps 1 generation
        item13 = new JMenuItem("Step");
        item13.addActionListener(lForbutton);
        KeyStroke keyStroke3 = KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK, false);
        item13.registerKeyboardAction(lForbutton,keyStroke3,JComponent.WHEN_IN_FOCUSED_WINDOW);


        menuStart.add(item13);

        menuBar.add(menuStart);

        JMenu menuEdit = new JMenu("Edit");

        //Edit the current board with clicks
        item21 = new JMenuItem("Edit Board");
        item21.addActionListener(lForbutton);
        menuEdit.add(item21);

        menuBar.add(menuEdit);


        panel = new JPanel();
        panel.setPreferredSize(new Dimension(1001, 601));

        board = new Board(100, 60);
        life = new Life(board);

        board.fillRandom();

        this.setMinimumSize(new Dimension(1007, 653));
        this.add(panel);
        this.add(new Draw());
        this.setJMenuBar(menuBar);

        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }

    private class Draw extends JComponent{
        public void paint(Graphics g){
            //resolution = panel.getWidth() / board.getCol();
            Graphics2D graph2 = (Graphics2D) g;
            graph2.setColor(Color.DARK_GRAY);
            graph2.fill(new Rectangle2D.Float(0,0, 1007, 700));

            graph2.setColor(new Color(0x595757));
            for (int i = 0; i < board.getCol(); i++){
                for (int j = 0; j < board.getRow(); j++){
                    graph2.draw(new Rectangle2D.Float(i * resolution, j * resolution, resolution, resolution));
                }
            }

            graph2.setColor(Color.WHITE);
            for (int i = 0; i < board.getCol(); i++){
                for (int j = 0; j < board.getRow(); j++){
                    if (board.get(i,j)) {
                        graph2.fill(new Rectangle2D.Float(i * resolution, j * resolution, resolution, resolution));

                    }
                }
            }
        }
    }

    private class ListenForButton implements ActionListener{

        boolean loop = false;
        @Override
        public void actionPerformed(ActionEvent e) {
            //Step ctrl+S
            if (e.getSource() == item13){
                life.increaseGeneration();
                frame.repaint();
            }

            //Stop loop ctrl+Q
            if (e.getSource() == item12){
                //TODO -- stop the loop
            }

            //Start loop alt+S
            if (e.getSource() == item11){
                //TODO -- start a loop
            }
        }
    }

}
