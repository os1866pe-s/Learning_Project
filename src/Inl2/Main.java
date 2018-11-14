package Inl2;

public class Main {
    public static void main(String[] args) {

        Dialog dialog = new Dialog();

        //dialog.printString("This is some text");
        int test = dialog.readInt("Write a int");

        String text = dialog.readString("Is this text");

        System.out.println("You wrote " + test + " and " + text);
    }
}
