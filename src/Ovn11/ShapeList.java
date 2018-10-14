package Ovn11;

import se.lth.cs.window.SimpleWindow;

import java.util.ArrayList;

public class ShapeList {

    private ArrayList<Shape> shapeList;



    /**Creates a empty list.*/
    public ShapeList(){
        shapeList = new ArrayList<Shape>();
    }

    /**Inserts the shape into the shapelist.*/
    public void insert(Shape shape){
        shapeList.add(shape);
    }

    /**Draws the shapes in the list*/
    public void draw(SimpleWindow w){

        for (int i = 0; i < shapeList.size(); i++){
            shapeList.get(i).draw(w);
        }
    }

    /**Finds a close Shape to index x, y.
     * Returns null if there is no such shape in the list.*/
    public Shape findHit(int x, int y){

        Shape tempShape = null;

        for (int i = 0; i < shapeList.size(); i++) {
            if (shapeList.get(i).near(x, y)){
                tempShape = shapeList.get(i);
                break;
            }
        }
        return tempShape;
    }
}
