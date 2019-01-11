package school.EDDA10.Ovn11;

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
        for (Shape i: shapeList){
            i.draw(w);
        }
    }

    /**Finds a close Shape to biggestIndex x, y.
     * Returns null if there is no such shape in the list.*/
    public Shape findHit(int x, int y){

        Shape tempShape = null;

        for (int i = 0; i < shapeList.size(); i++) {
            if (shapeList.get(i).inside(x, y)){
                tempShape = shapeList.get(i);
                break;
            }
        }
        return tempShape;
    }

    /**Returns the data of the shape at a chosen biggestIndex.*/
    public String getShapeData(int index){
        String tempData = shapeList.get(index).getData();

        return tempData;
    }

    /**Returns the length of the shapelist.*/
    public int getLength(){
        return shapeList.size();
    }
}
