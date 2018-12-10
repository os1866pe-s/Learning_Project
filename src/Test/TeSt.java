package Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TeSt {

    public static void main(String[] args) {

        ApartmentRegister apr = new ApartmentRegister();

        Apartment a = new Apartment(1, 20);
        a.setSquareMetreRent(30);
        apr.insert(a);
        Apartment b = new Apartment(1, 30);
        b.setSquareMetreRent(30);

        apr.insert(b);

        System.out.println(a.lessExpensiveThan(b));

        System.out.println("\\n");

        int[] row = new int[5];
        row[0] = 5;
        row[1] = 7;
        row[2] = 3;
        row[3] = 10;
        row[4] = 2;

        Sorting.insertionSort(row, 5);

        System.out.println(Arrays.toString(row));
    }



}
