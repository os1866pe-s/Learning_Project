package Ovn3;

import java.util.Scanner;

public class H3_5 {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter int a: ");
        int a = userInput.nextInt();

        System.out.print("Enter int b: ");
        int b = userInput.nextInt();

        double x = 2;

        //Samma tecken
        if (a*b >0){
            x = 12.2;
        // olika tecken
        }else if (a*b <0){
            x += 10;
        }
        //någon av a eller b = 0
        if (a ==0 || b == 0){
            x = 2*x;
        }
        // om a ligger i [0,10] eller om a udda och b jämnt
        if ((a <= 10 && a >= 0) || (a%2 ==1 && b%2 == 0)){
            a--;
            b--;
        }

        System.out.println("x:" + x + "\n" +"a:" +a + "\n" + "b: " + b);
    }
}
