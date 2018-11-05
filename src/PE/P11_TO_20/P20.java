package PE.P11_TO_20;

import java.math.BigInteger;

public class P20 {
    //Calculates the sum of all the numbers in 100!
    public static void main(String[] args){

        BigInteger fac = fact(100);

        String fac100 = fac.toString();
        int sum = 0;

        for (int i = 0; i < fac100.length(); i++){
            sum += fac100.charAt(i) - 48;
        }

        System.out.println(sum);
    }

    private static BigInteger fact(long n) {
        BigInteger result = BigInteger.ONE;
        for (long i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
}
