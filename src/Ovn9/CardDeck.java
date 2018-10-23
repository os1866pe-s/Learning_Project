package Ovn9;

import java.util.Random;

public class CardDeck {

    private Card cards[];
    int cardQuantity;

    /**
     * Creates a Deck of cards
     */
    public CardDeck() {
        cards = new Card[4*13];
        cardQuantity = 52;

        int m = 1,t = 1;
        for (int i = 1; i <= 56; i++){

            if (t == 14){
                m++;
                t = 1;

            }else {
                cards[i-m] = new Card(m,t);
                t++;
            }
        }
    }

    /**
     * Mixes the Cards in the deck.
     */
    public void shuffle() {
        Random rand = new Random();
        Card cardTemp;
        int firstSwitch;
        int secondSwitch;

        if (cardQuantity > 0){
            for (int i = 0; i < 500; i++) {
                firstSwitch = rand.nextInt(cardQuantity);
                secondSwitch = rand.nextInt(cardQuantity);

                cardTemp = cards[secondSwitch];
                cards[secondSwitch] = cards[firstSwitch];
                cards[firstSwitch] = cardTemp;
            }
        }

    }

    /**
     * Returns true if there is more cards in the deck.
     */
    public boolean moreCards() {
        return cardQuantity > 0;
    }

    /**Retrieves the upper most card to the user and removes it from the deck.*/
    public Card getCard() {
        cardQuantity--;

        if (cardQuantity < 0) {
            return null;

        }else {
            return cards[cardQuantity];
        }
    }
}