package PE.P11_TO_20;

import java.math.BigInteger;

public class P16 {
    public static void main(String[] args){

        //double num = Math.pow(2, 1000);

        long sum = 0;
        for (int i = 0; i < BigInteger.valueOf(2).pow(1000).toString().length(); i++){

                sum += BigInteger.valueOf(2).pow(1000).toString().charAt(i)-48;

        }
        System.out.println(sum);
    }
}
