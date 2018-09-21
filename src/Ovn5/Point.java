package Ovn5;

public class Point {

    private int x, y;
    private double distance;

    /**Skapar en punkt med kordinaterna x, y.*/
    public Point(int x,int y){
        this.x = x;
        this.y = y;

    }
    /**Returnerar x-kordinaten.*/
    int getX(){
        return x;
    }
    /**Returnerar y-kordinaten.*/
    int getY(){
        return y;
    }
    /**Flyttar punkten sträckan dx i x-led, dy i y-led.*/
    void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }
    /**Returnerar avståndet mellan två punkter.*/
    public double distanceTo(Point p){

        distance = Math.hypot(Math.abs(this.x -p.getX()),Math.abs(this.y-p.getY()));

        return distance;
    }

}
