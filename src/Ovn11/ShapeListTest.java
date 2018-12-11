package Ovn11;

import se.lth.cs.window.SimpleWindow;

public class ShapeListTest {

    public static void main(String[] args) {
        SimpleWindow w = new SimpleWindow(600, 600, "ShapeListTest");

        LoadFiles load = new LoadFiles("src\\Ovn11\\loadtest.txt");
        WriteFiles write = new WriteFiles("src\\Ovn11\\loadtest.txt");

        ShapeList shapes = load.loadShapes();
        shapes.draw(w);

        Shape tempShape;
        while (true){
            w.waitForMouseClick();

            if ((tempShape = shapes.findHit(w.getMouseX(),w.getMouseY())) != null){
                w.waitForMouseClick();
                tempShape.moveToAndDraw(w, w.getMouseX(),w.getMouseY());
                shapes.draw(w);
                write.writeShape(shapes);
            }
        }
    }
}
