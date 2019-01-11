package school.EDDA10.Ovn4;

import se.lth.cs.p.ovn.turtle.Turtle;
import se.lth.cs.window.SimpleWindow;

public class D4_4 {
    public static void main(String[] args){

        SimpleWindow window = new SimpleWindow(600,600,"Square");
        Turtle t = new Turtle(window,100,200);


        t.penDown();
        for (int i = 1;i<=4; i++){
            t.right(90);
            t.forward(300);
        }

    }
}
