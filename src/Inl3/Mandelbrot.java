package Inl3;


import com.bulenkov.darcula.DarculaLaf;

import javax.swing.*;

public class Mandelbrot {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new DarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        int iterations = 255;

        MandelbrotGUI mb = new MandelbrotGUI();
        mb.enableInput();
        //JulianSetGenerator gen = new JulianSetGenerator();
        Generator gen = new Generator();
        //CircleGenerator gen = new CircleGenerator();

        boolean hasImage = false;

        while (true) {
            int test =  mb.getCommand();

            switch (test){
                case MandelbrotGUI.RESET:
                    mb.resetPlane();
                    mb.clearPlane();
                    hasImage = false;
                    break;
                case MandelbrotGUI.QUIT:
                    System.exit(0);
                    break;
                case MandelbrotGUI.RENDER:
                    if ((!mb.getExtraText().equals("")) && (Integer.parseInt(mb.getExtraText()) <= 20000)){

                        gen.render(mb,Integer.parseInt(mb.getExtraText()));
                    }else {
                        gen.render(mb,iterations);
                    }

                    hasImage = true;
                    break;
                case MandelbrotGUI.ZOOM:
                    if (hasImage){
                        if ((!mb.getExtraText().equals("")) && (Integer.parseInt(mb.getExtraText()) <= 20000)){

                            gen.render(mb,Integer.parseInt(mb.getExtraText()));
                        }else {
                            gen.render(mb,iterations);
                        }
                        System.out.println((!mb.getExtraText().equals("")) && (Integer.parseInt(mb.getExtraText()) <= 20000));

                    }
                    break;


            }

        }
    }
}
