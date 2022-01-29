import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Words {
    /**
     * This method returns a random word from the word bank
     */
    public static String Word() {
        Random rand = new Random();
        List<String> wordBank = Answers();

        // Choose random word from wordBank
        String word = wordBank.get(rand.nextInt(wordBank.size()));          //.get will retrieve the item in that position, nextInt gets a random index from wordBank, .size gets # of elem in list
        return word.toUpperCase();
    }

    /**
     *
     * This method returns the bank of all 5-letter words in the English language
     */
    public static List<String> ValidWords() {
        // Creates empty ArrayList to get all values from the text file
        List<String> wordBank = new ArrayList<>();
        try {
            // Open file for reading
            File wordFile = new File("/Users/bdoug/Desktop/Year Up Stuff/YU ASSIGNMENTS/WordleGame/src/words");
            Scanner reader = new Scanner(wordFile);
            // While the next line is not null
            while (reader.hasNextLine()) {
                // read the next line and add it to the word bank
                String word = reader.nextLine();
                wordBank.add(word.toUpperCase());
            } reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        return wordBank;
    }

    /**
     *
     * This method returns a list of all possible answers
     */
    public static List<String> Answers() {
        // Creates empty ArrayList to get all values from the text file
        List<String> answers = new ArrayList<>();
        try {
            // Open file for reading
            File wordFile = new File("/Users/bdoug/Desktop/Year Up Stuff/YU ASSIGNMENTS/WordleGame/src/answers");
            Scanner reader = new Scanner(wordFile);
            // While the next line is not null
            while (reader.hasNextLine()) {
                // read the next line and add it to the word bank
                String word = reader.nextLine();
                answers.add(word.toUpperCase());
            } reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        return answers;
    }
}
