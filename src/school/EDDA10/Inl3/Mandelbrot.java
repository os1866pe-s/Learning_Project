package school.EDDA10.Inl3;


import com.bulenkov.darcula.DarculaLaf;

import javax.swing.*;

public class Mandelbrot {

    public static void main(String[] args) {
        //Theme
        try {
            UIManager.setLookAndFeel(new DarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        //Iteration
        int iterations = 255;

        //Initialize MandelbrotGUI
        MandelbrotGUI mb = new MandelbrotGUI();
        mb.enableInput();

        //JulianSetGenerator gen = new JulianSetGenerator();
        Generator gen = new Generator();
        //CircleGenerator gen = new CircleGenerator();

        boolean hasImage = false;

        //Loop
        while (true) {
            //Get's the last command
            int test =  mb.getCommand();

            //Does different things for each command
            switch (test){
                //RESET
                case MandelbrotGUI.RESET:
                    mb.resetPlane();
                    mb.clearPlane();
                    hasImage = false;
                    break;
                //QUIT
                case MandelbrotGUI.QUIT:
                    System.exit(0);
                    break;
                //RENDER
                case MandelbrotGUI.RENDER:
                    //For custom control with iterations
                    if ((!mb.getExtraText().equals("")) && (Integer.parseInt(mb.getExtraText()) <= 20000)){

                        gen.render(mb,Integer.parseInt(mb.getExtraText()));
                    //If no such text exist user the default iterations
                    }else {
                        gen.render(mb,iterations);
                    }
                    hasImage = true;
                    break;
                //ZOOM
                case MandelbrotGUI.ZOOM:
                    //There is a image
                    if (hasImage){
                        //For custom control with iterations
                        if ((!mb.getExtraText().equals("")) && (Integer.parseInt(mb.getExtraText()) <= 20000)){
                            gen.render(mb,Integer.parseInt(mb.getExtraText()));
                        }else {
                        //If no such text exist user the default iterations
                            gen.render(mb,iterations);
                        }
                    }
                    break;
            }
        }
    }
}
