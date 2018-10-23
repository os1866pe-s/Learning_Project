package PE;

import java.util.Scanner;

public class P10 {
    //Find the sum of the all the primes below a number.
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a number: ");

        long sum = 0;
        int num = userInput.nextInt();

        int nextPrime = 2;

        while (nextPrime <= num){
            sum += nextPrime;
            //System.out.println(nextPrime);

            nextPrime++;
            while (!isPrime(nextPrime)) {
                nextPrime++;
            }
        }
        System.out.println(sum);



    }

    //Determines if the number is a prime.
    private static boolean isPrime(int num){

        if (num == 2){
            return true;
        }
        if (num == 3){
            return true;
        }
        if (num % 2 == 0){
            return false;
        }
        if (num % 3 == 0){
            return false;
        }

        int i = 5;
        int w = 2;

        while (i*i <= num){
            if (num % i == 0){
                return false;
            }
            i += w;
            w = 6-w;
        }
        return true;
    }
}
