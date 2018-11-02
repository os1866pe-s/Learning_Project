package PE.P67;

import PE.P18.TrianglePath;


public class P67 {

    public static void main(String[] args){

        long startTime = System.nanoTime();

        TrianglePath TPath = new TrianglePath("src\\PE\\P67\\p067_triangle.txt", 100);
        System.out.println(TPath.getResult());

        long endTime = System.nanoTime();
        double totalTime = endTime - startTime;
        System.out.println(totalTime/ 1000000 + "ms");
    }
}
