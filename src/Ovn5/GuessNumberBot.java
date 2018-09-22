package Ovn5;

public class GuessNumberBot {
    public static void main(String[] args) throws InterruptedException {

        NumberGenerator secretNum = new NumberGenerator(1, 1000000);
        secretNum.drawNbr();

        int guess, guessQuantity = 1, guessRange, modifier;
        guess = secretNum.getMax() /2;
        guessRange = secretNum.getMax()/2;

        while (!secretNum.isEqual(guess)){

            modifier = (secretNum.isBiggerThan(guess)) ? 1 : -1;
            guessRange = (guessRange+1)/2;
            guess += guessRange*modifier;
            guessQuantity++;
        }

        System.out.println("The secret number was: " + guess);
        System.out.println("It took " + guessQuantity + " times to guess.");

    }
}
