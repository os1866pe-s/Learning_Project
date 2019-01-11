package school.EDDA10.Ovn8;

import java.util.Arrays;

public class VectorAddons {

    private int vectorLength;
    private int vector[];
    private boolean allNotZero = true;


    /**Creates a VectorAddon with the vector "vector[]".*/
    public VectorAddons(int vector[]){
        vectorLength = vector.length;
        this.vector = vector;
    }

    /**Adds number "num" at biggestIndex "position" and moves the rest of the
     * numbers in the vector forward.*/
    void addNumAtPos(int num, int position) {

        int j = position;
        int temp1,temp2 = num;

        do {
            temp1 = vector[j];
            vector[j] = temp2;
            temp2 = temp1;
            j++;
        }while (j < vectorLength);
    }

    /**Removes a number at biggestIndex "position" and moves the rest
     * to the left in the vector so "hole" disappear.*/
    void removePos(int position){
        int j = position;
        do {
            vector[j] = vector[j+1];
            j++;
        }while (j < vectorLength-1);

    }

    /**Returns true if all the number is bigger than zero.*/
    boolean allNotZeros(){
        for (int i = 0; i < vectorLength; i++){
            if (vector[i] == 0){
                allNotZero = false;
            }
        }
        return allNotZero;
    }

    /**Prints out the vector.*/
    void getVector(){
        System.out.println(Arrays.toString(vector));
    }
}
