package PE.P21_TO_30;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class P22 {

    private static StringBuilder names;
    private static String[] tokens;

    private P22(){

    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        load("src\\PE\\P21_TO_30\\p022_names.txt");
        Arrays.sort(tokens);

        int i = 0;
        long sum = 0;
        while (isMoreNames(i)){

            sum += nameValue(i) * (i+1);

            //System.out.println(tokens[i] + " " + nameValue(i) + " " + (i +1) + " " + (nameValue(i) * (i + 1)));
            i++;
        }
        long endTime = System.nanoTime();

        double duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println(sum + "\nTime: " + duration/1000000 + "ms");

    }

    private static long nameValue(int x) {

        int sum = 0;
        char[] word = tokens[x].toCharArray();
        for (int i = 0; i < word.length; i++){

            sum += word[i] - 'A' + 1;
        }
        return sum;
    }

    private static boolean isMoreNames(int x) {
        return x < tokens.length;
    }

    private static void load(String file) {
        names = new StringBuilder();
        String line;

        try {
            BufferedReader bf = new BufferedReader(new FileReader(new File(file)));

            while ((line = bf.readLine()) != null){
                names.append(line + "\n");

            }

            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Removes all the " characters and for some reason the Ctrl characters to then split the string at , characters.
        tokens = names.toString().replaceAll("\"", "").replaceAll("\\p{Cc}", "").split(",");
    }

}
