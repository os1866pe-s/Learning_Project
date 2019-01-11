package school.EDDA10.Ovn8;

import java.util.Arrays;
import java.util.Scanner;

public class E8_3 {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter (amount, letters, amount out, startAt)");
        int n = userInput.nextInt();
        String word = userInput.next();
        int m = userInput.nextInt();
        int start = userInput.nextInt();

        char letters[] = new char[n];
        for (int i = 0; i < n; i++){
            letters[i] = word.charAt(i);

        }

        char finalLetters[] = new char[m];
        for (int j =0; j < m; j++){
            finalLetters[j] = letters[(j+start) % n];
        }
        System.out.println(Arrays.toString(finalLetters));
    }
}
