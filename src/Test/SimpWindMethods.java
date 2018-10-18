package Test;

import Ovn7.Turtle;
import se.lth.cs.window.SimpleWindow;

import java.awt.*;
import java.awt.color.*;

public class SimpWindMethods {

    public static void main(String[] args){

        SimpleWindow w = new SimpleWindow(400,400,"Methods");
        Turtle t = new Turtle(w,100,100);
        t.penDown();
        t.drawCircle(200,200,20);

        //Waits until you clicked with the mouse before it continues
        w.waitForMouseClick();
        //Clears the window
        w.clear();
        //Delay in ms
        w.delay(2000);
        //Closes the window
        w.close();
        w.delay(2000);
        //Opens the window
        w.open();
        //Returns the height of the window
        w.getHeight();

        w.getKey();


    }
}
