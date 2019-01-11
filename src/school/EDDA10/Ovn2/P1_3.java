package school.EDDA10.Ovn2;

import se.lth.cs.p.ovn.turtle.Turtle;
import se.lth.cs.window.SimpleWindow;

public class P1_3 {
    public static void main(String[] args){

        SimpleWindow W1 = new SimpleWindow(700,700, "Two Triangles");

        Turtle T1 = new Turtle(W1, 300, 150);
        T1.penDown();
        T1.left(120);

        for (int i= 0; i<3;i++){
            T1.right(120);
            T1.forward(100);
        }
        T1.jumpTo(100,150);

        for (int i= 0; i<3;i++){
            T1.right(120);
            T1.forward(100);
        }



        //This is creating 12 triangles which makes a dodecagon.
        /*
        int x_Temp=0;
        int y_Temp=0;
        for (int i = 0; i<12; i++){
            for (int j = 0; j<3; j++){
                T1.right(120);
                T1.forward(100);
                if (j == 1){
                    x_Temp = T1.getX();
                    y_Temp = T1.getY();
                }
            }
            T1.right(30);
            T1.jumpTo(x_Temp,y_Temp);
        }
        T1.right(30);
        T1.jumpTo(350,335);

        //Creates a star in the middle which is 18 triangles
        for (int i = 0; i<18; i++) {
            for (int j = 0; j < 3; j++) {
                T1.right(120);
                T1.forward(100);
            }
            T1.right(20);
        }
        */
    }
}
