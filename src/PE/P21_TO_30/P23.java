package PE.P21_TO_30;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class P23 {

    private static long[] abundant = new long[Integer.MAX_VALUE/100];
    private static long[] sumsOf2Abundants = new long[100000];

    private P23(){}

    public static void main(String[] args) {
        init();

        long sum = LongStream.range(0, Integer.MAX_VALUE)
                .filter(x -> !isSumOf2Abundats((int) x))
                .sum();
        System.out.println(sum);

    }

    /**Initializes some numbers.*/
    private static void init() {
        System.out.println("1");
        LongStream.range(0, 10000)
                .filter(x -> x < d(x))
                //.filter()
                .forEach(x -> System.out.println(x + " " + d(x)));

        //System.out.println(Arrays.toString(abundant));

    }


    /**Returns the sum of all the divisors*/
    private static long d(long i){
        return LongStream.range(1,(i / 2) + 1)
                .filter(x -> i % x == 0)
                .sum();
    }


    private static boolean isSumOf2Abundats(int x){
        return sumsOf2Abundants[Arrays.binarySearch(sumsOf2Abundants, x)] == x;
    }

}
