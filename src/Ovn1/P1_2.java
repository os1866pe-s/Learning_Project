package Ovn1;
import se.lth.cs.p.ovn.turtle.Turtle;
import se.lth.cs.window.SimpleWindow;

public class P1_2 {
    public static void main(String[] args){

        SimpleWindow window1 = new SimpleWindow(500, 500, "Turtle Window");

        Turtle turtle1 = new Turtle(window1, 100,400);
        
        turtle1.penDown();
        turtle1.forward(300);
        for (int i = 0;i < 3; i++){
            turtle1.right(90);
            turtle1.forward(300);
        }


        /*
        turtle1.right(120);
        turtle1.forward(300);
        turtle1.right(120);
        turtle1.forward(300);
        */
    }
}
