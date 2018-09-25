package Ovn6;

import java.util.Random;

public class P6_1 {
    public static void main(String[] args){

        boolean[] box = new boolean[7];
        Random rand = new Random();
        int index = rand.nextInt(7);
        box[index] = true;

        int roll = rand.nextInt(10);
        int movement =0;

        if (roll <8){
            if (roll <4){
                movement = (index == 6) ? 0 : 1;
            }else {
                movement = (index == 0) ? 0 : -1;
            }
            box[index] = false;
            box[index + movement] = true;
        }

        System.out.println("First place: " + index);
        System.out.println("Second place: " + (index + movement));

    }
}
