package school.EDDA10.Ovn8;

import se.lth.cs.window.SimpleWindow;

import java.util.Random;

public class E8_5 {
    public static void main(String[] args){

        Random rand = new Random();

        int step = 10;
        int numberOfTries = 0;
        Ladder ladder = new Ladder(step);

        ladder.drawMan(1);
        int atStep = 1;
        while (atStep < 10){
            SimpleWindow.delay(40);

            int nextRand = rand.nextInt(20);

            if (nextRand == 0 || nextRand == 1 && atStep < 10 ){
                ladder.eraseMan(atStep);
                atStep++;
                ladder.drawMan(atStep);

                numberOfTries++;
            }else if (nextRand == 1 && atStep > 1){
                ladder.eraseMan(atStep);
                atStep--;
                ladder.drawMan(atStep);

                numberOfTries++;
            }
        }
        System.out.println("It took " + numberOfTries + " times to get from ladder 1 to 10.");
    }
}
