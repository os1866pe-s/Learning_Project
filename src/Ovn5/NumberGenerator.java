package Ovn5;

import java.util.Random;

public class NumberGenerator {

    private int maxValue, minValue, secretNum;
    private static Random rand = new Random();

    /**Skapar ett object som kan generera ett slumpmässigt och hemligt
     * heltal i intervallet [min, max].*/
    NumberGenerator(int min, int max){
        maxValue = max;
        minValue = min;

    }

    /**Drar ett nytt hemligt tal.*/
    void drawNbr(){
        secretNum = rand.nextInt(maxValue-minValue+1)+minValue;
    }

    /**Tar reda på vad det minsta värdet för det hemliga talet kan ha.*/
    int getMin(){
        return minValue;
    }

    /**Tar reda på vad det största värdet för det hemliga talet kan ha.*/
    int getMax(){
        return maxValue;
    }

    /**Tar reda på om det hemliga talet är lika med guess.*/
    boolean isEqual(int guess){
        return guess == secretNum;
    }

    /**Tar reda på om det hemliga talet är större än guess.*/
    boolean isBiggerThan(int guess){
        return secretNum > guess;
    }

    /**Tar reda på om det hemliga talet är större än guess.*/
    boolean isSmallerThan(int guess){
        return secretNum < guess;
    }



}
