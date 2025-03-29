public class Card {

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

    public String getIcon() {
        switch (this.suit) {
            case "Spades":
                return "♠️";
            case "Clubs":
                return "♣️";
            case "Diamonds":
                return "♢";
            default:
                return "♡";
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
        return this.getFace() + "" + this.getIcon();
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
        return cards;
    }

}
