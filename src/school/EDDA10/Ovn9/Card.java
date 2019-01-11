package school.EDDA10.Ovn9;

public class Card {

    static final int SPADES = 1;
    static final int HEARTS = SPADES + 1;
    static final int DIAMONDS = SPADES + 2;
    static final int CLUBS = SPADES + 3;

    private int suit;
    private int rank;

    /**Creates a car with a suit(SPADES, HEARTS, DIAMONDS, CLUBS) and a rank(1-13).*/
    public Card(int suit, int rank){
        this.suit = suit;
        this.rank = rank;

    }

    /**Returns the integervalue of the suit.*/
    public int getSuit(){
        return suit;
    }

    /**Returns the rank.*/
    public int getRank(){
        return rank;
    }

    /**Returns a readable text of the information(suit, rank) about the card.*/
    public String cardToString(){

        String cardToString;
        switch (suit){
            case 1 : cardToString = "Spade ";
                break;
            case 2 : cardToString = "Heart ";
                break;
            case 3 : cardToString = "Diamond ";
                break;
            case 4 : cardToString = "Club ";
                break;
            default: cardToString = "Invalid Suit ";

        }
        cardToString = cardToString + Integer.toString(rank ) + " ";
        return cardToString;
    }
}
