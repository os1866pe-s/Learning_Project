package Util;

import com.bulenkov.darcula.DarculaLaf;

import javax.swing.*;

public class Util {



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

    public static void setLookDracula(){
        try {
            UIManager.setLookAndFeel(new DarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

    }


    //TODO -- maps a value
    public static double map(double num, double x1, double y1, double x2, double y2){


        double range1 = ((x1 - y1) > 0) ? x1 - y1 : y1 - x1;
        double range2 = ((x2 - y2) > 0) ? x2 - y2 : y2 - x2;

        return  range2 / range1  * num;
    }



    public static int map(int num, int x1, int y1, int x2, int y2){
        return 0;
    }


}
