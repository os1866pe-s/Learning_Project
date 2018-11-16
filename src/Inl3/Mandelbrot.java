package Inl3;


import java.awt.*;

public class Mandelbrot {

    public static void main(String[] args) {

        MandelbrotGUI mb = new MandelbrotGUI();
        mb.enableInput();
        Generator gen = new Generator();



        while (true) {
            int test =  mb.getCommand();

            switch (test){
                case MandelbrotGUI.RESET:
                    mb.resetPlane();
                    break;
                case MandelbrotGUI.QUIT:
                    System.exit(0);
                    break;
                case MandelbrotGUI.RENDER:
                    gen.render(mb);
                    break;
                case MandelbrotGUI.RESOLUTION_VERY_LOW:
                    gen.render(mb);
            }

        }
    }
}
