package school.EDDA10.Inl3;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Generator {

    private int pixelSize;

    private ArrayList<Color> colors;

    public Generator(){
        colors = new ArrayList<Color>();
        Random r = new Random();
        for(int i =0; i<20000; i++){
            colors.add(new Color((int)(r.nextDouble()*((double)Integer.MAX_VALUE - (double)Integer.MIN_VALUE) + Integer.MIN_VALUE)));
        }
    }

    /**Draws an image in the user-interface gui*/
    public void render(MandelbrotGUI gui, int iterations){
        gui.disableInput();

        switch (gui.getResolution()){
            case MandelbrotGUI.RESOLUTION_VERY_LOW:
                pixelSize = 9;
                break;
            case MandelbrotGUI.RESOLUTION_LOW:
                pixelSize = 7;
                break;
            case MandelbrotGUI.RESOLUTION_MEDIUM:
                pixelSize = 5;
                break;
            case MandelbrotGUI.RESOLUTION_HIGH:
                pixelSize = 3;
                break;
            case MandelbrotGUI.RESOLUTION_VERY_HIGH:
                pixelSize = 1;
                break;
            default:
                pixelSize = 1;
        }

        int height = gui.getHeight();
        int width = gui.getWidth();

        Complex[][] mesh = mesh(gui.getMinimumReal(), gui.getMaximumReal(),
                gui.getMinimumImag(), gui.getMaximumImag(),
                width,height);

        Color[][] picture = new Color[(int) (height / pixelSize)][(int) (width / pixelSize)];


        for (int i = 0; i < picture.length; i++){
            for (int k = 0; k < picture[i].length; k++){

                Complex cplx = mesh[(pixelSize/2 + i*pixelSize)][(pixelSize/2 + k*pixelSize)];
                Complex temp = new Complex(0,0);
                int h = 0;
                //Is the point going to infinity or to a constant number
                while (h < iterations && temp.getAbs2() < 4){
                    temp.mul(temp);
                    temp.add(cplx);
                    //temp.add(new Complex(-0.70176, -0.3842));
                    h++;
                }
                if (gui.getMode() == MandelbrotGUI.MODE_BW){
                    if (h < iterations){
                        picture[i][k] = Color.WHITE;
                    }else {
                        picture[i][k] = Color.BLACK;
                    }
                }else {
                    if (h < iterations){
                        picture[i][k] = new Color(func(h, 1, 0),func(h, 2, 120),func(h, 1, 240));;
                    }else {
                        picture[i][k] = Color.BLACK;
                    }
                }
            }
        }
        gui.putData(picture, pixelSize, pixelSize);
        gui.enableInput();
    }

    private int func(double x, double f, double p){
        return (int) (255*Math.pow((Math.cos(Math.sqrt(x)*f + p)),2));
    }

    /**Creates a matrix which contains complex numbers
     * which has correct coordinates.*/
    private Complex[][] mesh(double minRe, double maxRe,
                             double minIm, double maxIm,
                             int width, int height){

        Complex[][] plane = new Complex[height][width];
        double yStep = (maxIm - minIm) / (height-1);
        double xStep = (maxRe - minRe) / (width-1);

        for (int r = 0; r < height; r++){
            for (int c = 0; c < width; c++){
                plane[r][c] = new Complex(minRe + c * xStep,maxIm - r * yStep);
            }
        }

        return plane;
    }
}
