package Test;

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



        Item[] items = new Item[10];


        items[0] = new Item("DAA");
        items[1] = new Item("BAA");
        items[2] = new Item("CAA");
        items[3] = new Item("ABA");
        items[4] = new Item("AAA");
        items[5] = new Item("EAAA");
        items[6] = new Item("CBAA");
        items[7] = new Item("AYAA");
		items[8] = new Item("JDAA");
		items[9] = new Item("ADAA");

        for (Item i : items){
            System.out.println(i.getName());
        }

        Item.sortByNames(items, 10);
        System.out.println("----------");
        for (Item i : items){
            System.out.println(i.getName());
        }



        StringBuilder g = new StringBuilder();
        g.append("t\nt" + " h");
		System.out.println(g.toString());
    }



}
