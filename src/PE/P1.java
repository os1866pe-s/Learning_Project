package PE;

import java.util.Arrays;

public class P1 {
    public static void main(String[] args){

        //	Multiples of 3 and 5
        /* Easier solution
        public void problem1(){
            int sum=0;
            for(int i=1;i<1000;i++){
                if(i%3==0||i%5==0){
                    sum+=i;
                }
            }
            System.out.println(sum);
        }


        */
        System.out.println(multiSum(1000));


    }
    private static int multiSum(int number_below){
        int sum = 0;
        int[] numbers = new int[number_below];
        int i = 0;
        for (int a_multi = 0; a_multi < number_below; a_multi +=3, i++){
            numbers[i] = a_multi;

        }
        for (int b_multi = 0; b_multi < number_below; b_multi +=5, i++){
            numbers[i] = b_multi;

        }

        Arrays.sort(numbers);

        int j= 998;
        while (j > 0){
            int last_temp = numbers[j+1];
            if (numbers[j] == last_temp){
                numbers[j] = 0;
            }
            j--;
        }

        Arrays.sort(numbers);
        int h = 999;
        while (h != 0){
            sum += numbers[h];
            h--;
        }


        return sum;
    }

}
