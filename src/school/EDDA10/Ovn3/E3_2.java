package school.EDDA10.Ovn3;

import java.util.Scanner;

public class E3_2 {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = userInput.nextInt(), temp = 0;
        int i;
        for (i = 3; i<=Math.sqrt(n);i +=2){
            if (n%i ==0){
                System.out.println("You can divide " + n + " by " + i + ".");
                temp = 1;

            }
        }
        if (temp == 0){
            System.out.println(n + " is a prime.");
        }
    }
}
