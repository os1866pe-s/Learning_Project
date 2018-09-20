package PE;

public class P7 {
    public static void main(String[] args) {

        System.out.println(primeGen(10001));
    }
    //Generate primeNumbers and based on what index of prime number you want
    public static int primeGen(int index) {
        int range = 0;
        int nPrime = 0;
        int i;
        for (i = 1; range < index;i++) {
            if (isPrime(i)) {
                nPrime = i;
                range++;
            }
        }
        return nPrime;
    }
    public static boolean isPrime(int number) {
        boolean answer = true;
        if (number == 1){
            answer = false;
        }else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    answer = false;
                }
            }
        }
        return answer;
    }
}