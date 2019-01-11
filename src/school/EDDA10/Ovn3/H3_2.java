package school.EDDA10.Ovn3;

import java.util.Scanner;

public class H3_2 {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num1 = userInput.nextInt();

        if (num1%2 == 0){ System.out.println("Your number is a even number!");
        }else{ System.out.println("Your number is a odd number!"); }

        if (num1%10 == 1){ System.out.println("You number is ending on 1");
        }else if(num1%10 == 0) { System.out.println("Your number is ending on 0"); }

        if ((num1/(num1%100))>1){
            System.out.println("Your number is 3 digits or larger");
        }


    }
}
