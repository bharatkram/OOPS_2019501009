import java.util.Scanner;
import java.io.File;

public class WordsADT {

    /**
     * arrays to store the words and their attributes as given
     * in the text file.
     */
    private Word[] hardWords, mediumWords, easyWords;

    /**
     * the word selected at random to be guessed by the player.
     */
    private Word selectedWord;

    /**
     * the number of elements that are stored in the arrays.
     */
    private int hSize, mSize, eSize;

    /**
     * the array of the contents in the text file.
     */
    private String[] wordsList;

    /**
     * the number of elements present in the array.
     */
    private int wlSize;

    WordsADT() {
        hardWords = new Word[20];
        mediumWords = new Word[20];
        easyWords = new Word[20];
        hSize = 0;
        mSize = 0;
        eSize = 0;
        wordsList = new String[110];
        wlSize = 0;
    }
    /**
     * function to read the text file containing the words and their details.
     * the file to be read from is fixed.
     */
    public void readTxt() {
        try {
            Scanner scan = new Scanner(new File("movies.txt"));
            // StringBuffer sb = new StringBuffer();
            while (scan.hasNextLine()) {
                wordsList[wlSize++] = scan.nextLine();
                // sb.append(scan.nextLine() + ";");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * helper function to get the length of the file.
     *
     * @return length of file.
     */
    public int getCount() {
        return wordsList.length / 5;
    }

    /**
     * function to store the words in the respective arrays.
     * words are segregated into arrays depending on the level of
     * difficulty.
     */
    public void fixWords() {

        String word;
        int diffLevel;

        // iteration to get line by line values.
        // first line is the word,
        // second line is the difficulty level,
        // third and fourth lines are hints,
        // fifth line is empty.
        for (int i = 0; i < getCount() * 5; i = i + 5) {
            String[] hints = new String[2];
            if (wordsList[i + 2].equals("Hard")) {
                word = wordsList[i + 1].toLowerCase();
                diffLevel = 3;
                hints[0] = wordsList[i + 3];
                hints[1] = wordsList[i + 4];
                 // initialising the word object by calling the constructor.
                hardWords[hSize++] = new Word(word, hints, diffLevel);
            } else if (wordsList[i + 2].equals("Medium")) {
                word = wordsList[i + 1].toLowerCase();
                diffLevel = 2;
                hints[0] = wordsList[i + 3];
                hints[1] = wordsList[i + 4];
                // initialising the word object by calling the constructor.
                mediumWords[mSize++] = new Word(word, hints, diffLevel);
            } else if (wordsList[i + 2].equals("Easy")) {
                word = wordsList[i + 1].toLowerCase();
                diffLevel = 1;
                hints[0] = wordsList[i + 3];
                hints[1] = wordsList[i + 4];
                // initialising the word object by calling the constructor.
                easyWords[eSize++] = new Word(word, hints, diffLevel);
            }
        }
    }

    /**
     * Helper function.
     * function to remove the word that has already been played
     * by a player in the game.
     *
     * @param words the array of words from which a word is to be removed.
     * @param pos the position of the word to be removed.
     * @param lvl the level of the word.
     * @return the array itself after removing the required word.
     */
    public Word[] remWord(final Word[] words, final int pos, final int lvl) {
        for (int i = pos; i < words.length; i++) {
            if (words[i] == null) {
                break;
            }
            words[i] = words[i + 1];
        }
        if (lvl == 1) {
            eSize--;
        } else if (lvl == 2) {
            mSize--;
        } else {
            hSize--;
        }
        return words;
    }

    /**
     * function to select a word from the list of words based on
     * the choice of the player. the word from the respective arrays is
     * picked based on the input of the player.
     *
     * @param level the level of the word that the player chooses.
     * @return word that is picked randomly.
     */
    public Word getWordRandomly(final int level) {
        int lvl = level;
        Word out;

        // condition to choose a difficulty at random.
        // loop to change level if there are no words in the choosen level.
        while (lvl == 4) {
            double temp = Math.random();
            if (temp <= 0.33) {
                lvl = 1;
                if (eSize != 0) {
                    break;
                }
            } else if (temp <= 0.67) {
                lvl = 2;
                if (mSize != 0) {
                    break;
                }
            } else {
                lvl = 3;
                if (hSize != 0) {
                    break;
                }
            }
        }

        // condition to return a word based on choice of the player.
        // or null if no words are left in the level chosen.
        if (lvl == 1 && eSize != 0) {
            double temp = (Math.random() * eSize);
            out = easyWords[(int) temp];
            easyWords = remWord(easyWords, (int) temp, 1);
            return out;
        } else if (lvl == 2 && mSize != 0) {
            double temp = (Math.random() * mSize);
            out = mediumWords[(int) temp];
            mediumWords = remWord(mediumWords, (int) temp, 2);
            return out;
        } else if (hSize != 0) {
            double temp = (Math.random() * hSize);
            out = hardWords[(int) temp];
            hardWords = remWord(hardWords, (int) temp, 3);
            return out;
        }
        return null;
    }
}
