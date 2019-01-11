package school.EDDA10.Ovn8;

public class H8_4 {
    public static void main(String[] args){


        double x = 1.6;
        double step = 0.8;

        while (step > Math.pow(10,-5)){

            if (Math.abs(Math.exp(-(x-step))-1+Math.cos(x-step)) < Math.abs(Math.exp(-x)-1+Math.cos(x))){
                x = x-step;

            }else {
                x = x+step;


            }
            step = 2*step/3;
        }
        System.out.println(x);

    }
}
