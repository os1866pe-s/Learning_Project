package school.EDDA10.Ovn6;

import java.util.Scanner;

public class P6_3 {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = userInput.nextInt();
        String numString = Integer.toString(num);
        int numLength = numString.length();

        System.out.println(num + " " + numString + " " + numLength);
        boolean[] numTrue = new boolean[10];

        for (int i = 0; i < numLength; i++){

            int index = Integer.parseInt(String.valueOf(numString.charAt(i)));
            numTrue[index] = true;
        }

        int quantity = 0;
        for (int j = 0; j < 10; j++){
            if (numTrue[j]) {
                quantity++;
            }
        }
        System.out.println("The number " + num + " contain " + quantity + " different numbers.");

    }
}
