package Ovn8;

import java.util.Arrays;
import java.util.Scanner;

public class H8_2 {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);

        int vector[] = {2, -5, 14, 21, -7, 0, 0};
        int vecLength = vector.length;

        boolean containZero = false;
        boolean zeroIndex[] = new boolean[vecLength];

        for (int i = 0; i < vecLength; i++){
            if (vector[i] == 0){
                containZero = true;
                zeroIndex[i] = true;
            }else {
                zeroIndex[i] = false;
            }
        }
        if (containZero){
            System.out.print("Enter a number with destination(num, index): ");
            int numToInsert = userInput.nextInt();
            int numToInsertIndex = userInput.nextInt();

            if (zeroIndex[numToInsertIndex]){
                vector[numToInsertIndex] = numToInsert;
            }else {


                int j = numToInsertIndex; //3

                int temp2; //-7
                int temp1 = vector[j]; //21
                vector[j] = numToInsert; //insert 3 into index 3
                j++; //4

                while (j < vecLength){ //4
                    temp2 = vector[j]; // -7

                    vector[j] = temp1; //insert 21 into index 4
                    temp1 = temp2; //next number is switched to -7
                    j++;
                }
            }

        }
        System.out.println(Arrays.toString(vector));

    }
}
