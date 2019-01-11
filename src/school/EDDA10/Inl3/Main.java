package school.EDDA10.Inl3;

public class Main {



    private Main(){}

    public static void main(String[] args) {
        run();
    }

    private static void run(){
        Complex nr1 = new Complex(1, 2);
        Complex nr2 = new Complex(1.5, 3);

        System.out.println(nr1.getAbs2());

        nr1.add(nr2);
        System.out.println(nr1.getRe() + " " + nr1.getIm());

        nr1.mul(nr1);
        System.out.println(nr1.getRe() + " " + nr1.getIm());

    }
}
