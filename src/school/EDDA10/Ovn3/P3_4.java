package school.EDDA10.Ovn3;

import java.util.Scanner;

public class P3_4 {
    public static void main(String[] args){
        /** The following will calculate the standard deviation and average value from custom values.*/
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter the amount of numbers you want to enter: ");
        int amount = userInput.nextInt();
        System.out.print("Now enter your numbers: ");



        int i = 0;
        double sumPow=0,sum=0,tempIn;

        while (i<amount){
            i++;
            tempIn = userInput.nextDouble();
            sum +=tempIn;
            sumPow += (Math.pow(tempIn,2));
        }

        double standAv, medel = (sum/i);
        System.out.println("Medelvärdet: " + medel);

        if (i <= 5){
            System.out.println("För få tal för standardavvikelse.");
        }else {
            standAv = (Math.sqrt((sumPow-(i* Math.pow(medel,2)))/(i-1)));
            System.out.println("Standardavvikelsen: " + standAv);
        }
    }
}
