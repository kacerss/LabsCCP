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


    public static CCPLinkedList<Card> makeDeck() {
        CCPLinkedList<Card> cards = new CCPLinkedList<>();
        int index = 0;
        for (String suit : suits){
            for (int i = 2; i <= 14; i++){
                cards.add(index, new Card(suit, i));
                index++;
            }
        }
        return cards;
    }

    @Override
    public int compareTo(Card otherCard) {
        // TODO
        int suitDifference = this.getSuitValue() - otherCard.getSuitValue();
        if (suitDifference != 0){
            return suitDifference;
        } else {
            return Integer.compare(this.value, otherCard.getValue());
        }
    }

}
