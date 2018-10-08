package Ovn8;

import java.util.Arrays;
import java.util.Random;

public class H8_3 {
    public static void main(String[] args){

        Random rand = new Random();
        char alphabet[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        while ( alphabet.length > 0){
            int nextIndex = rand.nextInt(alphabet.length);


            System.out.print(alphabet[nextIndex] + ", ");

            int j = nextIndex;

            while (j < alphabet.length-1){
                alphabet[j] = alphabet[j+1];
                j++;
            }

            alphabet = Arrays.copyOf(alphabet,alphabet.length-1);

        }

    }
}
