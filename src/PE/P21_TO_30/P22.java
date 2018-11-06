package PE.P21_TO_30;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class P22 {

    private static StringBuilder names;
    private static String[] tokens;

    private P22(){

    }

    public static void main(String[] args) {
        load("src\\PE\\P21_TO_30\\p022_names.txt");
        //sort();

        //System.out.println(nameValue(0));//5162st names





        int i = 0;
        long sum = 0;
        while (isMoreNames(i)){

            sum += nameValue(i) * (i + 1);

            i++;
        }
        System.out.println(sum);

    }


    private static long nameValue(int x) {

        int sum = 0;
        char[] word = tokens[x].toCharArray();
        for (int i = 0; i < tokens[x].length(); i++){
            sum += word[i] - 'A' + 1;
        }

        return sum;
    }

    private static boolean isMoreNames(int x) {
        return x < tokens.length;
    }

    private static void sort(String[] stringArray) {

        int switches = 0;
        int i = 0;
        while (switches > 0) {
            while (isMoreNames(i)) {
                if (stringArray[i].charAt(0) > stringArray[i + 1].charAt(0)) {
                    switches++;

                }
            }
            switches = 0;
        }

    }

    private static void load(String file) {
        names = new StringBuilder();
        String line = "";

        try {
            BufferedReader bf = new BufferedReader(new FileReader(new File(file)));

            while ((line = bf.readLine()) != null){
                names.append(line + "\n");

            }

            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tokens = names.toString().split("\",\"");
    }

}
