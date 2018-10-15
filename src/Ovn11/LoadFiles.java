package Ovn11;

import java.io.*;

public class LoadFiles {

    private File file;
    private String fileName;

    private ShapeList shapeList = new ShapeList();


    /**Retrieving the name of the file to read.*/
    public LoadFiles(String fileName){

        file = new File(fileName);
        this.fileName = fileName;
    }

    /**Loading the shapes from the file.*/
    public ShapeList loadShapes(){
        String line;

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null){

                if (line.contains("C")){
                    shapeList.insert(new Circle(getX(line),getY(line),getSize(line)));

                }else if (line.contains("T")){
                    shapeList.insert(new Triangle(getX(line),getY(line),getSize(line)));

                }else if (line.contains("S")){
                    shapeList.insert(new Square(getX(line),getY(line),getSize(line)));
                }
            }
            bufferedReader.close();

        }catch (FileNotFoundException ex){
            System.out.println("Unable to open file '" + fileName + "'");

        }catch (IOException e) {
            System.out.println("Error reading file '" + fileName + "'");

        }
        return shapeList;
    }


    /**Returns the x-coordinate of the shape.*/
    private int getX(String line){
        int spaces = 0;
        int index[] = new int[2];

        int i = 0;
        while (spaces < 2){

            if (line.charAt(i) == ' '){
                index[spaces] = i;
                spaces++;
            }
            i++;
        }
        int xCord = Integer.parseInt(line.substring(index[0]+1,index[1]));

        return xCord;
    }

    /**Returns the y-coordinate of the shape.*/
    private int getY(String line){
        int spaces = 0;
        int index[] = new int[3];

        int i = 0;
        while (spaces < 3){

            if (line.charAt(i) == ' '){
                index[spaces] = i;
                spaces++;
            }
            i++;
        }
        int yCord = Integer.parseInt(line.substring(index[1]+1,index[2]));
        return yCord;

    }

    /**Returns the size of the shape.*/
    private int getSize(String line){
        int spaces = 0;
        int index[] = new int[3];

        for (int i = 0; i < line.length(); i++){

            if (line.charAt(i) == ' '){
                index[spaces] = i;
                spaces++;
            }
        }
        int size = Integer.parseInt(line.substring(index[2]+1));

        return size;
    }
}
