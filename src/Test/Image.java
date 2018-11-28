package Test;

public class Image {

    private int[][] pixels;
    private int width;
    private int height;


    public Image(int m, int n){
        width = m;
        height = n;
        pixels = new int[m][n];
    }

    public void improve(){
        int[][] pixelTemp = pixels.clone();

        if (width > 2 && height > 2) {

            for (int i = 1; i < (width - 1); i++) {
                for (int j = 1; j < (height -1); j++){
                    pixelTemp[i][j] = (int) Math.round(getNeighbours(i, j) / 9.0);
                }
            }
        }
        pixels = pixelTemp;

    }

    public int getNeighbours(int x, int y){
        int total = 0;
        for (int k = x - 1; k <= x + 1; k++){
            for (int h = y -1; h <= y + 1; h++){
                if (!(x == k && y == h)){
                    total += pixels[k][h];
                }
            }
        }
        return total;
    }

    public int[][] getPixels(){
        return pixels;
    }

    public int getPixel(int x, int y){
        return pixels[x][y];
    }

    public void setPixel(int x, int y, int num){
        pixels[y][x] = num;
    }

    public void printPixels(){
        for (int[] i : pixels){
            for (int j : i){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
