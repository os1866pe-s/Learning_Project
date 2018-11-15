package Inl2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Register {


    private ArrayList<CD> reg;

    public Register(){
        reg = new ArrayList<CD>();
    }

    /**Adds a new CD with an artist and a title.*/
    public void addCD(String artist, String title){
        reg.add(new CD(artist,title));

    }

    /**Removes all CD's with the artist(artist).*/
    public void removeAllFromArtist(String artist){
        List<CD> test = reg.stream().filter(x -> !x.getArtist().equals(artist))
                .collect(Collectors.toList());




    }

    /**Removes all CD's with the title(title).*/
    public void removeAllWithTitle(String title){}

    /**Finds all of the CD's from the artist(artist).*/
    public void searchByArtist(String artist){}

    /**Finds the CD with the title(title).*/
    public void searchByTitle(String title){}

    /**Returns all the CD's with both the artist and title
     * sorted by artist.*/
    public void getSortedByArtist(){}

    /**Returns all the CD's with both the artist and title
     * sorted by title.*/
    public void getSortedByTitle(){}


    /** Läser registret från filen med namn fileName. */
    public void readFromFile(String fileName) {

        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));

            while ((line = br.readLine()) != null){

            }

            br.close();
        } catch (IOException e) {
            System.out.println("File was not found.");
        }

    }

    /** Sparar registret på fil med namnet fileName. */
    public void writeToFile(String fileName) {

        String line;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)));


            bw.close();
        } catch (IOException e) {
            System.out.println("IO exception");
        }


    }
}
