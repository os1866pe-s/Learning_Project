package school.EDDA10.Ovn5;

public class H5_3 {
    public static void main(String[] args){

        Point sven = new Point(200,250);
        Point rune = new Point(300,150);

        System.out.println(sven.distanceTo(rune));

        sven.move(0,0);

        System.out.println(sven.distanceTo(rune));

    }
}
