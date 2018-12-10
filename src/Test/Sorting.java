package Test;

public class Sorting {

    /**Sort a array with "urvalssortering"
     * First is found is placed in the beginning*/
    public static void selectionSort(int[] v, int n){

        for (int k = 0; k < n - 1; k++){
            int min = Integer.MAX_VALUE;
            int minPlace = -1;
            for (int i = k; i < n; i++){
                if (v[i] < min){
                    min = v[i];
                    minPlace = i;
                }
            }
            v[minPlace] = v[k];
            v[k] = min;

        }
    }

    public static void insertionSort(int[] v, int n){
        for (int i = 1; i < n; i++){
            int nbr = v[i];
            int k = i -1;

            while (k >= 0 && v[k] > nbr){
                v[k+1] = v[k];
                k--;
            }
            v[k+1] = nbr;
        }
    }
}
