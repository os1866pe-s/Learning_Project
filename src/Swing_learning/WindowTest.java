package Swing_learning;

import Util.Util;
import com.bulenkov.darcula.DarculaLaf;
import jdk.nashorn.api.scripting.URLReader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class WindowTest extends JFrame {

    public static void main(String[] args) {
        new WindowTest();
    }

    public JPanel thePanel;

    public WindowTest() {
        //Do shortcuts
        //Do screenshots

        this.setTitle("TestWindow");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400, 400);


        new Util().setLookDracula();

        thePanel = new JPanel();

        JButton btn_one = new JButton("Edit");
        JButton btn_two = new JButton("Save");
        JLabel lb = new JLabel("test");

        thePanel.add(btn_one);
        thePanel.add(btn_two);
        thePanel.add(lb);





        myKeyListener keyList = new myKeyListener();

        this.setFocusable(true);
        thePanel.addKeyListener(keyList);
        this.addKeyListener(keyList);
        this.add(thePanel);
        this.setResizable(false);
        this.setVisible(true);

    }
    public BufferedImage getImage(Component component){
        BufferedImage bf = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);

        component.paint(bf.getGraphics());
        return bf;

    }
    public class myKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            if (e.isControlDown() && e.getKeyChar() == '3') {
                System.out.println("test");
                try {
                    ImageIO.write(getImage(thePanel), "png", new File("src\\Swing_learning\\screen.png"));

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            if (e.isAltDown() && e.getKeyChar() == '2') {
                URL url = null;
                try {
                    url = new URL("https://projecteuler.net/project/resources/p022_names.txt");

                    BufferedReader br = new BufferedReader(new URLReader(url));
                    System.out.println(br.readLine());

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}

