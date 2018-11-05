package PE.P1_TO_10;

public class P6 {
    public static void main(String[] args){

        int difference = sumSquare(100) - squareSum(100);
        System.out.println(difference);



    }
    //sum of the square of the first 100 natural numbers
    public static int squareSum(int range){
        int sum = 0;
        for (int j = 1; j <= range; j++){

            sum += j*j;
        }

        return sum;

    }
    //square of the sum of the 100 natural numbers
    public static int sumSquare(int range){
        int sum = 0;
        int tempSum = 0;
        for (int i = 1; i<= range; i++){

            tempSum += i;
            sum = tempSum*tempSum;
        }
        return sum;
    }
}
