package PE.P11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

        int biggest = Math.max(Math.max(horizontal(numbers), vertical(numbers)), Math.max(rightDiagonal(numbers),leftDiagonal(numbers)));

        System.out.println( "Biggest product: " + biggest);
    }


    //I could of created a line followed by sinx and cosx through 135 - 0 degress.


    //Calculates the biggest product horizontally in a grid of numbers.
    private static int horizontal(int[][] i){

        int bigProd = 0;

        for (int r = 0; r < 20; r++){
            for (int c = 0; c < 20; c++){
                int nextProd = (i[r][c] * i[(r+1) % 20][c] * i[(r+2) % 20][c] * i[(r+3) % 20][c]);
                if ( nextProd > bigProd){
                    bigProd = nextProd;
                }
            }
        }
        return bigProd;
    }

    //Calculates the biggest product vertically in a grid of numbers.
    private static int vertical(int[][] i){
        int bigProd = 0;

        for (int r = 0; r < 20; r++){
            for (int c = 0; c < 20; c++){
                int nextProd = (i[r][(c) % 20] * i[r][(c+1) % 20] * i[r][(c+2) % 20] * i[r][(c+3) % 20]);
                if ( nextProd > bigProd){
                    bigProd = nextProd;
                }
            }
        }
        return bigProd;
    }

    //Calculates the biggest product downwards-right-diagonal in a grid of numbers
    private static int rightDiagonal(int[][] i ){
        int bigProd = 0;

        for (int r = 0; r < 20; r++){
            for (int c = 0; c < 20; c++){
                int nextProd = (i[r][c] * i[(r+1) % 20][(c+1) % 20] * i[(r+2) % 20][(c+2) % 20] * i[(r+3) % 20][(c+3) % 20]);
                if ( nextProd > bigProd){
                    bigProd = nextProd;
                }
            }
        }
        return bigProd;
    }

    //Calculates the biggest product downwards-left-diagonal in a grid of numbers
    private static int leftDiagonal(int[][] i ){
        int bigProd = 0;

        for (int r = 0; r < 20; r++){
            for (int c = 0; c < 20; c++){
                int nextProd = (i[(r+3 + 20) % 20][(c-3 + 20) % 20] * i[(r + 2 + 20) % 20][(c-2 + 20) % 20] * i[(r+1 + 20) % 20][(c-1 + 20) % 20] * i[r][c]);
                if ( nextProd > bigProd){
                    bigProd = nextProd;
                }
            }
        }
        return bigProd;
    }
}
