package school.EDDA10.Inl2;

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
                "\n7: Se alla skivor sorterade efter titel" +
                "\n8: Exit";


        Register reg = new Register();
        reg.readFromFile("src\\school.EDDA10.Inl2\\Information.txt");

        boolean loop = true;
        while (loop){
            int choosenMenu = dialog.readInt(menu);

            switch (choosenMenu){
                case 1:
                    reg.addCD(dialog.readString("Artist"), dialog.readString("Title"));
                    break;
                case 2:
                    reg.removeAllFromArtist(
                            dialog.readString("Artist"));
                    break;
                case 3:
                    reg.removeAllWithTitle(
                            dialog.readString("Title"));
                    break;
                case 4:
                    dialog.printString(
                            reg.searchByArtist(
                                    dialog.readString("Artist")));
                    break;
                case 5:
                    dialog.printString(
                            reg.searchByTitle(
                                    dialog.readString("Title")));
                    break;
                case 6:
                    dialog.printString(
                            reg.getSortedByArtist());
                    break;
                case 7:
                    dialog.printString(
                            reg.getSortedByTitle());
                    break;
                case 8:
                    loop = false;

            }
        }

        reg.writeToFile("src\\school.EDDA10.Inl2\\Information.txt");
    }
}
