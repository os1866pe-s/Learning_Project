package PE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class P11 {
    public static void main(String[] args){

        File file = new File("src\\PE\\P11_Data.txt");

        StringBuilder sb = new StringBuilder();

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null){
                sb.append(line + "\n");
            }

            br.close();
        }catch (IOException e){
            System.out.println("Error accessing file.");
        }
        String stringFile = sb.toString();

        String[] nums = stringFile.split("\\s+");

        int[][] numbers = new int[20][20];
        int k = 0;
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                numbers[j][i] = Integer.parseInt(nums[k]);
                k++;
            }
        }





        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                System.out.print(numbers[j][i] + " ");
            }
            System.out.println();
        }

        int horzProd = horizontal(numbers);
        int vertProd = vertical(numbers);
        int rightDiagProd = rightDiagonal(numbers);
        int leftDiagProd = leftDiagonal(numbers);

        int big = Math.max(horzProd, vertProd);
        int big2 = Math.max(rightDiagProd,leftDiagProd);
        int big3 = Math.max(big,big2);

        System.out.println(horzProd + " " + vertProd + " " + "\nBiggest: " + big3);
    }

    public static int horizontal(int[][] i){

        int bigProd = 0;

        for (int r = 0; r < 17; r++){
            for (int c = 0; c < 20; c++){
                int nextProd = (i[r][c] * i[r+1][c] * i[r+2][c] * i[r+3][c]);
                if ( nextProd > bigProd){
                    bigProd = nextProd;
                }
            }
        }
        return bigProd;
    }

    public static int vertical(int[][] i){
        int bigProd = 0;

        for (int r = 0; r < 20; r++){
            for (int c = 0; c < 17; c++){
                int nextProd = (i[r][c] * i[r][c+1] * i[r][c+2] * i[r][c+3]);
                if ( nextProd > bigProd){
                    bigProd = nextProd;
                }
            }
        }
        return bigProd;
    }

    public static int rightDiagonal(int[][] i ){
        int bigProd = 0;

        for (int r = 0; r < 13; r++){
            for (int c = 0; c < 13; c++){
                int nextProd = (i[r][c] * i[r+1][c+1] * i[r+2][c+2] * i[r+3][c+3]);
                if ( nextProd > bigProd){
                    bigProd = nextProd;
                }
            }
        }
        return bigProd;
    }

    public static int leftDiagonal(int[][] i ){
        int bigProd = 0;

        for (int r = 3; r < 13; r++){
            for (int c = 3; c < 13; c++){
                int nextProd = (i[r-3][c-3] * i[r-2][c-2] * i[r-1][c-1] * i[r][c]);
                if ( nextProd > bigProd){
                    bigProd = nextProd;
                }
            }
        }
        return bigProd;
    }
}
