package appIdeas;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class stopWatch {
    static int interval;
    static Timer timer;


    public static void main(String[] args) {


        timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            long time = 20000;

            long startTime = System.currentTimeMillis();


            @Override
            public void run() {
                long current = System.currentTimeMillis();
                System.out.println((20000 -time) / 1000 + ":" + time % 1000);
                //System.out.println((current - startTime) + " " + (20000 - time));
                time -= 1;
            }
        };

        timer.scheduleAtFixedRate(timerTask, 0, 1);

        /*
        Scanner sc = new Scanner(System.in);
        System.out.print("Input seconds : ");
        String secs = sc.nextLine();
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = Integer.parseInt(secs);
        System.out.println(secs);
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                System.out.println(setInterval());

            }
        }, delay, period);

    }

    private static final int setInterval() {
        if (interval == 1)
            timer.cancel();
        return --interval;
    */
    }

}