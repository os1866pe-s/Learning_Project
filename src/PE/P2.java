package PE;

public class P2 {
    public static void main(String[] args){

        //Problem: find the sum of all even numbers in fibonacci under the value of 4'000'000
        System.out.println(fibonacci_sum_even_numbers(4000000));

    }
    public static int fibonacci_sum_even_numbers(int max_value){
        int sum = 2;
        int a = 1;
        int b = 2;
        int temp = 0;

        while (b < max_value){
            temp = a; //1
            a = b; // a=2
            b = a+temp; // b = 1 + 2
            if (b%2 == 0){
                sum += b; // sum = 3+ 3
            }

        }
        return sum;
    }
}
