import java.util.Random;

public class Main {
    public static void main(String[] args) {
        CCPBST<Integer> integer = new CCPBST<>();
        int[] nums = {50, 10, 15, 5, 40, 0, 60, 70, 90, 1, 3, 123, 65, 4, 7};
        for (int num : nums) {
            integer.add(num);
        }
        integer.inOrder();
        System.out.println();
        System.out.println("Tree Depth: " + integer.depth());
        System.out.println("Tree Size: " + integer.size());
        System.out.println("-----------------------");

        CCPBST<String> string = new CCPBST<>();
        String[] names = {"Mary", "John", "Jane", "Bob", "May", "Jack", "Juan", "Lucas", "Peter", "Tiana"};
        for (String name : names) {
            string.add(name);
        }
        string.inOrder();
        System.out.println();
        System.out.println("Tree Depth: " + string.depth());
        System.out.println("Tree Size: " + string.size());
        System.out.println("-------------------------");

        PokerCard[] cards = PokerCard.makeDeck();
        PokerCard.shuffleCards(cards);
        CCPBST<PokerCard> finalDeck = new CCPBST<>();


        for (int i = 0; i < 13; i++){
            finalDeck.add(cards[i + 1]);
        }

        finalDeck.preOrder();
        System.out.println();
        finalDeck.inOrder();
        System.out.println();
        finalDeck.postOrder();
        System.out.println();
        System.out.println("Tree Depth: " + finalDeck.depth());
        System.out.println("Tree Size: " + finalDeck.size());



    }
}
