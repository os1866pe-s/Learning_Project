package PE.P13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class P13 {
    public static void main(String[] args){

        //5537376230

        File file = new File("src\\PE\\P13\\P13_Data.txt");

        long fTenDig = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = br.readLine();

                while (line != null){
                    fTenDig += Long.parseLong(line.substring(0,15));
                    line = br.readLine();
                }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++){
            System.out.print(Long.toString(fTenDig).charAt(i));
        }
    }
}
