package Ovn11;

import se.lth.cs.window.SimpleWindow;

public class ShapeListTest {
    public static void main(String[] args) {
        SimpleWindow w = new SimpleWindow(600, 600, "ShapeListTest");
        ShapeList shapes = new ShapeList();
        shapes.insert(new Square(100, 300, 100));
        shapes.insert(new Triangle(400, 200, 100));
        shapes.insert(new Circle(400, 400, 50));
        shapes.insert(new Square(450, 450, 50));
        shapes.insert(new Square(200, 200, 35));
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
