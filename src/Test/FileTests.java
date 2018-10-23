package Test;

import se.lth.cs.window.SimpleWindow;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Date;

public class FileTests {

    public static void main(String[] args){

        LocalDateTime t = LocalDateTime.now();

        //"src\\Test\\TxtTestFile.txt"
        File file = new File("src\\Test\\FileTests.java");
        String path = file.getAbsolutePath();


        Date date = new Date(file.lastModified());
        System.out.println(path + "\n" + date + "\n" + t.toLocalTime());

        SimpleWindow w = new SimpleWindow(100,100,"Time");


        while (true){
            w.writeText(t.toLocalTime().toString());
        }

    }
}
