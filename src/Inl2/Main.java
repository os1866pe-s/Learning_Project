package Inl2;

public class Main {
    public static void main(String[] args) {

        Dialog dialog = new Dialog();
        String menu = "Menu" +
                "\n1: Sätt in en ny skiva " +
                "\n2: Tag bort en artists skivor" +
                "\n3: Tag bort en CD med skivnamnet" +
                "\n4: Sök skivor från artistnamn/del av artistnamn" +
                "\n5: Sök skivor från titeln/del av titeln" +
                "\n6: Se alla skivor sorterade efter artist" +
                "\n7: Se alla skivor sorterade efter titel";

        String artist;


        while (true){
            int choosenMenu = dialog.readInt(menu);

            switch (choosenMenu){
                case 1:


                case 2: ;

                case 3: ;

                default: ;
            }

        }


    }
}
