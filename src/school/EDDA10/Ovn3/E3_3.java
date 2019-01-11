package school.EDDA10.Ovn3;

import java.util.Scanner;

public class E3_3 {
    public static void main(String[] args){

        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter range(x y): ");
        int rangeStart = userInput.nextInt();
        int rangeEnd = userInput.nextInt();

        int valueLong =0, valueShort = 0;
        int seqLong=0, seqShort=Integer.MAX_VALUE,seqTemp=1;
        for (int i = rangeStart; i<=rangeEnd; i++){
            int j = i;
            System.out.print("a0 = " + i + "  ger: ");
            while (newNum(j) != 1){
                System.out.print(newNum(j) + " ");
                j = newNum(j);
                seqTemp++;

            }

            if (seqTemp >seqLong){
                seqLong = seqTemp;
                valueLong = i;
            }
            if(seqTemp < seqShort){
                seqShort = seqTemp;
                valueShort = i;
            }
            seqTemp=1;
            System.out.println("1");
        }

        System.out.println("Long: " + valueLong + " : " + seqLong + "\n" +"Short: " + valueShort + " : " + seqShort);
    }
    public static int newNum(int x){
        int nextNum;

        if (x%2 == 0){
            nextNum = x/2;
        }else {
            nextNum = (3*x +1);
        }
        return nextNum;
    }
}
