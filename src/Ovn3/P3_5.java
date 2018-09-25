package Ovn3;

import java.util.Scanner;

public class P3_5 {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter a series of numbers(end with 0): ");

        int num1 = userInput.nextInt();
        int num2 = userInput.nextInt();
        int sideAmount = 0;

        while (num2 != 0){
            if (num1 == num2){
                sideAmount++;
            }
            num1 = num2;
            num2 = userInput.nextInt();
        }
        System.out.println("There was " + sideAmount + " time(s) two numbers side by side was the same.");
        //can you see this?
    }
}
