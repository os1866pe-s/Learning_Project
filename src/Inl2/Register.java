package Inl2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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

        CD cd = new CD(artist,title);

        int min = reg.size();
        int index = 0;
        for (CD t: reg) {
            if (cd.getArtist().toLowerCase().compareTo(t.getArtist().toLowerCase()) < 0){
                min = index;
            }
            index++;
        }

        System.out.println(min);
        reg.add(min, cd);
    }

    /**Removes all CD's with the artist(artist).*/
    public void removeAllFromArtist(String artist){
        (reg.stream().filter(x -> x.getArtist().contains(artist))
                .collect(Collectors.toList())
                ).forEach(x -> reg.remove(x));
    }

    /**Removes all CD's with the title(title).*/
    public void removeAllWithTitle(String title){
        (reg.stream().filter(x -> x.getTitle().contains(title))
                .collect(Collectors.toList())
        ).forEach(x -> reg.remove(x));
    }

    /**Finds all of the CD's from the artist(artist) and returns them.*/
    public String searchByArtist(String artist){
        reg.sort(Comparator.comparing(CD::getTitle));

        List<CD> CDArtist = reg.stream().filter(x -> x.getArtist().contains(artist))
                .collect(Collectors.toList());

        StringBuilder tempLine = new StringBuilder();
        for(CD n : CDArtist){
            tempLine.append(n.toString() + "\n");
        }

        return tempLine.toString();
    }

    /**Finds the CD's with the title(title).*/
    public String searchByTitle(String title){
        reg.sort(Comparator.comparing(x -> x.getTitle().toLowerCase()));

        List<CD> CDArtist = reg.stream().filter(x -> x.getTitle().contains(title))
                .collect(Collectors.toList());

        StringBuilder tempLine = new StringBuilder();
        for(CD n : CDArtist){
            tempLine.append(n.toString() + "\n");
        }

        return tempLine.toString();
    }

    /**Returns all the CD's with both the artist and title
     * sorted by artist.*/
    public String getSortedByArtist(){
        reg.sort(Comparator.comparing(x -> x.getArtist().toLowerCase()));

        StringBuilder tempLine = new StringBuilder();
        for (CD i : reg){
            tempLine.append(i.toString() + "\n");
        }
        return tempLine.toString();
    }

    /**Returns all the CD's with both the artist and title
     * sorted by title.*/
    public String getSortedByTitle(){
        reg.sort(Comparator.comparing(CD::getTitle));

        StringBuilder tempLine = new StringBuilder();
        for (CD i : reg){
            tempLine.append(i.toString() + "\n");
        }
        return tempLine.toString();
    }

    /** Läser registret från filen med namn fileName. */
    public void readFromFile(String fileName) {
        StringBuilder total = new StringBuilder();

        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));

            while ((line = br.readLine()) != null){
                total.append(line);
            }

            br.close();
        } catch (IOException e) {
            System.out.println("File was not found.");
        }

        String[] CDs;
        CDs = total.toString().split(",");

        for (int x = 1; x < CDs.length; x += 2){
                addCD(CDs[x-1], CDs[x]);
        }
    }

    /** Sparar registret på fil med namnet fileName. */
    public void writeToFile(String fileName) {

        String line;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)));

            for (CD k : reg){
                bw.write(k.getArtist() + ",\n" + k.getTitle() + ",\n");
            }

            bw.close();
        } catch (IOException e) {
            System.out.println("IO exception");
        }
    }
}
