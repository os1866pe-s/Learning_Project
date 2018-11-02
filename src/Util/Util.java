package Util;

public class Util {


    public void Util(){

    }

    public static long factorial(long n){
        int fac = 1;
        for (int i = 1; i <= n; i++){
            fac = fac *i;
        }
        return fac;
    }

    public static long comb(long n , long r)
    {
        if( r== 0 || n == r) {
            return 1;
        }
        else {
            return comb(n - 1, r) + comb(n - 1, r - 1);
        }
    }




}
