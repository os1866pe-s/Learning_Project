package Inl3;

import java.awt.*;

public class Generator {

    private int pixelSize;

    public Generator(){

    }

    /**Draws an image in the user-interface gui*/
    public void render(MandelbrotGUI gui){
        gui.disableInput();

        switch (gui.getResolution()){
            case MandelbrotGUI.RESOLUTION_VERY_LOW:
                pixelSize = 1;
                break;
            case MandelbrotGUI.RESOLUTION_LOW:
                pixelSize = 2;
                break;
            case MandelbrotGUI.RESOLUTION_MEDIUM:
                pixelSize = 3;
                break;
            case MandelbrotGUI.RESOLUTION_HIGH:
                pixelSize = 4;
                break;
            case MandelbrotGUI.RESOLUTION_VERY_HIGH:
                pixelSize = 5;
                break;
        }

        int height = gui.getHeight();
        int width = gui.getWidth();

        Complex[][] mesh = mesh(gui.getMinimumReal(), gui.getMaximumReal(),
                                    gui.getMinimumImag(), gui.getMaximumImag(),
                                    gui.getWidth(), gui.getHeight());

        Color[][] picture = new Color[(int) (height / pixelSize)][(int) (width / pixelSize)];


        for (int i = 1; i <= picture.length; i++){
            for (int k = 1; k <= picture[i].length; k++){

                Complex cplx = mesh[(pixelSize/2 + i*pixelSize)][(pixelSize/2 + i*pixelSize)];

                switch (gui.getMode()){
                    case MandelbrotGUI.MODE_BW:
                        if (cplx.getRe() > 0){
                            picture[i][k] = Color.BLACK;

                        }else {
                            picture[i][k] = Color.WHITE;

                        }

                    case MandelbrotGUI.MODE_COLOR:
                        if (cplx.getRe() > 0){
                            if (cplx.getIm() > 0){
                                picture[i][k] = Color.BLUE;

                            }else {
                                picture[i][k] = Color.RED;
                            }
                        }else {
                            if (cplx.getIm() > 0){
                                picture[i][k] = Color.GREEN;
                            }else {
                                picture[i][k] = Color.YELLOW;
                            }
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
