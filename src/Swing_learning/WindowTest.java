package Swing_learning;

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

import com.bulenkov.darcula.DarculaLaf;

public class WindowTest extends JFrame {

    public static void main(String[] args) {
        new WindowTest();
    }



    public WindowTest(){
        //Do shortcuts
        //Do screenshots

        this.setTitle("TestWindow");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);



        try {
            UIManager.setLookAndFeel(new DarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JPanel thePanel = new JPanel();

        JButton btn_one = new JButton("Edit");
        JButton btn_two = new JButton("Save");
        JLabel lb = new JLabel("test");

        thePanel.add(btn_one);
        thePanel.add(btn_two);
        thePanel.add(lb);


        this.add(thePanel);



        myKeyListener keyList = new myKeyListener();

        this.addKeyListener(keyList);
        this.setResizable(false);
        this.setVisible(true);






    }

    public BufferedImage getScreenshot(){
        int yOffset = 20;
        try{
            Robot rbt = new Robot();
            Toolkit tk = Toolkit.getDefaultToolkit();
            Dimension dim = tk.getScreenSize();
            BufferedImage background = rbt.createScreenCapture(new Rectangle(this.getX() + 2, this.getY() + 22, (int) (this.getWidth() - 4), (int) (this.getHeight() - 24)));
            return background;

        }catch (AWTException e) {
            e.printStackTrace();
            return null;
        }

    }
    public class myKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            if (e.isControlDown() && e.getKeyChar() == '3'){

                try{
                    ImageIO.write(getScreenshot(), "png", new File("src\\Swing_learning\\Screenshot.png"));

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            if(e.isAltDown() && e.getKeyChar() == '2'){
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

