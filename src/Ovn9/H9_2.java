package Ovn9;

public class H9_2 {
    public static void main(String[] args){


        double succees = 0;
        int tries = 1000;

        for (int t = 0; t < tries; t++) {

            Card tempCard;
            CardDeck cardDeck = new CardDeck();
            cardDeck.shuffle();
            boolean succeeded = true;

            int i = 0;
            for (int j = 0; j < 52; j++) {
                tempCard = cardDeck.getCard();

                i = (i == 3) ? 0 : i;
                i++;

                if (tempCard.cardToString().contains(" " + Integer.toString(i) + " ")) {
                    succeeded = false;
                }

                //System.out.println(Boolean.toString(succeeded) + j + " " + tempCard + " " + i);
            }
            if (succeeded){
                succees += 1;
            }


        }
        System.out.println();

        System.out.println(succees/tries);
        //0.008157 ~ 0.8%
        //0.008064

    }
}