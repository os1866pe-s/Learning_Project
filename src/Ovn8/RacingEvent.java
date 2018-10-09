package Ovn8;


import Ovn7.Turtle;
import se.lth.cs.window.SimpleWindow;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RacingEvent{

    private int wWidth, wHeight, yStart, yFinish;
    private RaceTrack track;
    private SimpleWindow w;
    private int turtles;
    Color color[] = {Color.BLUE, Color.RED, Color.GREEN, Color.PINK, Color.ORANGE};

    private Turtle turtle[] = {null, null, null, null, null};
    private String tPos[] = new String[5];

    /**Creates a racingevent from a racetrack and two turtles.*/
    public RacingEvent(RaceTrack track, Turtle t1, Turtle t2){
        turtle[0] = t1;
        turtle[1] = t2;
        this.track = track;

        this.w = this.track.getWindow();
        wWidth = w.getWidth();
        wHeight = w.getHeight();
        yStart = this.track.getyStart();
        yFinish = this.track.getyFinish();

    }

    /**Creates a racingevent from a racetrack and three turtles.*/
    public RacingEvent(RaceTrack track, Turtle t1, Turtle t2,Turtle t3){
        turtle[0] = t1;
        turtle[1] = t2;
        turtle[2] = t3;
        this.track = track;

        this.w = this.track.getWindow();
        wWidth = w.getWidth();
        wHeight = w.getHeight();
        yStart = this.track.getyStart();
        yFinish = this.track.getyFinish();

    }

    /**Creates a racingevent from a racetrack and four turtles.*/
    public RacingEvent(RaceTrack track, Turtle t1, Turtle t2,Turtle t3,Turtle t4){
        turtle[0] = t1;
        turtle[1] = t2;
        turtle[2] = t3;
        turtle[3] = t4;
        this.track = track;

        this.w = this.track.getWindow();
        wWidth = w.getWidth();
        wHeight = w.getHeight();
        yStart = this.track.getyStart();
        yFinish = this.track.getyFinish();

    }

    /**Creates a racingevent from a racetrack and five turtles.*/
    public RacingEvent(RaceTrack track, Turtle t1, Turtle t2,Turtle t3, Turtle t4, Turtle t5){
        turtle[0] = t1;
        turtle[1] = t2;
        turtle[2] = t3;
        turtle[3] = t4;
        turtle[4] = t5;
        this.track = track;

        this.w = this.track.getWindow();
        wWidth = w.getWidth();
        wHeight = w.getHeight();
        yStart = this.track.getyStart();
        yFinish = this.track.getyFinish();

    }

    /**Starts the race between the n turtles.*/
    public void startRace(int nTurtles){
        turtles = nTurtles;

        for (int i = 0; i<nTurtles;i++){
            if (turtle[i] != null)
            turtle[i].jumpTo((2*i+1)*wWidth/(2*nTurtles),yStart);
            turtle[i].penDown();
        }

        w.setLineWidth(10);

        Random rand = new Random();

        while (!(hasWon(turtle[0]) || hasWon(turtle[1]) || hasWon(turtle[2]) || hasWon(turtle[3]) || hasWon(turtle[4]))){
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i<nTurtles;i++){
                if (turtle[i] != null) {
                    turtle[i].setColor(color[i]);
                    turtle[i].forward(rand.nextInt(3));
                }
            }
        }

        for (int i = 0; i < nTurtles; i++){
            if (turtle[i] != null){
                tPos[i] = hasWon(turtle[i]) ? "Won" : "Lost";
                turtle[i].penUp();
            }

        }

        printPos();

    }


    /**Returns if the turtle t has crossed the finish-line.*/
    private boolean hasWon(Turtle t){

        if (t != null) {
            return t.getY() <= yFinish;
        }else  {
            return false;
        }
    }

    /**Prints out if the turtle won or lost */
    private void printPos(){
        for (int i = 0; i<turtles; i++){
            if (turtle[i] != null){
                w.setLineColor(color[i]);
                w.moveTo(((2*i+1)*wWidth/(2*turtles))-20, wHeight-yStart-15);
                w.writeText("Blue" + tPos[i]);
            }
        }

    }
}
