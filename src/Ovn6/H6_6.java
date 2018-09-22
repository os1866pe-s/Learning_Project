package Ovn6;

import java.util.Arrays;
import java.util.Random;


public class H6_6 {
    public static void main(String[] args){

        int[] vector = new int[10];
        Random rand = new Random();

        for (int i = 0; i < 10; i++){
            vector[i] = rand.nextInt(21);
        }
        System.out.println(Arrays.toString(vector));

        for (int j = 9; j >= 0; j--){
            System.out.print("| " + vector[j]);
        }
        System.out.println("|");
    }
}
