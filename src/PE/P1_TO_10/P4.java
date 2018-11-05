package PE.P1_TO_10;

public class P4 {
    public static void main(String[] args){

        // Find the largest Palindramic number from 2 3-digit numbers.


        int big_Palmic = 0;
        for (int i = 100; i<1000; i++){
            for (int j = 100; j <1000; j++){
                if (isPalindromic(i * j) && j*i > big_Palmic){
                    big_Palmic = i*j;
                    System.out.println("I: " + i +" | " +"J: "+ j);
                }

            }
        }
        System.out.print(big_Palmic);

    }
    public static boolean isPalindromic(int number){

        int length = String.valueOf(number).length();
        boolean answer = false;
        for (int i = 0;i<=length/2; i++){
            if (String.valueOf(number).charAt(i) == String.valueOf(number).charAt(length-1-i)){
                 answer = true;
            } else {
                answer = false;
                break;
            }


        }
        return answer;

    }
}
