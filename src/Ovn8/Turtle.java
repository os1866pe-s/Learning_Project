package Ovn8;

import se.lth.cs.window.SimpleWindow;

public class Turtle {

    private SimpleWindow w;
    private double x,y;
    private int degrees;
    private boolean penD;



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
    }
    /**Resets the turning to upwards.*/
    void turnNorth(){
        degrees = 90;
    }
    /**Resets the turning to downwards.*/
    void turnSouth(){
        degrees = 270;
    }
    /**Resets the turning to left.*/
    void turnWest(){
        degrees = 180;
    }
    /**Resets the turning to right.*/
    void turnEast(){
        degrees = 0;
    }
    /**Returns the current x-coordinate.*/
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
        for (int i = 0; i < 4; i++){
            right(90);
            forward(2*size);
        }
    }
    /**Draws a circle with the midpoint x, y and the radius.*/
    void drawCircle(int x, int y, int radius){
        jumpTo(x+radius, y);
        for (int i = 0; i < 4*radius; i++){

        }
    }

}
