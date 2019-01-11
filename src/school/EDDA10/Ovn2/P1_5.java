package school.EDDA10.Ovn2;

import java.util.Arrays;

public class P1_5 {
    public static void main(String[] args){

        int inputData[] = new int[100];

        for (int i = 0; i<100; i++){
            inputData[i] = (int) (1000*Math.random());
        }

        Arrays.sort(inputData);
        int big = inputData[99];
        int nextBig = inputData[98];

        int dif = big - nextBig;

        System.out.println("The difference between the two biggest numbers is: " + dif + "\nThe biggest number is: " + big);

    }
}
