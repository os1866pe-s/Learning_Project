package school.EDDA10.Ovn4;

import se.lth.cs.p.ovn.turtle.Turtle;
import se.lth.cs.window.SimpleWindow;

public class E4_2 {
    public static void main(String[] args){

        SimpleWindow window = new SimpleWindow(700,700,"Spiral");

        Turtle ture = new Turtle(window,500,500);
        ture.penDown();

        int length = 100;


        while (length >=30){
            ture.forward(length);
            ture.left(45);
            length = length -10;

        }

    }
}
