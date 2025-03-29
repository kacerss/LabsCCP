import java.util.NoSuchElementException;

public class Deck {
    private Card[] cards;
    private int topIndex = 0;

    Deck(Card[] cards) {
        this.cards = cards;
    }

    boolean hasCards() {
        return this.topIndex <= this.cards.length - 1;
    }

    Card dealCard() {
        // This method throws an expection if you try to deal
        // when no cards are left.
        if (!hasCards()){
            throw new NoSuchElementException("No cards left");
        }
        Card c = this.cards[this.topIndex];
        this.topIndex++;
        return c;
    }

}
