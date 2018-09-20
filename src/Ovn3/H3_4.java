package Ovn3;

public class H3_4 {
    public static void main(String[] args){

        double y, z, num, hyp,hyp1;
        int x = 2;
        int a = 5;
        int b = 3;
        int c = 7;
        int akatet = 4;
        int bkatet = 3;

        y = Math.sin(20);
        z = a*Math.exp(x) + b*Math.exp(-Math.cos(x));

        num = Math.log(a-b)/2*Math.sin(2*Math.PI*c);
        hyp1 = Math.hypot(akatet,bkatet);
        hyp = Math.sqrt(Math.pow(akatet,2)+Math.pow(bkatet,2));

        System.out.println("y: " + y);
        System.out.println("z: " + z);
        System.out.println("num: " + num);
        System.out.println("hyp: " + hyp1);

    }
}
