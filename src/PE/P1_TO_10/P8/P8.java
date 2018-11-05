package PE.P1_TO_10.P8;
import java.io.*;
import java.util.ArrayList;

public class P8 {
    public static void main(String[] args){

        long product;
        long bigProd = 0;

        ArrayList<Integer> nums = new ArrayList<>(13);
        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\PE\\P08_Data.txt"));

            for (int i = 0; i < 1000; i++){
                product = 1;
                int nextNum = Integer.parseInt(br.readLine());
                if (nums.size() > 12){
                    nums.remove(0);
                }
                nums.add(nextNum);

                if (!nums.contains(0) && nums.size() > 12){

                    for (int k: nums) {
                        product *= k;
                    }
                }
                if (product > bigProd) {
                    bigProd = product;
                }
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n" + bigProd);

        //23514624000
    }
}
