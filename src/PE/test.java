package PE;

import java.util.Scanner;

public class test {
    public static void main(String[] args){

        double num1, numr1,temp1;
        int temp2,digit;

        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter a double: ");
        num1 = userInput.nextDouble();

        System.out.print("Enter the amount of digits: ");
        digit = userInput.nextInt();

        temp2 = (int) Math.pow(10,digit);

        System.out.println(temp2);

        temp1 = num1*temp2;
        temp1 = (int) temp1;
        numr1 = (temp1)/temp2;

        System.out.println(numr1);
    }
}
