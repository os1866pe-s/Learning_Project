package Ovn11;

import se.lth.cs.window.SimpleWindow;

public class Square extends Shape{

    private int sideLength;

    /**Creates a Shape "Square" with a specified sidelength.*/
    public Square(int x, int y, int sideLength){
        super(x,y);
        this.sideLength = sideLength;
    }

    /**Draws the square in SimpleWindow "w"*/
    public void draw(SimpleWindow w) {
        w.moveTo(x - (sideLength/2),y - (sideLength/2));

        w.lineTo(x + (sideLength/2),y - (sideLength/2));
        w.lineTo(x + (sideLength/2),y + (sideLength/2));
        w.lineTo(x - (sideLength/2),y + (sideLength/2));
        w.lineTo(x - (sideLength/2),y - (sideLength/2));
    }
}
