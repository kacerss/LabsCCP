
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CCPArrayList<Card> l = new CCPArrayList<Card>();
        Card[] deck = Card.makeDeck();
        for (Card c : deck ) {
            l.add(c);
        }
        for (Card c : l) {
            System.out.println(c);
        }
        try {
            SpaceGame[] game = SpaceGame.readFromCSV("C:/Users/mrkac/Downloads/CCPArrayList-IntelliJ/CCPArrayList-IntelliJ/space-cards.csv");
            CCPArrayList<SpaceGame> i = new CCPArrayList<>();

            for (SpaceGame c : game) {
                i.add(c);
            }

            int j = 1;
            for (SpaceGame c : i) {

                System.out.println("[" + j++ + "]" +  " " + c);

            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file.");
        }

    }
}
