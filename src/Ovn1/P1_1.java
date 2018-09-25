package Ovn1;
import se.lth.cs.p.ovn.turtle.Turtle;
import se.lth.cs.window.SimpleWindow;

public class P1_1 {

    public static void main(String[] args){

        SimpleWindow Window1 = new SimpleWindow(500,500, "Ovn8.Turtle Window");
        Turtle turtle = new Turtle(Window1,250,250);

        turtle.penDown();
        turtle.forward(100);
        turtle.penUp();
        turtle.forward(25);
        turtle.left(90);
        turtle.forward(50);
        turtle.right(180);
        turtle.penDown();
        turtle.forward(100);

        turtle.turnNorth();
        //Simpler version \/ \/

        turtle.jumpTo(370, 250);
        turtle.penDown();
        turtle.forward(100);
        turtle.jumpTo(320,125);
        turtle.right(90);
        turtle.forward(100);
    }
}

