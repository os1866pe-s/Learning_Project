package Test;

public class SannolikDie {
    public static void main(String[] args){

        Die d = new Die();
        double res1 = 0, res2 = 0;

        for(int i = 0; i< 50000000; i++ ){

            int p1 = 0, p2 = 0;

            while ((p1 <= 100) && (p2 <= 100)){
                d.roll();
                p1 += d.getResult();

                d.roll();
                p2 += d.getResult();

            }
            if (p1 >= 100){
                res1++;
            }else {
                res2++;
            }

        }
        System.out.println(res1/50000000 + " " + res2/50000000);

        //Around 58.4% and 41.6%
        //40% higher win-rate for player1.
    }

}
