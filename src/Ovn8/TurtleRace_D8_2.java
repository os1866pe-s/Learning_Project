package Ovn8;

import Ovn7.Turtle;
import se.lth.cs.window.SimpleWindow;

public class TurtleRace_D8_2 {
    public static void main(String[] args){

        SimpleWindow w = new SimpleWindow(600,600,"Race");

        RaceTrack raceTrack = new RaceTrack(550, 50);
        raceTrack.drawTrack(w);

        Turtle ture = new Turtle(w, 0,0);
        Turtle tellus = new Turtle(w, 0,0);

        RacingEvent racingEvent = new RacingEvent(raceTrack,ture,tellus);
        racingEvent.startRace(2);

    }
}
