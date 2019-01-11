package school.EDDA10.Ovn2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        double firstNum = userInput.nextInt();
        double secondNum = userInput.nextInt();

        double sum = firstNum + secondNum;
        double dif = Math.abs(firstNum - secondNum);
        double prod = firstNum * secondNum;
        double quotient = firstNum /secondNum;

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + dif);
        System.out.println("Product: " + prod);
        System.out.println("Quotient: " + quotient);

    }
}
