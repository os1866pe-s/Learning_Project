package school.EDDA10.Ovn11;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFiles {

    private String fileName;
    private File file;

    /**Retrieves the filename of the file to write to.*/
    public WriteFiles(String fileName){

        this.fileName = fileName;

    }

    /**Writes the shapeData to the file.*/
    public void writeShape(ShapeList shapeList){

        file = new File(fileName);
        try {
            FileWriter fileWriter = new FileWriter(file);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i <shapeList.getLength(); i++){
                bufferedWriter.write(shapeList.getShapeData(i));
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing file to " + fileName);
        }
    }
}
