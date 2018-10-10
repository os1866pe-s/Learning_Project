package Ovn9;

import java.util.Random;

public class CardDeck {

    private Card cards[];
    private Random rand;
    private int cardQuantity;

    /**Creates a Deck of cards*/
    public CardDeck(){
        cards = new Card[52];
        cardQuantity = 52;

        for (int i = 1; i <= 4; i++){
            for (int j = 1; j <= 13; j++){

                cards[i*j-1] = new Card(i-1,j-1);
            }
        }

    }
    /**Mixes the Cards in the deck.*/
    public void shuffle(){
        rand = new Random();
        Card cardTemp;
        int firstSwitch;
        int secondSwitch;

        for (int i = 0; i < 200; i++){
            firstSwitch = rand.nextInt(cardQuantity);
            secondSwitch = rand.nextInt(cardQuantity);

            cardTemp = cards[secondSwitch];
            cards[secondSwitch] = cards[firstSwitch];
            cards[firstSwitch] = cardTemp;
        }
    }

    /**Returns true if there is more cards in the deck.*/
    public boolean moreCards(){
        return cardQuantity != 0;
    }

    /**Retrieves the upper most card to the user and removes it from the deck.*/
    public Card getCard(){
        //Not Done, Do more work
        return cards[cardQuantity-1];
    }
}
