package Test;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
//        int G = 'G';
//        int O = 'O';
//        int M = 'M';
//        int X = 'X';
//
//        List<Character> c = new ArrayList<>();
//        c.add('I');
//        c.add('N');
//        c.add('V');
//        c.add('E');
//        c.add('B');
//
//
//        int sum = 0;
//        for (Character g : c) {
//            sum += g;
//        }
//        System.out.println(sum);
//
//        System.out.println("Sum: " + (int)'S' + (int)'D' + (int)'B' + (int)'V' + (int)'A');
//        System.out.println("Mult: " + (G * O * M * X));
//
//        System.out.println((int)'I' + (int)'N' +(int) 'V' + (int)'E' + (int) 'A');
//        System.out.println((int)'I' + (int)'N' +(int) 'V' + (int)'E' + (int) 'B');
//
//        System.out.println((int) 'K' + " " + (int) 'E');

		try {
			Process process = new ProcessBuilder("tasklist.exe", "/fo", "csv", "/nh").start();
			new Thread(() -> {
				Scanner sc = new Scanner(process.getInputStream());
				if (sc.hasNextLine()) sc.nextLine();
				while (sc.hasNextLine()) {
					String line = sc.nextLine();
					String[] parts = line.split(",");
					String unq = parts[0].substring(1).replaceFirst(".$", "");
					String pid = parts[1].substring(1).replaceFirst(".$", "");
					System.out.println(unq + " " + pid);
				}
			}).start();
			process.waitFor();
			System.out.println("Done");
		}catch (InterruptedException | IOException e){
			e.printStackTrace();
		}


    }


}
