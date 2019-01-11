package school.EDDA10.Ovn1;

import java.util.Scanner;

public class E1_2 {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter 11 numbers: ");
        int firstNum = userInput.nextInt();
        int sumSmall = 0;
        int sumBig = 0;
        int numTemp;

        for (int i = 0; i<10;i++){
            numTemp = userInput.nextInt();
            if (numTemp != firstNum){
                if (numTemp <firstNum){
                    sumSmall += numTemp;
                }else {
                    sumBig += numTemp;
                }
            }
        }
        System.out.println("Sum of the numbers bigger than " + firstNum + ": " + sumBig);
        System.out.println("Sum of the numbers smaller than " + firstNum + ": " + sumSmall);
    }
}
