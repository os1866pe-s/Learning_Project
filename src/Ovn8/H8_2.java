package Ovn8;


public class H8_2 {
    public static void main(String[] args){


        int vector2[] = {2, -5, 14, 21, -7, 0, 0};
        VectorAddons vec = new VectorAddons(vector2);
        vec.addNumAtPos(2,1);
        vec.getVector();
        vec.removePos(3);
        vec.getVector();
        vec.addNumAtPos(200,3);
        vec.getVector();
        vec.addNumAtPos(-11,0);
        vec.getVector();
        System.out.println("All numbers is bigger than 0: " + vec.allNotZeros());

    }
}
