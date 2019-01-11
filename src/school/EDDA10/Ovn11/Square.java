package school.EDDA10.Ovn11;

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

    /**Returns the data of the shape in a readable format.*/
    public String getData() {
        String tempData = "S " + x + " " + y + " " + sideLength;

        return tempData;
    }

    public boolean inside(int px, int py){
        int[][] square = new int[2][2];

        square[0][0] = x-(sideLength/2);
        square[1][0] = y-(sideLength/2);
        square[0][1] = x+(sideLength/2);
        square[1][1] = y+(sideLength/2);

        if (px >= square[0][0] && px <= square[0][1] && py >= square[1][0] && py <= square[1][1]){
            return true;

        }else {
            return false;
        }
    }
}
