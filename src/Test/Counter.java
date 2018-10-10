package Test;

import Ovn7.Turtle;
import se.lth.cs.window.SimpleWindow;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Counter {
    public static void main(String[] args){

        SimpleWindow w = new SimpleWindow(200,100, "Counter");
        w.moveTo(50,50);
        Turtle pen = new Turtle(w,0,0);
        pen.penDown();
        String addon;

        Random rand = new Random();

        for (int i = 0; i <= 999999; i++){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pen.drawSquareFilled(1,1,300, Color.white);
            w.moveTo(50,50);

            if (i > 9){
                if (i > 99){
                    if (i > 999){
                        if (i > 9999){
                            if (i > 99999){
                                addon = "";
                            }else {
                                addon = "0";
                            }
                        }else {
                            addon = "00";
                        }
                    }else {
                        addon = "000";
                    }
                }else {
                    addon = "0000";
                }
            }else {
                addon = "00000";
            }
            w.writeText(addon + i);

        }


    }
}
