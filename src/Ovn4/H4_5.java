package Ovn4;

import se.lth.cs.p.ovn.turtle.Turtle;
import se.lth.cs.window.SimpleWindow;

public class H4_5 {
    public static void main(String[] args){

        SimpleWindow window = new SimpleWindow(900,900,"Two Turtles");

        Turtle ture = new Turtle(window,200,200);
        Turtle tellus = new Turtle(window,700,700);
        ture.penDown();
        tellus.penDown();


        int turePosX,turePosY,tellusPosX,tellusPosY,tureRandom, tellusRandom;
        double tureAngle = 90.0,tellusAngle = 90.0;



        while ((Math.hypot(Math.abs(ture.getX()-tellus.getY()), Math.abs(ture.getY()-ture.getY()))) > 50){


            if ((turePosX < 0 || ture.getY() > 900) || (ture.getX() < 0 || ture.getX() > 900)){

            }
            turePosX = ture.getX()
            ture.right((int) (Math.floor(Math.random()*360 )-179));
            ture.forward((int) (Math.floor(Math.random()*10)+1));

            tellus.right((int) (Math.floor(Math.random()*360 )-179));
            tellus.forward((int) (Math.floor(Math.random()*10)+1));


        }
    }

}
