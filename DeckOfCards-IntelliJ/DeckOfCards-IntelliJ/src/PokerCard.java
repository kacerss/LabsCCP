public class PokerCard implements Comparable<PokerCard> {
    private String suit;
    private int value;

    private static final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    public PokerCard(String suit, int value) {
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
        return (suit.equals("Spades") || suit.equals("Clubs")) ? "black" : "red";
    }

    public String getIcon() {
        return switch (this.suit) {
            case "Spades" -> "♠️";
            case "Clubs" -> "♣️";
            case "Diamonds" -> "♢";
            default -> "♡";
        };
    }

    public String getFace() {
        return switch (this.value) {
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            case 14 -> "A";
            default -> String.valueOf(this.value);
        };
    }

    @Override
    public String toString() {
        return this.getFace() + " " + this.getIcon();
    }


    @Override
    public int compareTo(PokerCard other) {

        int suitComparison = this.suit.compareTo(other.suit);
        if (suitComparison != 0) {
            return suitComparison;
        }

        return Integer.compare(this.value, other.value);
    }

    public static PokerCard[] makeDeck() {
        PokerCard[] cards = new PokerCard[52];
        int index = 0;
        for (String suit : suits) {
            for (int i = 2; i <= 14; i++) {
                cards[index] = new PokerCard(suit, i);
                index++;
            }
        }
        return cards;
    }
}
