package Ovn8;

import se.lth.cs.window.SimpleWindow;

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

        drawStartFinish();

    }

    private void drawStartFinish(){
        w.moveTo(wWidth/2-15, yStart+30);
        w.writeText("Start");

        w.moveTo(wWidth/2-15, yFinish-40);
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
