package Ovn7;

import se.lth.cs.window.SimpleWindow;

import java.awt.*;

public class TurtleTest {
    public static void main(String[] args){

        SimpleWindow w = new SimpleWindow(700,700,"test");
        Turtle ture = new Turtle(w, 350,350);
        ture.penDown();
        System.out.println(ture.getRotation());

        ture.drawSquare(200,200,50);
        ture.drawCircle(150,200,50);
        ture.drawCircle(250, 210, 50);
        ture.drawCircle(350, 225, 50);
        ture.drawCircle(450, 240, 50);
        ture.drawCircle(550, 255, 50);
        ture.drawCircle(650, 270, 50);
        ture.drawCircle(100,500,5);
        ture.drawPolygon(100,500,200,15);
        ture.drawSquareFilled(500, 500, 101, Color.blue);
        ture.drawSquareFilled(500, 100, 52, Color.green);

    }
}
