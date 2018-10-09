package Test;

public class FrogTest {
    public static void main(String[] args){
        Frog frog = new Frog();

        for (int i = 0; i < 100; i++){
            frog.jumpNorth();
        }
        System.out.println(frog.getX() + " " + frog.getY());

    }
}
