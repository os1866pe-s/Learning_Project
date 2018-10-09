package Ovn8;

import Ovn7.Turtle;
import se.lth.cs.window.SimpleWindow;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RaceTrack {

    private int yStart, yFinish;
    private int wHeight;
    private int wWidth;
    private SimpleWindow w;


    /**Retrieves important information as the window, start and stop-y.*/
    public RaceTrack(int yStart, int yFinish){

        this.yStart = yStart;
        this.yFinish = yFinish;
    }

    /**Draws the track for the race*/
    public void drawTrack(SimpleWindow w){
        this.w = w;
        wHeight = w.getHeight();
        wWidth = w.getWidth();

        w.moveTo(0, yFinish);
        w.lineTo(wWidth,yFinish);
        w.moveTo(0, yStart);
        w.lineTo(wWidth,yStart);

        w.moveTo(wWidth/2,0+(wHeight-yStart));
        w.lineTo(wWidth/2,wHeight-(wHeight-yStart));
        drawStartFinish();

    }

    private void drawStartFinish(){
        w.moveTo(wWidth/2-15, yStart+20);
        w.writeText("Start");

        w.moveTo(wWidth/2-15, yFinish-20);
        w.writeText("Finish");
    }

    public int getyStart(){
        return yStart;
    }

    public int getyFinish(){
        return yFinish;
    }

    public SimpleWindow getWindow(){
        return w;
    }


}
