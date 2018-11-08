package PE.P21_TO_30;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P21 {

    //public static final int CARD = 52;
    //private static
    //public
    //protected
    //private

    private P21(){
        //Empty.
    }

    public static void main(String[] args){

        /*
        List<Integer> apa = IntStream.range(1, 10000)
                .filter(x -> x % 2 == 0)
                .map(x -> x * 3)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(apa);
        */

        int sum = IntStream.range(0,10000)
                .filter(P21::isAmicable)
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
