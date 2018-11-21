package Swing_learning;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

        JPanel thePanel = new JPanel();
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

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}

