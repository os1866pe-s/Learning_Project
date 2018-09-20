package Ovn4;

import se.lth.cs.p.ovn.turtle.Turtle;
import se.lth.cs.window.SimpleWindow;

public class H4_5 {
    public static void main(String[] args){

        SimpleWindow window = new SimpleWindow(900,900,"Two Turtles");

        Turtle ture = new Turtle(window,100,100);
        Turtle tellus = new Turtle(window,800,800);
        ture.penDown();
        tellus.penDown();


        int turePosX,turePosY,tellusPosX,tellusPosY,tureLength,tellusLength,tureAngle = 90,tellusAngle = 90,tureLastAngle = 0,tellusLastAngle = 0;
        int moveQuantity=0;
        double tureRandom, tellusRandom;

        while ((Math.hypot(Math.abs(ture.getX()-tellus.getX()), Math.abs(ture.getY()-tellus.getY()))) > 50){

            tureLastAngle += tureAngle;
            tellusLastAngle += tellusAngle;

            tureRandom =  Math.random();
            tureLength = (int) ((tureRandom*10)+1);
            tureAngle = (int) ((tureRandom*360)-179);
            turePosX = (int)(ture.getX() + (Math.cos(Math.toRadians(tureAngle+tureLastAngle))*tureLength));
            turePosY = (int)(ture.getY() - (Math.sin(Math.toRadians(tureAngle+tureLastAngle))*tureLength));
            while ((turePosX < 0 || turePosX > 900) || (turePosY < 0 || turePosY > 900)){

                tureRandom =  Math.random();
                tureLength = (int) ((tureRandom*10)+1);
                tureAngle = (int) ((tureRandom*360)-179);
                turePosX = (int)(ture.getX() + (Math.cos(Math.toRadians(tureAngle+tureLastAngle))*tureLength));
                turePosY = (int)(ture.getY() - (Math.sin(Math.toRadians(tureAngle+tureLastAngle))*tureLength));

            }
            ture.left(tureAngle);
            ture.forward(tureLength);

            tellusRandom =  Math.random();
            tellusLength = (int) ((tellusRandom*10)+1);
            tellusAngle = (int) ((tellusRandom*360)-179);
            tellusPosX = (int)(tellus.getX() + Math.cos(Math.toRadians(tellusAngle+tellusLastAngle))*tellusLength);
            tellusPosY = (int)(tellus.getY() - Math.sin(Math.toRadians(tellusAngle+tellusLastAngle))*tellusLength);
            while ((tellusPosX < 0 || tellusPosX > 900) || (tellusPosY < 0 || tellusPosY > 900)){
                tellusRandom =  Math.random();
                tellusLength = (int) ((tellusRandom*10)+1);
                tellusAngle = (int) ((tellusRandom*360)-179);
                tellusPosX = (int)(tellus.getX() + (Math.cos(Math.toRadians(tellusAngle+tellusLastAngle))*tellusLength));
                tellusPosY = (int)(tellus.getY() - (Math.sin(Math.toRadians(tellusAngle+tellusLastAngle))*tellusLength));
            }
            tellus.left(tellusAngle);
            tellus.forward(tellusLength);
            moveQuantity++;

        }
        System.out.println("They made it!" + "\nIt took " + moveQuantity + " movements to complete" );
        System.out.println(ture.getX() + " " + ture.getY());
        System.out.println(tellus.getX() + " " + tellus.getY());
    }
}
