package Ovn8;

import se.lth.cs.window.SimpleWindow;

import java.awt.*;

public class Turtle {

    private SimpleWindow w;
    private double x,y;
    private int degrees;
    private boolean penD;
    private int tempX, tempY;



    /**Creating a turtle which draws in window w*/
    public Turtle(SimpleWindow w,int xHome, int yHome){
        this.w = w;
        x = xHome;
        y = yHome;
        degrees = 90;
        penD = false;
    }
    /**Lowering down the pen.*/
    void penDown(){
        penD = true;
    }
    /**Raise up the pen.*/
    void penUp(){
        penD = false;
    }
    /**Moves the turtle n pixels forward*/
    void forward(int n){
        w.moveTo((int) x, (int) y);
        x += Math.cos(Math.toRadians(degrees))*n;
        y -= Math.sin(Math.toRadians(degrees))*n;
        if (penD){
            w.lineTo((int) Math.round(x), (int) Math.round(y));
        }
    }
    /**Moves the turtle n pixels backwards*/
    void backwards(int n){
        w.moveTo((int) x, (int) y);
        x = Math.cos(Math.toRadians(degrees-180))*n;
        y = Math.sin(Math.toRadians(degrees-180))*n;

    }
    /**Rotates the turtles head beta degrees to the left.*/
    void left(int beta){
        degrees +=beta;
    }
    /**Rotates the turtles head beta degrees to the right.*/
    void right(int beta){
        degrees -=beta;
    }
    /**Moves to newX, newY without drawing.*/
    void jumpTo(int newX, int newY){
        x = newX;
        y = newY;
        w.moveTo((int)x,(int)y);
    }
    /**Resets the turning to upwards.*/
    void turnNorth(){
        degrees = 90;
    }
    /**Resets the turning to downwards.*/
    void setRotation(int degrees){
        this.degrees = degrees;
    }
    /**Resets the turning to left.*/

    int getX(){
        return (int) x;
    }
    /**Returns the current y-coordinate.*/
    int getY(){
        return (int) y;
    }
    /**Returns the current rotation of the turtle head*/
    int getRotation(){
        return degrees;
    }
    /**Draws a square which has the midpoint x, y and the sidelength of 2*size.*/
    void drawSquare(int x, int y, int size){
        this.x = x;
        this.y = y;
        jumpTo(x-size,y-size);
        w.lineTo(x+size,y-size);
        w.lineTo(x+size,y+size);
        w.lineTo(x-size, y+size);
        w.lineTo(x-size,y-size);
    }
    /**Draws a circle with the midpoint x, y and the radius.*/
    void drawCircle(int x, int y, int radius){
        w.moveTo(x+radius, y);
        for (int i = 0; i < 360; i++){
            tempX = (int) (Math.cos(Math.toRadians(i+1))*radius + x);
            tempY = (int) (Math.sin(Math.toRadians(i+1))*radius + y);
            w.lineTo(tempX,tempY);
        }
        w.lineTo(x+radius,y);
    }
    /**Draws a n sided polygon with a inner radius and the middpoint x, y.*/
    void drawPolygon(int x, int y, int radius, int sides){
        w.moveTo(x, y-radius);
        int i = 1;
        int sideAngle = 360/sides;
        while (i < sides){
            tempX = (int) (Math.cos(Math.toRadians(sideAngle*i-90))*radius + x);
            tempY = (int) (Math.sin(Math.toRadians(sideAngle*i-90))*radius + y);
            w.lineTo(tempX,tempY);
            i++;
        }
        w.lineTo(x,y-radius);
    }
    /**Draws a square which is filled with a specific color.*/
    void drawSquareFilled(int x, int y,int size, Color color){
        drawSquare(x,y,size);
        w.setLineColor(color);
        w.moveTo(x-size+1,y);
        w.setLineWidth(2*size-2);
        w.lineTo(x+size,y);

        w.setLineWidth(1);
        w.moveTo(x+size+1,y+size-1);
        w.lineTo(x-size-1,y+size-1);
        w.setLineColor(Color.black);

    }
}
