public class Main {
    public static void main(String[] args) {

        // Make card creates a shuffled deck so this is done.
        Deck theDeck = new Deck(Card.makeDeck());
        CCPQueue<Card> warPile = new CCPALQ<>();

        CCPQueue<Card> playerOneHand = new CCPLLQ<>();
        CCPQueue<Card> playerOneDiscard = new CCPALQ<>();

        CCPQueue<Card> playerTwoHand = new CCPLLQ<>();
        CCPQueue<Card> playerTwoDiscard = new CCPALQ<>();

        // TODO - Implement the game of WAR.
        while (theDeck.hasCards()) {
            playerOneHand.enqueue(theDeck.dealCard());
            System.out.println("Dealt Card Player 1");
            if (theDeck.hasCards()) {
                playerTwoHand.enqueue(theDeck.dealCard());
                System.out.println("Dealt Card Player 2");
            }
        }
        while (playerOneHand.size() > 0 && playerTwoHand.size() > 0) {
            Card card1 = playerOneHand.dequeue();
            System.out.println(card1);
            System.out.println("Current player one hand size: " + playerOneHand.size());
            System.out.println("Current player one discard size: " + playerOneDiscard.size());
            Card card2 = playerTwoHand.dequeue();
            System.out.println(card2);
            System.out.println("Current player two hand size: " + playerTwoHand.size());
            System.out.println("Current player two discard size: " + playerTwoDiscard.size());
            System.out.println("Is " + card1 + " greater than " + card2 + "?");
            System.out.println(card1.compareTo(card2));

            int cmp = card1.compareTo(card2);
            if (cmp == 0) {
                int victory = resolveWar(playerOneHand, playerTwoHand, playerOneDiscard, playerTwoDiscard, warPile);
                if (victory == 3 || victory == 4){
                    break;
                }
            } else if (cmp > 0) {
                // Player one wins the battle.
                System.out.println("Player one wins battle.");
                playerOneDiscard.enqueue(card1);
                playerOneDiscard.enqueue(card2);
            } else {
                // Player two wins the battle.
                System.out.println("Player two wins battle.");
                playerTwoDiscard.enqueue(card1);
                playerTwoDiscard.enqueue(card2);
            }


            if (playerOneHand.size() == 0) {
                playerOneHand.combine(playerOneDiscard);
            }
            if (playerTwoHand.size() == 0) {
                playerTwoHand.combine(playerTwoDiscard);
            }

            if (playerOneHand.size() == 0 && playerOneDiscard.size() == 0){
                System.out.println("Player One Loses, no cards left to play.");
                break;
            } else if (playerTwoHand.size() == 0 && playerTwoDiscard.size() == 0){
                System.out.println("Player Two Loses, no cards left to play.");
                break;
            }

        }
        // https://en.wikipedia.org/wiki/War_(card_game)

        // 1. Deal all the cards to the two players.
        // 2. Dequeue a card from each player's hand.
        // 3. Decide who wins.
        // 4. Add the cards from the battle to the winning player's discard.
        // 5. When a player's hand is empty combine the hands from the discard pile into the hand.
        // 6. Play until someone has no cards.

    }
    public static int resolveWar(CCPQueue<Card> playerOneHand, CCPQueue<Card> playerTwoHand,
                                 CCPQueue<Card> playerOneDiscard, CCPQueue<Card> playerTwoDiscard,
                                 CCPQueue<Card> warPile) {
        int requiredCards = 3;

        // Check if either player has insufficient cards to continue war.
        if (playerOneHand.size() < requiredCards + 1 || playerTwoHand.size() < requiredCards + 1) {
            if (playerOneHand.size() < requiredCards + 1){
                System.out.println("Player one does not have enough cards. Player 2 wins! ");
                return 3;
            } else {
                System.out.println("Player two does not have enough cards. Player 1 wins!");
                return 4;
            }
            // Decide outcome, print message, and return an indicator.
        }

        // Collect required face-down cards from each player.
        for (int i = 0; i < requiredCards; i++) {
            if (playerOneHand.size() > 0) warPile.enqueue(playerOneHand.dequeue());
            if (playerTwoHand.size() > 0) warPile.enqueue(playerTwoHand.dequeue());
        }

        // Dequeue the face-up war cards.
        Card warCard1 = playerOneHand.dequeue();
        Card warCard2 = playerTwoHand.dequeue();
        warPile.enqueue(warCard1);
        warPile.enqueue(warCard2);

        // Determine the outcome.
        if (warCard1.compareTo(warCard2) > 0) {
            System.out.println("Player one wins the war.");
            // Transfer entire warPile to playerOneDiscard.
            while (warPile.size() > 0) {
                playerOneDiscard.enqueue(warPile.dequeue());
            }
            return 1; // Indicates player one won.
        } else if (warCard1.compareTo(warCard2) < 0) {
            System.out.println("Player two wins the war.");
            while (warPile.size() > 0) {
                playerTwoDiscard.enqueue(warPile.dequeue());
            }
            return 2; // Indicates player two won.
        } else {
            // If there's a tie, recursively resolve the war.
            return resolveWar(playerOneHand, playerTwoHand, playerOneDiscard, playerTwoDiscard, warPile);
        }
    }

}
