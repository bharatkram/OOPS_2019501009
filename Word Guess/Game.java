import java.util.ArrayList;
import java.util.Scanner;

public class Game extends WordsADT{

    public int guess(Word word) {
        String answer = word.getWord();
        char[] toBeGuessed = word.secretWord();
        Scanner guessed = new Scanner();
        int chances = toBeGuessed.length, correctGuesses = 0;

        while (word.getWord().equals(new String(toBeGuessed)) && chances != 0) {
            char guess = guessed.next().charAt(0);

            boolean flag = true;
            for (int i = 0; i < toBeGuessed.length; i++) {
                if (answer.charAt(i) == (guess)) {
                    flag = false;
                    correctGuesses += 1;
                    toBeGuessed[i] = guess;
                    break;
                }
            }
            if (flag) {
                chances -= 1;
            }
        }

        if (chances != 0 ) {
            return toBeGuessed.length;
        }
        return -1 * correctGuesses;
    }

    public void displayAvailableLetters(String usedLetters) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if ()
            System.out.println(ch);
        }
    }
}
