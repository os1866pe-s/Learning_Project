package school.EDDA10.Ovn2;

import java.util.Scanner;

public class H2_3 {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        double firstNum = userInput.nextInt();
        double secondNum = userInput.nextInt();

        double sum = firstNum + secondNum;
        double dif = firstNum - secondNum;
        double prod = firstNum * secondNum;
        double quotient = firstNum /secondNum;

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + dif);
        System.out.println("Product: " + prod);
        System.out.println("Quotient: " + quotient);

    }
}
