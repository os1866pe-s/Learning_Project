package PE;

public class P12 {
    public static void main(String[] args){

        //76576500
        long num = triangleNumber(7);
        long divisors = divisors(num);

        long i = 1;
        long n = 1;
        while (divisors(i) < 500){
            n++;
            i += n;
            //System.out.println(i + " " + divisors(i));
        }


        System.out.println(i);

    }

    //Calculates the nth trianglenumber.
    private static long triangleNumber(long n){

        long num = 0;

        for (long i = 1; i <= n;i++){
            num += i;
        }
        return num;
    }

    private static int divisors(long num){
        int numOfDiv = 0;

        for (long i = 1; i <= num; i++){
            if ((num % i) == 0){
                numOfDiv++;
            }
        }
        return numOfDiv;
    }
}
