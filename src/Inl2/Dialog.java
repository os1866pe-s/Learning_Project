package Inl2;
import javax.swing.*;
public class Dialog {

	/** Skapar ett Dialog-objekt f�r hantering av popup-dialogrutor. */
	public Dialog() {
	}

	/** Visar en dialogruta med hj�lptexten s d�r anv�ndaren skall mata in ett 
	  * heltal som returneras.
	  * Om anv�ndaren anger ett felaktigt v�rde eller klickar p� "avbryt" s� 
	  * returneras Integer.MAX_VALUE.
	  */
	public int readInt(String s) {
		String in = JOptionPane.showInputDialog(s);
		try {
			int i = Integer.parseInt(in);
			return i;
		} catch (NumberFormatException e) {
			return Integer.MAX_VALUE;
		}
	}

	/** Visar en dialogruta med hj�lptexten s d�r anv�ndaren skall mata in en 
	  * teckenstr�ng som returneras.
	  * Om anv�ndaren klickar p� "avbryt" s� returneras null.
	  */
	public String readString(String s) {
		String in = JOptionPane.showInputDialog(s);
		if (in == null) {
			return null;
		} else {
			return in.trim();
		}
	}

	/** Visar en dialogruta med textstr�ngen s. */
	public void printString(String s) {
	   JOptionPane.showMessageDialog(null, s, "",JOptionPane.PLAIN_MESSAGE);
	}
}
