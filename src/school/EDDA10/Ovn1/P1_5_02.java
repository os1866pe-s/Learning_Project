package school.EDDA10.Ovn1;

import java.util.Scanner;

public class P1_5_02 {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("ange antalet tal: ");
        int tal = input.nextInt();
        int big = 0;
        int nextBig = 0;

        int siffror;
        for (int i = 0; i < tal; i++){
            System.out.print("Vilka är dina tal: ");
            siffror = input.nextInt();

            if (big < siffror){
                nextBig = big;
                big = siffror;

            }
        }
        System.out.println("Största: " + big + " \n" + "Näststörsta: " + nextBig);
    }
}
