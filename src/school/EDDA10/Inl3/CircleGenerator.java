package school.EDDA10.Inl3;

import java.awt.*;

public class CircleGenerator {

    private int pixelSize;

    public CircleGenerator(){

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

                Complex cplx = mesh[(i*pixelSize)][(k*pixelSize)];

                if(cplx.getAbs2() > 1){
                    picture[i][k] = Color.WHITE;
                }else {
                    if(cplx.getRe()>=0 && cplx.getIm()>=0){
                        picture[i][k] = Color.RED;
                    }else if(cplx.getRe()<0 && cplx.getIm()>=0){
                        picture[i][k] = Color.BLUE;
                    }else if(cplx.getRe()<0 && cplx.getIm() < 0){
                        picture[i][k] = Color.YELLOW;
                    }else {
                        picture[i][k] = Color.BLACK;
                    }
                }


            }
        }
        gui.putData(picture, pixelSize, pixelSize);
        gui.enableInput();
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
