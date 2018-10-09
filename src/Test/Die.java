package Test;

import java.util.Random;

public class Die {

    private Random rand;
    private int result;

    /**Creating a die.*/
    public Die(){
        rand = new Random();
    }
    /**Throws the die.*/
    void roll(){
        result = rand.nextInt(6)+1;
    }
    /**Returns the result.*/
    int getResult(){
        return result;
    }
}
