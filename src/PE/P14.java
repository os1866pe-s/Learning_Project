package PE;

public class P14 {
    public static void main(String[] args){

        long total;
        long terms;
        long longTerm = 0;
        long bigTerm = 0;
        for (int i = 1; i < 1000000; i++){

            total = i;
            terms = 1;
            while (total > 1){

                total = ((total % 2) == 0) ? total/2 : 3*total+1;
                terms++;
                //System.out.println(i + " " + total);
            }
            if (terms > longTerm){
                longTerm = terms;
                bigTerm = i;
            }

        }

        System.out.println(longTerm + "\n" + bigTerm);
    }

}
