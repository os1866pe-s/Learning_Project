package PE.P1_TO_10;

public class P5 {
    public static void main(String[] args) {

        System.out.println(Evenly_Divisible(1,20));


    }

    //Returs if the number is divisible between the two indexes
    public static boolean Evenly_Divisible(int firstIndex, int secondIndex) {

        boolean answer = false;
        int i = secondIndex+1;
        while (!answer) {
            //System.out.println(i);
            for (int j = firstIndex; j <= secondIndex; j++) {
                if (i % j == 0) {
                    answer = true;
                } else {
                    answer = false;
                    break;
                }


            }
            i++;
        }
        System.out.println(i-1);
        return answer;
    }
}
