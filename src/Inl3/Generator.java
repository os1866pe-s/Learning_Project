package Inl3;

import java.awt.*;

public class Generator {

    public Generator(){

    }

    /**Draws an image in the user-interface gui*/
    public void render(MandelbrotGUI gui){
        gui.disableInput();

        Complex[][] complex = mesh(gui.getMinimumReal(), gui.getMaximumReal(),
                                    gui.getMinimumImag(), gui.getMaximumImag(),
                                    gui.getWidth(), gui.getHeight());
        Color[][] picture = new Color[gui.getWidth()][gui.getHeight()];

        for (int i = 0; i < picture.length; i++){
            for (int k = 0; k < picture.length; k++){
                if (complex[i][k].getAbs2() > 1){
                    picture[i][k] = Color.WHITE;
                }else if (complex[i][k].getIm() < 0){
                    if (complex[i][k].getRe() > 0){
                        picture[i][k] = Color.RED;
                    }else{
                        picture[i][k] = Color.GREEN;
                    }
                }else {
                    if (complex[i][k].getRe() > 0){
                        picture[i][k] = Color.BLUE;
                    }else {
                        picture[i][k] = Color.ORANGE;
                    }
                }

            }
        }
        gui.putData(picture, gui.getWidth(), gui.getHeight());
        gui.enableInput();
    }

    /**Creates a matrix which contains complex numbers
     * which has correct coordinates.*/
    private Complex[][] mesh(double minRe, double maxRe,
                             double minIm, double maxIm,
                             int width, int height){
        Complex[][] plane = new Complex[(int) (maxRe-minRe)][(int) (maxIm - minIm)];

        for (int r = 0; r < (int) (maxRe-minRe); r++){
            for (int c = 0; c < (int) (maxIm - minIm); c++){
                plane[r][c] = new Complex(2,2);
            }
        }

        return plane;
    }
}
