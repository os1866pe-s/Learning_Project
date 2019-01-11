package Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class TeSt {

    public static void main(String[] args) {
        int G = 'G';
        int O = 'O';
        int M = 'M';
        int X = 'X';

        List<Character> c = new ArrayList<>();
        c.add('I');
        c.add('N');
        c.add('V');
        c.add('E');
        c.add('B');


        int sum = 0;
        for (Character g : c) {
            sum += g;
        }
        System.out.println(sum);

        System.out.println("Sum: " + (int)'S' + (int)'D' + (int)'B' + (int)'V' + (int)'A');
        System.out.println("Mult: " + (G * O * M * X));

        System.out.println((int)'I' + (int)'N' +(int) 'V' + (int)'E' + (int) 'A');
        System.out.println((int)'I' + (int)'N' +(int) 'V' + (int)'E' + (int) 'B');

        System.out.println((int) 'K' + " " + (int) 'E');
    }
}
