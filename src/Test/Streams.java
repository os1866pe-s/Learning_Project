package Test;

import java.util.stream.IntStream;

public class Streams {



    private Streams(){

    }

    public static void main(String[] args) {


        int sum = IntStream.range(0,10000)
                .filter(Streams::isAmicable)
                .filter(x -> x != d(x))
                .sum();

        System.out.println(sum);
    }

    /**Returns the sum of all the divisible numbers of i.*/
    private static int d(int i){

        return IntStream.range(1,i)
                .filter(x -> i % x == 0)
                .sum();
    }

    /**Returns if the number(i) is amicable.*/
    private static boolean isAmicable(int i){

        //System.out.println(i + " " + d(d(i)) + " " + (i == d(d(i))));
        return i == d(d(i));

    }
}
