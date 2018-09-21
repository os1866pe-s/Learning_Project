package Ovn4;

import se.lth.cs.p.ovn.turtle.Turtle;
import se.lth.cs.window.SimpleWindow;

import java.awt.*;

public class E4_1 {
    public static void main(String[] args){

        SimpleWindow window = new SimpleWindow(900,900,"Squares");
        Turtle ture = new Turtle(window, 100,100);
        ture.penDown();

        Color[] colors = new Color[13];
        colors[0]  = Color.black;
        colors[1]  = Color.white;
        colors[2]  = Color.blue;
        colors[3]  = Color.cyan;
        colors[4]  = Color.darkGray;
        colors[5]  = Color.gray;
        colors[6]  = Color.green;
        colors[7]  = Color.lightGray;
        colors[8]  = Color.magenta;
        colors[9]  = Color.orange;
        colors[10] = Color.pink;
        colors[11] = Color.red;
        colors[12] = Color.yellow;

        int difX = 60, difY = 30;

        for (int i = 0; i<10; i++){
            for (int j = 0; j<4;j++){
                ture.right(90);
                ture.forward(100);
            }
            ture.jumpTo(ture.getX()+difX, ture.getY() + difY);
            window.setLineColor(colors[(int) (Math.random()*13)]);
            window.setLineWidth((int) (Math.random()*20));
        }

    }
}
