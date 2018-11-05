package PE.P11_TO_20.P18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TrianglePath {

    File file;
    int[] bestPath;
    int[][] triangle;
    int rows;
    int[][] sumTriangle;

    /**Creates a trianglePath to solve the best path in a triangle.*/
    public TrianglePath(String file, int rows){
        this.file = new File(file);
        bestPath = new int[rows];
        triangle = new int[rows][rows];
        this.rows = rows;
        load();
        calc();
    }

    public int[] getPath(){
        return bestPath;
    }

    /**This will load in the file and add it to a 2d array.*/
    private void load(){
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null)
            {
                builder.append(line + "\n");
            }
            br.close();


        }catch (IOException e){
            e.printStackTrace();
        }

        String[] tokens = builder.toString().split("\\s+");

        int i = 1;
        int k = 0;
        for (int y = 0; y < rows; y++){
            for (int x = 0; x < i; x++){
                triangle[x][y] = Integer.parseInt(tokens[k]);
                k++;
            }
            if (i <= rows-1){
                i++;
            }

        }
    }

    /**This will calculate the path which has the biggest sum in a triangle.*/
    private void calc(){

        int[][] tempTriangle = triangle;
        int[][] result = new int[rows][rows];

        for (int y = rows-1; y > 0; y--){
            for (int x = 0; x < y; x++){
                tempTriangle[x][y-1] = ( tempTriangle[x][y] > tempTriangle[x+1][y]) ? tempTriangle[x][y-1] + tempTriangle[x][y] : tempTriangle[x][y-1] + tempTriangle[x+1][y];
            }
        }
        sumTriangle = tempTriangle;

    }

    /**Prints out the triangle to the console.*/
    public void getTriangle(){

        for (int y = 0; y < rows; y++){
            for (int x = 0; x < y+1; x++){
                System.out.print(triangle[x][y] + " ");
            }
            System.out.println();
        }
    }

    /**Returns the sum of the best path.*/
    public int getResult(){

        /*
        for (int y = 0; y < rows; y++){
            for (int x = 0; x < y+1; x++){
                System.out.print(sumTriangle[x][y] + " ");
            }
            System.out.println();
        }
        */
        return sumTriangle[0][0];
    }
}
