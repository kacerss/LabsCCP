public class Main {
    public static void main(String[] args) {

        PokerCard[] pokerCards = PokerCard.makeDeck();
        Deck<PokerCard> pokerDeck = new Deck<>(pokerCards);


        Domino[] dominos = Domino.makeSet();
        Deck<Domino> dominoDeck = new Deck<>(dominos);


        pokerDeck.shuffle();
        System.out.println("Shuffled Poker Deck:");
        System.out.println(pokerDeck);


        dominoDeck.shuffle();
        System.out.println("\nShuffled Domino Deck:");
        System.out.println(dominoDeck);


        pokerDeck.reset();
        pokerDeck.sort();
        System.out.println("\nSorted Poker Deck:");
        System.out.println(pokerDeck);


        dominoDeck.reset();
        dominoDeck.sort();
        System.out.println("\nSorted Domino Deck:");
        System.out.println(dominoDeck);
    }
}
