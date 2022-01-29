import java.util.*;

public class PlayWordle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word, guess = "";
        int tries = 6;

        // Split word into an array of letters
        word = Words.GenerateWord();
        List<String> acceptableAnswers = Words.ValidWords();                           // User can only enter valid words of the English language
        String[] wordList =  word.split("");
        String[] guessList = {"_", "_", "_", "_", "_"};

        System.out.println("\n***************** WELCOME TO WORDLE *****************");
        System.out.println("You have 6 tries to guess a 5-letter word. Good luck!");
        System.out.println("*****************************************************\n");

        // CHEATER CHEATER CHEATER
//        System.out.print(word);

        while (tries > 0) {
            // Display board and letters user has guessed correctly
            for (String letter : guessList) {
                System.out.print(letter + " ");
            }

            // Prompt user to enter a word with 5 letters
            System.out.print("\nEnter your guess: ");
            guess = in.nextLine().toUpperCase();

            // If they don't enter a 5-letter word, ask again
            while (guess.length() != 5 || !acceptableAnswers.contains(guess)) {       // word must be 5 letters and a valid word in the english language
                System.out.print("\nPlease enter a valid 5-letter word: ");
                guess = in.nextLine().toUpperCase();
            }

            // If user guesses incorrectly...
            if (!guess.equals(word)) {
                // One life is taken away, if last guess is wrong then dont go through rest of if-statement
                tries--;
                if (tries == 0) {
                    System.out.printf("\nYou lost! The word was %s\n", word);
                    break;
                }

                String[] noRepeats = word.split("");                     // noRepeats will prevent multiples of same 'wrong position' statement from being printed
                String[] guessLetters = guess.split("");                 // Turns users guess into a list of each letter
                int count = 0;

                for (String letter : guessLetters) {
                    // If the letter from the guess is in the target word
                    if (Arrays.asList(wordList).contains(letter)  ) {
                        // letter is in right position
                        if (letter.equals(wordList[count])) {                  // count variable is keeping track of index in wordList. If letter is the same at the same index, the guess is correct
                            guessList[count] = letter;                         // '_' in guessList will be replaced with the correct letter
                        }
                        else {
                            if (Arrays.asList(noRepeats).contains(letter) ) {            // if the letter is in the word, but the indexes don't match
                                System.out.printf("\n%s is in the wrong position.", letter);
                                noRepeats[Arrays.asList(noRepeats).indexOf(letter)] = null;     // make the index where the letter is in the noRepeats array equal to null (so wrong position statement doesn't print multiple times)
                            }
                        }
                    }
                    count++;
                }

                // One life is taken away
                System.out.printf("\nYou have %d attempt(s) left.\n\n", tries);
            }
            else {
                System.out.println("\n" + guess);
                System.out.println("You got it!");
                break;
            }

        }

    }

}
