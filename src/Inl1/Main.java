package Inl1;

import se.lth.cs.p.inl1.*;
import se.lth.cs.p.inl1.nbr11.*;
public class Main {

    private static TextWindow textWindow1, textWindow2, textWindow3;
    private static TextView textView1, textView2, textView3;
    private static Key key;
    private static Cryptographer crypto;

    public static void main(String[] args){

        TestCase testCase = new TestCase();
        key = new Key();
        crypto = new Cryptographer(key);

        textWindow1 = new TextWindow("Chiffering");
        textWindow2 = new TextWindow("Chiffering");
        textWindow3 = new TextWindow("Chiffering");

        textView1 = new TextView("Klartext : ", 10, 50);
        textView2 = new TextView("Min chiffertext : ", 10, 50);
        textView3 = new TextView("Korrekt chiffertext : ", 10, 50);

        textWindow1.addView(textView1);
        textWindow2.addView(textView2);
        textWindow3.addView(textView3);

        int i = 1;
        while (true){

            textView1.displayText(testCase.getClearText(i));
            textView2.displayText(crypto.encrypt(testCase.getClearText(i)));
            textView3.displayText(testCase.getCryptoText(i));

            textWindow3.waitForMouseClick();
            if (i == 5){
                break;
            }
            i++;
        }
    }
}
