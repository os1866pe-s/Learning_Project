package Ovn8;

import java.util.Arrays;
import java.util.Scanner;

public class H8_2 {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter a number with destination(num, index): ");
        int numToInsert = userInput.nextInt();
        int index = userInput.nextInt();
        int zeroIndex;

        int vector[] = {2, -5, 14, 21, -7, 0, 0};


        System.out.println(zeroIndex);

        for (int i = zeroIndex; i > (index); i--){
            vector[i] = vector[i-1];

        }
        vector[index] = numToInsert;
        System.out.println(Arrays.toString(vector));
    }
}
