import java.util.Random;

public class Deck<T extends Comparable<T>> {

    private CCPLinkedList<T> cards;
    private CCPLinkedList<T> discardPile;

    public Deck(CCPLinkedList<T> cards) {
        this.cards = cards;
        this.discardPile = new CCPLinkedList<>();
    }

    void reset() {
        this.shuffle();
    }

    void add(T card) {
        // TODO - What are the parameters?
        // TODO
        cards.add(card);
        // Maybe make an overloaded method too...
    }

    void add(CCPLinkedList<T> discardPile) {
        for (T card : discardPile) {
            add(card);
        }
    }

    boolean hasCards() {
        // TODO
        return !cards.isEmpty();
    }

    T dealCard() throws IndexOutOfBoundsException {
        // This method throws an expection if you try to deal
        // when no cards are left.
        if (!hasCards()) {
            throw new IndexOutOfBoundsException("No cards left");
        }

        T dealtCard = cards.remove(0);
        discardPile.add(dealtCard);
        return dealtCard;
    }

    public void restoreDeck(){
        //Add all cards from the discard pile back into main deck
        this.add(discardPile);
        // clear discardPile
        discardPile.clear();

    }
    void shuffle() {
        Random rand = new Random();
        // TODO
        for (int i = 0; i < 7; i++) {
            int n = cards.size();
            for (int j = 0; j < n; j++) {
                int index = rand.nextInt(n);
                T removed = cards.remove(index);
                cards.add(removed);
            }
        }
    }

    void sort() {
        // TODO
        CCPLinkedList<T> temp = new CCPLinkedList<>();
        while (!cards.isEmpty()) {
            T currentCard = cards.remove();

            if (temp.isEmpty()){
                temp.add(currentCard);
                continue;
            }

            int insertIndex = 0;
            while (insertIndex < temp.size() && temp.get(insertIndex).compareTo(currentCard) <= 0){
                insertIndex++;
            }

            temp.add(insertIndex, currentCard);
        }

        cards = temp;
    }
}