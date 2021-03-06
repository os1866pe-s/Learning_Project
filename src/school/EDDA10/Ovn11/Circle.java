package school.EDDA10.Ovn11;

import se.lth.cs.window.SimpleWindow;

public class Circle extends Shape {

    private int radius;

    /**Creates a Shape "Circle" with a specified radius.*/
    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public void draw(SimpleWindow w) {
        int tempX,tempY;
        w.moveTo(x + radius, y);
        for (int i = 0; i < 360; i++) {
            tempX = (int) (Math.cos(Math.toRadians(i + 1)) * radius + x);
            tempY = (int) (Math.sin(Math.toRadians(i + 1)) * radius + y);
            w.lineTo(tempX, tempY);
        }
        w.lineTo(x + radius, y);
    }

    /**Returns the data of the shape in a readable format.*/
    public String getData() {
        String tempData = "C " + x + " " + y + " " + radius;

        return tempData;
    }

    public boolean inside(int px, int py){
        if (Math.hypot(Math.abs(x-px), Math.abs(y-py)) <=radius){
            return true;
        }else {
            return false;
        }
    }
}
