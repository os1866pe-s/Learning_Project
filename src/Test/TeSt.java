package Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TeSt {

    public static void main(String[] args) {

        Image image = new Image(3,3);
        image.setPixel(0,0, 5);
        image.setPixel(1,0, 2);
        image.setPixel(2,0, 0);
        image.setPixel(0,1, 7);
        image.setPixel(1,1, 2);
        image.setPixel(2,1, 0);
        image.setPixel(0,2, 9);
        image.setPixel(1,2, 7);
        image.setPixel(2,2, 3);

        image.printPixels();

        System.out.println();
        image.improve();

        image.printPixels();

        ArrayList<Integer> arrayList = new ArrayList<>();

        //1, 2, 3 Autoboxar dem till Integer objects
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        arrayList.remove(1);


        System.out.println(arrayList.get(1) + " " + arrayList.indexOf(3));

    }
}
