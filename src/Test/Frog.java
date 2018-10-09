package Test;

public class Frog {
    private int x, y;

    /**Creates a frog with the coordinates of (0,0).*/
    public Frog(){
        x = 0;
        y = 0;
    }
    /**Returns the x-coordinate of the frog.*/
    int getX(){
        return x;
    }
    /**Returns the y-coordinate of the frog.*/
    int getY(){
        return y;
    }
    /**Increases the y-coordinate with one.*/
    void jumpNorth(){
        y++;
    }
    /**Increases the x-coordinate with one.*/
    void jumpEast(){
        x++;
    }
    /**Decreases the y-coordiante with one.*/
    void jumpSouth(){
        y--;
    }
    /**Decreases the x-coordinate with one.*/
    void jumpWest(){
        x--;
    }
}
