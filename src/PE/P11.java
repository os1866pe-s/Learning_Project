package PE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class P11 {
    public static void main(String[] args){
        int[][] numbers = new int[20][20];

        File file = new File("src\\PE\\P11_Data.txt");

        String line = "";
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for (int i = 0; i < 20; i++){
                for (int j = 0; j < 20; j++){

                    numbers[i][j] = Integer.parseInt(line);
                }
            }

            bufferedReader.close();
        }catch (IOException e){
            System.out.println("Error accessing file.");
        }

        System.out.println(numbers[1][1]);

    }
}
