package school.EDDA10.Ovn2;

import se.lth.cs.p.ovn.turtle.Turtle;
import se.lth.cs.window.SimpleWindow;

import java.util.Scanner;

public class E2_1 {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the quantity of sides of the polygon: ");
        int sides = userInput.nextInt();

        SimpleWindow win = new SimpleWindow(600, 600, "Polygons");

        Turtle Ture = new Turtle(win, 200, 100);


        int side_length = (int) (2*200*(Math.tan(Math.PI/sides)));
        System.out.println(side_length);

        int x_Temp = Ture.getX();
        int y_Temp = Ture.getY();

        System.out.println("\n" + x_Temp + y_Temp);
        Ture.right(90);

        Ture.penDown();
        for (int i = 0; i < sides; i++){
            Ture.forward(side_length);
            Ture.right(360/sides);
            x_Temp = Ture.getX();
            y_Temp = Ture.getY();

            System.out.println("\n" + x_Temp + y_Temp);

        }



    }
}
