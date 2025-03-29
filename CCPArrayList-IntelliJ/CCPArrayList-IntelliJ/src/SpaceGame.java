import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SpaceGame {
    private int type;
    private String label;
    private int movement;

    // Constructor
    public SpaceGame(int type, String label, int movement) {
        this.type = type;
        this.label = label;
        this.movement = movement;
    }

    @Override
    public String toString() {
        return
                "type: " + type + " | " +
                label  +
                " | movement:" + movement
                ;
    }

    public static SpaceGame[] readFromCSV(String filePath) throws IOException {
        ArrayList<SpaceGame> tempList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String header = br.readLine();

            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");


                int type = Integer.parseInt(parts[0].trim());
                String label = parts[1].trim();
                int movement = Integer.parseInt(parts[2].trim());
                int quantity = Integer.parseInt(parts[3].trim());


                for (int i = 0; i < quantity; i++) {
                    SpaceGame c = new SpaceGame(type, label, movement);
                    tempList.add(c);
                }
            }
        }

        SpaceGame[] SpaceGame = new SpaceGame[tempList.size()];
        return tempList.toArray(SpaceGame);
    }
}