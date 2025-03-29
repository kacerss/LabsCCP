import java.io.*;

public class Main {
    public static void main(String[] args) {
        CCPHashMap map = new CCPHashMap();
        /*
         * 1. Load text from file. Have the user enter the file name or use args...
         * 2. Read through the file line by line.
         * 3. Consider normalizing case, removing special characters.
         * 4. Separate words.
         * 5. Check if the word is in the map. If it is, increase the count...
         * 6. If not add it with a count of 1.
         * 7. Traverse the keys to find the keys with the max and min value.
         * 8. Output the results.
         */
        // Load file
        File file = new File("Moby Dick by Herman Melville.txt");
        // Create bufferedReader and FileReader
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null) {
                //Process lines and words and normalize the data to only keep words in the text file.
                line = line.toLowerCase().replaceAll("[^a-z\\s]", "");
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.isEmpty()) continue; //skip empty strings
                    int currentCount = map.get(word);
                    if (currentCount == 0) {
                        map.put(word, 1);
                    } else {
                        map.put(word, currentCount + 1);
                    }
                }

            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());        }


        // Retrieve all keys from the map
        String[] keys = map.keys();

        //  Determine the maximum frequency among the keys.
        int maxCount = 0;
        for (int i = 0; i < keys.length; i++) {
            int count = map.get(keys[i]);
            if (count > maxCount) {
                maxCount = count;
            }
        }

        //  Count how many keys have the maximum frequency and occur once.
        int singleOccurrenceCount = 0;
        for (int i = 0; i < keys.length; i++) {
            int count = map.get(keys[i]);
            if (count == 1) {
                singleOccurrenceCount++;
            }
        }

        //  Allocate arrays based on these counts.
        String[] mostRepeated = new String[1];
        String[] singleOccurrenceWords = new String[singleOccurrenceCount];

        //  Populate the arrays.
        int indexMax = 0;
        int indexOnce = 0;
        for (int i = 0; i < keys.length; i++) {
            int count = map.get(keys[i]);
            if (count == maxCount) {
                mostRepeated[indexMax] = keys[i];
            }
            if (count == 1) {
                singleOccurrenceWords[indexOnce++] = keys[i];
            }
        }

        // 5. Output the results.
        System.out.println("Most repeated word(s) with count " + maxCount + ":");
        for (int i = 0; i < mostRepeated.length; i++) {
            System.out.println(mostRepeated[i]);
        }

        System.out.println("Words that occur only once:");
        for (int i = 0; i < singleOccurrenceWords.length; i++) {
            System.out.println(singleOccurrenceWords[i]);
        }
        // It's interesting to see that words like "message" occur only once.
        // Also, apparently with further research, in the book Moby Dick 44% of words are considered Hapax Legomenon, which
        // means they only appear once. https://en.wikipedia.org/wiki/Hapax_legomenon
    }
}
