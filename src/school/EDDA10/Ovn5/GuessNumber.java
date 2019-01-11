package school.EDDA10.Ovn5;

import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);
        int minValue, maxValue, guessQuantity = 1;

        System.out.print("Enter range for hidden object[min,max]: ");

        minValue = userInput.nextInt();
        maxValue = userInput.nextInt();

        NumberGenerator numGen = new NumberGenerator(minValue,maxValue);
        numGen.drawNbr();

        int guess;
        String result;

        System.out.print("Guess a number: ");
        guess = userInput.nextInt();

        while (!numGen.isEqual(guess)){
            result = (numGen.isBiggerThan(guess)) ? "to small." : "to big.";
            System.out.println("Your number was " + result);

            System.out.print("Guess a number: ");
            guess = userInput.nextInt();
            guessQuantity++;
        }
        System.out.println("Your number was correct!");
        System.out.println("It took you " + guessQuantity + " times to guess the right number.");

    }
}
