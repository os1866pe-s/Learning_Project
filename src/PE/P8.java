package PE;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P8 {
    public static void main(String[] args){

        //we need a class that has a array that moves itself like a snake front to back every time you add a new number.

        int dig1 =0;
        int product13 = 1;
        int lastNum;
        int bigProd = 0;
        int index = 0;

        try {
            File file = new File("src\\PE\\javatest.txt");
            Scanner userInput = new Scanner(file);



            for (int j = 0; j <13; j++){
                dig1 = userInput.nextInt();

                product13 = product13*dig1;
            }
            bigProd = product13;
            System.out.println(bigProd +" " + dig1);
            for (int i = 0; i< 1000-13; i++) {
                lastNum = dig1;
                dig1 = userInput.nextInt();
                if (dig1 == 0){
                    product13 = 1;
                }else {
                    product13 = product13/lastNum*dig1;
                }


                if (product13 > bigProd){
                    bigProd = product13;
                    index = i;

                }
            }
            userInput.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(index + " " + bigProd);



    }

}
