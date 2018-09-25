package Test;

import java.util.Random;

public class Die {

    private Random rand = new Random();
    private int result;

    /**Creating a die.*/
    public Die(){

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
