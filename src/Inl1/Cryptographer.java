package Inl1;
import se.lth.cs.p.inl1.nbr11.*;

public class Cryptographer {

    //This is the key
    private Key key;
    //This is the text which is ciphered
    private StringBuilder ciphertext;
    //This is the 5 number long key
    private int[] keyarray;

    /**Creates a object for ciphering with the key.*/
    public Cryptographer(Key key){
        this.key = key;
        keyarray = new int[5];

        String temp = Integer.toString(key.get5DigitNumber());
        for (int i = 0; i < 5; i++){
            keyarray[i] = Integer.parseInt(Character.toString(temp.charAt(i)));
        }
    }

    /**Ciphering the text(text) and returns the ciphertext.*/
    public String encrypt(String text){
        ciphertext = new StringBuilder();
        int k = 0;
        for (int i = 0; i < text.length(); i++){

            if (text.charAt(i) == ' '){
                ciphertext.append(" ");
            }else {
                ciphertext.append(key.getLetter(text.charAt(i) - 'A', keyarray[k % 5]));
                k++;
            }
        }
        return ciphertext.toString();
    }
}