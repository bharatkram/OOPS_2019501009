import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Game extends WordsADT {

    /**
     * defining a scanner variable.
     */
    private Scanner guessed;

    Game() {
        guessed = new Scanner(System.in);
    }

    /**
     * function to let the user guess the name of the movie
     * letter by letter.
     *
     * @param level the level of the word that the user chooses to
     * play for.
     * @return the score of the player.
     */
    public int guess(final int level) {

        //initialising the list of words.
        WordsADT words = new WordsADT();
        words.readTxt();
        words.fixWords();

        //the word to be guessed by the player.
        Word word = new Word();
        int lvl = level;
        while (true) {
            word = words.getWordRandomly(lvl);
            if (word != null) {
                break;
            }
            System.out.println("No words available in the chosen level."
                    + "\nChoose another level:");
            lvl = guessed.nextInt();
        }

        char[] toBeGuessed = word.secretWord();
        System.out.println(new String(toBeGuessed));
        int chances = 4;
        int correctGuesses = 0;
        int hints = 0;
        String answer = word.getWord();
        ArrayList<Character> availableLetters = new ArrayList<Character>(26);

        char guess;
        boolean flag = true;

        // iteration to initialise the availble letters.
        for (char ch = 'a'; ch <= 'z'; ch++) {
            availableLetters.add(ch);
        }

        while (!word.getWord().equals(new String(toBeGuessed))
                    && chances != 0) {
            System.out.println("\n\n\nChances Left: " + chances);
            System.out.println("Enter '.' for hints.");
            System.out.print("Enter your guess: ");
            while (true) {
                try {
                    guess = Character.toLowerCase(guessed.nextLine().charAt(0));
                    break;
                } catch (Exception e) {
                    System.out.println("Please enter something:");
                }
            }

            if (guess == '.') {
                if (hints < 2) {
                    System.out.println(word.getHints(hints++) + "\n\n");
                } else {
                    System.out.println("No more hints to be given.\n\n");
                }
            } else if (availableLetters.contains(guess)) {
                availableLetters.remove((Character) guess);
                flag = true;
                for (int i = 0; i < toBeGuessed.length; i++) {
                    if (answer.charAt(i) == (guess)) {
                        flag = false;
                        correctGuesses += 1;
                        toBeGuessed[i] = guess;
                    }
                }
                if (flag) {
                    System.out.println("Wrong Guess\n\n");
                    chances -= 1;
                } else {
                    System.out.println("Right Guess\n\n");
                }
                System.out.println("Available letters:\n"
                        + Arrays.toString(availableLetters.toArray()));
                System.out.println(new String(toBeGuessed));
            } else {
                System.out.println("Choose only characters available.\n\n");
                System.out.println("Available letters:\n"
                        + Arrays.toString(availableLetters.toArray()));
                System.out.println(new String(toBeGuessed));
                chances -= 1;
            }
        }

        if (chances != 0) {
            System.out.println("Guessed it right!");
            return toBeGuessed.length + (hints == 0 ? 10 : (hints == 1 ? 5 : 0));
        }
        System.out.println("Out of chances.\nThe answer is: "
                + word.getWord());
        return -1 * correctGuesses;
    }
}
