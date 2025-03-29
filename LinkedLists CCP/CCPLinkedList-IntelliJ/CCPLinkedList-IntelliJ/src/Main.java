public class Main {
    public static void main(String[] args) {
        System.out.println("==========");
        Deck<Card> theDeck = new Deck<>(Card.makeDeck());
        while(theDeck.hasCards()) {
            System.out.println(theDeck.dealCard());
        }
        System.out.println("==========");
        // Where did the cards go?
        // Put them back or the rest won't work...
        theDeck.restoreDeck();
        theDeck.shuffle();
        while(theDeck.hasCards()) {
            System.out.println(theDeck.dealCard());
        }
        System.out.println("==========");
        // Where did the cards go?
        // Put them back or the rest won't work...
        theDeck.restoreDeck();
        theDeck.sort();
        while(theDeck.hasCards()) {
            System.out.println(theDeck.dealCard());
        }
    }
}
