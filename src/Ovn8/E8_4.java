package Ovn8;

import java.util.Arrays;

public class E8_4 {
    public static void main(String[] args){
        Polygon polygons[] = new Polygon[1000];
        double largesArea = 0;
        int polygonSize[] = {0,0,0,0,0,0,0,0};

        for (int i = 0; i < 1000; i++){
            polygons[i] = new Polygon();
        }

        for (int i = 0; i < 1000; i++){

            polygonSize[polygons[i].getSides()-3] += 1;
            if (polygons[i].getArea() > largesArea){
                largesArea = polygons[i].getArea();
            }
        }

        System.out.println(largesArea);
        System.out.println(Arrays.toString(polygonSize));

    }
}
