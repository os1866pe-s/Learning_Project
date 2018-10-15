package Ovn11;

import se.lth.cs.window.SimpleWindow;

public class ShapeListTest {

    public static void main(String[] args) {
        SimpleWindow w = new SimpleWindow(600, 600, "ShapeListTest");

        LoadFiles load = new LoadFiles("src\\Ovn11\\loadtest.txt");
        ShapeList shapes = load.loadShapes();
        shapes.draw(w);

        while (true){
            w.waitForMouseClick();
            int firstX = w.getMouseX();
            int firstY = w.getMouseY();

            if (shapes.findHit(firstX,firstY) != null){
                w.waitForMouseClick();
                shapes.findHit(firstX,firstY).moveToAndDraw(w, w.getMouseX(),w.getMouseY());
                shapes.draw(w);
            }
        }
    }
}
