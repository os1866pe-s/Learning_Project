package Test;

import java.awt.*;

public class Fill extends DrawShape{

    public Fill(Color c){
        staff.turnNorth();
        staff.right(180);
        staff.penDown();
        w.setLineColor(c);

        for (int i = 0; i < (getSize()-2);i++){
            staff.jumpTo(getX()-getSize()+1+i, getY()-getSize()+1);
            staff.forward(getSize()-2);
        }

    }
}
