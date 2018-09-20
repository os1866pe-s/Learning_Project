package Ovn3;

public class P3_2 {
    public static void main(String[] args){

        int sum = 0;
        int i = 1;
        int index = 1;

        while (sum <=100000){
            sum = sum + i;
            i = i+2;
            index++;
        }
        System.out.println("The sum of " + index + " odd numbers is: " + sum);
    }
}
