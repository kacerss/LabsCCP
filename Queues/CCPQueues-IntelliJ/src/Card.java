import java.util.Random;

public class Card implements Comparable<Card> {

    private String suit;
    private int value;

    private static final String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return this.suit;
    }

    public int getValue() {
        return this.value;
    }

    public String getColor() {
        if (suit.equals("Spades") || suit.equals("Clubs")) {
            return "black";
        } else {
            return "red";
        }
    }

    public int getSuitValue() {
        switch (this.suit) {
            case "Spades":
                return 3;
            case "Hearts":
                return 2;
            case "Diamonds":
                return 1;
            default:
                return 0;
        }
    }

    public String getFace() {
        if (this.value <= 10) {
            return this.value + "";
        } else if (this.value == 11) {
            return "J";
        } else if (this.value == 12) {
            return "Q";
        } else if (this.value == 13) {
            return "K";
        } else {
            return "A";
        }
    }

    public String toString() {
        return this.getFace() + " of " + this.getSuit();
    }

    /**
     * Implement the Fisher Yates Shuffle
     */
    private static void shuffle(Card[] deck) {
        Random rand = new Random();
        for (int i = deck.length - 1; i >= 1; i--) {
            int j = rand.nextInt(i + 1);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    public static Card[] makeDeck() {
        Card[] cards = new Card[52];
        int index = 0;
        for (String suit : suits) {
            for (int i = 2; i <= 14; i++) {
                cards[index] = new Card(suit, i);
                index++;
            }
        }
        shuffle(cards);
        return cards;
    }

    @Override
    public int compareTo(Card otherCard) {
        return this.value - otherCard.value;
    }

}