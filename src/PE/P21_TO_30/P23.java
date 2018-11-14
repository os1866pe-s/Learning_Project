package PE.P21_TO_30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.LongStream;

public class P23 {

    private static long[] abundant = new long[30000];
    private static long[] notSumAbundant = new long[30000];
    private static ArrayList<Long> sumsOf2Abundants = new ArrayList<>();

    private P23(){}

    public static void main(String[] args) {
        init();



    }

    /**Initializes some numbers.*/
    private static void init() {
        System.out.println("1");
        abundant = LongStream.range(0, 30000)
                .filter(x -> x < d(x))
                .toArray();


        for (int i = 0; i < notSumAbundant.length; i++){
            for (int j = 0; j < abundant[i]/2; j++){
                if (abundant[j] < abundant[i]){
                    //if (Arrays.binarySearch(abundant, abundant[i] - abundant[j])){

                    //}
                }
            }
        }

    }


    /**Returns the sum of all the divisors*/
    private static long d(long i){
        return LongStream.range(1,(i / 2) + 1)
                .filter(x -> i % x == 0)
                .sum();
    }


}
