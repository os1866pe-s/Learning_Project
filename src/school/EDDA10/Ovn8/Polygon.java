package school.EDDA10.Ovn8;

import java.util.Random;

public class Polygon {
    private Random rand;
    private int sides;
    private double area;
    private int sideLength;
    private double innerRadius;

    Polygon(){
        rand = new Random();
        sides = rand.nextInt(8)+3;
        sideLength = rand.nextInt(4)+1;
        double temp = sideLength;
        innerRadius = (Math.sqrt(Math.pow(temp,2) - Math.pow(temp/2, 2)));
    }

    int getSides(){
        return sides;
    }

    double getArea(){
        area = (sides*sideLength*innerRadius)/2;
        return area;
    }

}
