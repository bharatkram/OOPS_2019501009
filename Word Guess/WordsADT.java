import java.util.Scanner;
import java.io.File;

public class WordsADT {

    private Word[] hardWords = new Word[20], mediumWords = new Word[20],
                        easyWords = new Word[20];
    private Word selectedWord;
    private int hSize = 0, mSize = 0, eSize = 0;
    private String[] wordsList;
    private int wlSize = 0;

    /**
     * function to read the text file containing the words and their details.
     * the file to be read from is fixed.
     */
    public void readTxt() {
        try {
            Scanner scan = new Scanner(new File("movies.txt"));
            // StringBuffer sb = new StringBuffer();
            while (scan.hasNext()) {
                wordsList[wlSize++] = scan.nextLine();
                // sb.append(scan.nextLine() + ";");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getCount() {
        return wordsList.length/5;
    }

    /**
     * function to store the words in the respective arrays.
     * words are segregated into arrays depending on the level of
     * difficulty.
     */
    public void fixWords() {
        
        String word;
        String[] hints = new String[2];
        int diffLevel;

        // iteration to get line by line values.
        // first line is the word,
        // second line is the difficulty level,
        // third and fourth lines are hints,
        // fifth line is empty.
        for(int i = 0; i < getCount() * 5; i = i + 5) {
            if(wordsList[i + 1].equals("Hard")) {
                word = wordsList[i];
                diffLevel = 3;
                hints[0] = wordsList[i + 2];
                hints[1] = wordsList[i + 3];
                 // initialising the word object by calling the constructor.
                hardWords[hSize++] = new Word(word, hints, diffLevel);
            } else if (wordsList[i + 1].equals("Medium")) {
                word = wordsList[i];
                diffLevel = 2;
                hints[0] = wordsList[i + 2];
                hints[1] = wordsList[i + 3];
                // initialising the word object by calling the constructor.
                mediumWords[mSize++] = new Word(word, hints, diffLevel);
            } else if (wordsList[i + 1].equals("Easy")) {
                word = wordsList[i];
                diffLevel = 1;
                hints[0] = wordsList[i + 2];
                hints[1] = wordsList[i + 3];
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
    public Word[] remWord(Word[] words, int pos, int lvl) {
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
     * picked based on the input of the user.
     *
     * @param level the level of the word that the player chooses.
     * @return word that is picked randomly.
     */
    public Word getWord(final int level) {
        int lvl = level;
        Word out;

        // condition to choose a difficulty at random.
        // loop to change level if there are no words in the choosen level.
        while (level == 4) {
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
