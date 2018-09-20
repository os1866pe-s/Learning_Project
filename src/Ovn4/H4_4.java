package Ovn4;

import se.lth.cs.p.ovn.turtle.Turtle;
import se.lth.cs.window.SimpleWindow;

import java.util.Scanner;

public class H4_4 {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);
        System.out.println("Click in the window to draw a square.");

        SimpleWindow window = new SimpleWindow(900,900,"Square Click");
        Turtle ture = new Turtle(window,100,100);

        int tempX,tempY,quantity = 0;
        ture.penDown();
        while (true){
            window.waitForMouseClick();
            tempX = window.getMouseX();
            tempY = window.getMouseY();

            ture.jumpTo(tempX,tempY);
            for (int i = 0; i < 4;i++){
                ture.right(90);
                ture.forward(300);
            }
            quantity++;
            System.out.println("You made " + quantity + " squares.");
        }

    }
}
