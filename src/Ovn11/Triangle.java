package Ovn11;

import se.lth.cs.window.SimpleWindow;

public class Triangle extends Shape{

    private int sideLength;
    private int lowerHeight;

    /**Creates a Shape "Triangle" with a specified sidelength.*/
    protected Triangle(int x, int y, int sideLength) {
        super(x, y);
        this.sideLength = sideLength;
    }

    /**Draws the Shape in the SimpleWindwo "w".*/
    public void draw(SimpleWindow w) {
        int tempHalfSide = sideLength/2;

        int height = (int) (Math.sqrt(3)/2*sideLength);
        lowerHeight = (int) ((Math.sqrt(Math.pow(tempHalfSide,2)*4/3))/2);
        int upperHeight = height-lowerHeight;

        w.moveTo(x, y - upperHeight);
        w.lineTo(x + tempHalfSide, y + lowerHeight);
        w.lineTo(x - tempHalfSide, y + lowerHeight);
        w.lineTo(x, y - upperHeight);

    }

    /**Returns the data of the shape in a readable format.*/
    public String getData() {
        String tempData = "T " + x + " " + y + " " + sideLength;

        return tempData;
    }

    public boolean inside(int px, int py){
        double basen = sideLength/2 - Math.abs(x-px);

        double height = lowerHeight + (y-py);

        if (Math.toDegrees(Math.atan(height/basen)) <= 60 && Math.toDegrees(Math.atan(height/basen)) >= 0 && height > 0){
            return true;
        }else {
            return false;
        }

    }
}
