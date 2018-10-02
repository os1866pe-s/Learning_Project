
package PE;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter a number: ");
        System.out.println(isPrime(userInput.nextInt()));
        System.out.println(largestPrime(600851475143L));



    }
    // Finds if a specific number is a prime or not
    public static boolean isPrime(long number){

        if (number == 2){
            return true;
        }else {
            for (int i = 2; i < number; i++){
                if (number%i == 0){

                    return false;
                }
            }
        }
        return true;
    }
    //finds the biggest prime number in a specific number
    public static long largestPrime(long number){
        long large_Prime = 0;

        for (long j = 2; j < number; j++){

            if (number%j == 0 && isPrime(j)){
                number = number / j;
                large_Prime = j;
            }
            if (number > j && isPrime(number)){
                large_Prime = number;
            }
        }
        return large_Prime;
    }
}
