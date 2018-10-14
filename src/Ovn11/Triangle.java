package Ovn11;

import se.lth.cs.window.SimpleWindow;

public class Triangle extends Shape{

    private int sideLength;

    /**Creates a Shape "Triangle" with a specified sidelength.*/
    protected Triangle(int x, int y, int sideLength) {
        super(x, y);
        this.sideLength = sideLength;
    }

    /**Draws the Shape in the SimpleWindwo "w".*/
    public void draw(SimpleWindow w) {
        int tempHalfSide = sideLength/2;

        int height = (int) (Math.sqrt(3)/2*sideLength);
        int lowerHeight = (int) ((Math.sqrt(Math.pow(tempHalfSide,2)*4/3))/2);
        int upperHeight = height-lowerHeight;

        w.moveTo(x, y - upperHeight);
        w.lineTo(x + tempHalfSide, y + lowerHeight);
        w.lineTo(x - tempHalfSide, y + lowerHeight);
        w.lineTo(x, y - upperHeight);

    }
}
