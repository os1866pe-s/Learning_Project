package Test;

import se.lth.cs.p.ovn.turtle.Turtle;
import se.lth.cs.window.SimpleWindow;

public class DrawShape {

    SimpleWindow w;
    Turtle staff;
    int size;


    public DrawShape(String title){
        w = new SimpleWindow(700, 700, title);
        staff = new Turtle(w,0,0);
        staff.penDown();
    }

    public DrawShape() {
    }

    void square(int size,int x, int y){
        this.size = size;
        staff.jumpTo(x-size,y-size);
        w.moveTo(x,y);
        w.lineTo(x,y);

        for (int i = 0; i<4; i++){
            staff.right(90);
            staff.forward((2*size));
        }
        staff.jumpTo(x,y);
    }

    int getX(){
        return staff.getX();
    }

    int getY(){
        return staff.getY();
    }

    int getSize(){
        return size;
    }


}
