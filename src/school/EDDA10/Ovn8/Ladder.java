package school.EDDA10.Ovn8;
import school.EDDA10.Ovn7.Turtle;
import se.lth.cs.window.SimpleWindow;

import java.awt.*;

public class Ladder {
    private Turtle t;
    private SimpleWindow window;
    private int steps;
    private  int wWitdh, wHeight;

    public Ladder(int steps){
        window = new SimpleWindow(300,500,"Ladder Movie");

        this.steps = steps;
        wWitdh = window.getWidth();
        wHeight = window.getHeight();

        t = new Turtle(window,wWitdh/2,wHeight);
        t.penDown();
        window.moveTo(wWitdh/2,wHeight);
        for (int i = 0; i < steps; i++){
            t.drawSquare(wWitdh/2-10,wHeight-(20*i), 20);
        }
    }

    public void drawMan(int atStep){
        window.setLineColor(Color.BLUE);

        window.moveTo(wWitdh/2-10, wHeight-(atStep*20)-1);
        window.lineTo(wWitdh/2-10,wHeight-(atStep*20)-11);

        window.setLineColor(Color.BLACK);

    }

    public void eraseMan(int atStep){
        window.setLineColor(Color.WHITE);

        window.moveTo(wWitdh/2-10, wHeight-(atStep*20)-1);
        window.lineTo(wWitdh/2-10,wHeight-(atStep*20)-11);

        window.setLineColor(Color.BLACK);

    }
}
