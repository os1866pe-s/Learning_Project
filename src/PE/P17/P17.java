package PE.P17;

public class P17 {

    public static void main(String[] args){

        NumberToLetter NumToLetter = new NumberToLetter();

        int length = 0;

        for (int i = 1; i <= 1000; i++){
            String word = NumToLetter.getString(i);
            length += word.length();
            System.out.println(i + " "+ word + " " + word.length());
        }

        System.out.println(length);
    }
}
