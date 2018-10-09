package Ovn8;


import Ovn7.Turtle;
import se.lth.cs.window.SimpleWindow;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RacingEvent{

    private int wWidth, wHeight, yStart, yFinish;
    private Turtle t1, t2, t3;
    private RaceTrack track;
    SimpleWindow w;

    String t1Pos,t2Pos, t3Pos;

    /**Creates a racingevent from a racetrack and two turtles.*/
    public RacingEvent(RaceTrack track, Turtle t1, Turtle t2){
        this.t1 = t1;
        this.t2 = t2;
        this.track = track;

        this.w = this.track.getWindow();
        wWidth = w.getWidth();
        wHeight = w.getHeight();
        yStart = this.track.getyStart();
        yFinish = this.track.getyFinish();

    }
    public RacingEvent(RaceTrack track, Turtle t1, Turtle t2,Turtle t3){
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.track = track;

        this.w = this.track.getWindow();
        wWidth = w.getWidth();
        wHeight = w.getHeight();
        yStart = this.track.getyStart();
        yFinish = this.track.getyFinish();

    }

    /**Starts the race between the two turtles.*/
    public void startRace(int nTurtles){


        t1.jumpTo(wWidth/2*nTurtles,yStart);
        t2.jumpTo(3*wWidth/2*nTurtles,yStart);

        try {
            t3.jumpTo(5*wWidth/2*nTurtles,yStart);
            t3.penDown();
        }catch (Exception e){}


        w.setLineWidth(10);

        t1.penDown();
        t2.penDown();
        Random rand = new Random();

        while (!(hasWon(t1) || hasWon(t2) || hasWon(t3))){
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t1.setColor(Color.BLUE);
            t1.forward(rand.nextInt(3));
            t2.setColor(Color.RED);
            t2.forward(rand.nextInt(3));

            try{
                t3.setColor(Color.GREEN);
                t3.forward(rand.nextInt(3));
            }catch (Exception e){}
        }
        t1Pos = hasWon(t1) ? "Won" : "Lost";
        t2Pos = hasWon(t2) ? "Won" : "Lost";
        try{
            t3Pos = hasWon(t3) ? "Won" : "Lost";
            t3.penUp();
        }catch (Exception e){}


        printPos();
        t1.penUp();
        t2.penUp();
    }


    /**Returns if the turtle t has crossed the finish-line.*/
    private boolean hasWon(Turtle t){

        return t.getY() <= yFinish;
    }

    private void printPos(){
        w.setLineColor(Color.BLUE);
        w.moveTo(wWidth/4-20, wHeight-yStart-15);
        w.writeText("Blue " + t1Pos);

        w.setLineColor(Color.RED);
        w.moveTo(3*wWidth/4-20, wHeight-yStart-15);
        w.writeText("Red " + t2Pos);
    }
}
