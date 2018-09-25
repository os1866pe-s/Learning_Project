package Test;

public class DieTest {
    public static void main(String[] args){



            Die newDie = new Die();
            newDie.roll();

            int result = newDie.getResult();
            int lastResult;


            int rolls = 2;
            do {
                lastResult = result;
                newDie.roll();
                result = newDie.getResult();
                rolls++;
            } while (lastResult != result);

            System.out.println("It took " + rolls + " times to get two " + result + " in a row.");



    }
}
