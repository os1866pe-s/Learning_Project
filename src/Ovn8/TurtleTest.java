package Ovn8;

import se.lth.cs.window.SimpleWindow;

public class TurtleTest {
    public static void main(String[] args){

        SimpleWindow w = new SimpleWindow(700,700,"test");
        Turtle ture = new Turtle(w, 350,350);
        ture.penDown();

        System.out.println(ture.getRotation());
        ture.drawSquare(200,200,50);


    }
}
