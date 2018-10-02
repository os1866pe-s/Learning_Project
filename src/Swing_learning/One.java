package Swing_learning;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class One {
    public static void main(String[] args){

        JFrame f = new JFrame();
        JButton b = new JButton("Click");
        ImageIcon icon = new ImageIcon("pic.jpg");
        JButton b2 = new JButton(icon);
        b.setBounds(130,100,500,400);

        f.add(b);

        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);



    }
}
