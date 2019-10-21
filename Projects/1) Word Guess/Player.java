public class Player implements Comparable<Player> {

    /**
     * the name of the player.
     */
    private String name;

    /**
     * the score and level of the word that the player chooses
     * to play for.
     */
    private int score, level;


    /**
     * constructor to initialise the name of the player.
     *
     * @param name input to fix the name of the player.
     */
    public Player(final String name) {
        this.name = name;
    }

    /**
     * constructor to initialise the fields of the player as given.
     *
     * @param name the name given by the player.
     * @param score the score of the player.
     * @param level the level of the word to be guessed.
     */
    public Player(final String name, final int score, final int level) {
        this.name = name;
        this.score = score;
        this.level = level;
    }

    /**
     * function to return the name of the player.
     *
     * @return the name of the player.
     */
    public String getName() {
        return this.name;
    }

    /**
     * function to fix the name of the player.
     *
     * @param name the name given by the player as input.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * fucntion to get the score of the player.
     *
     * @return the score of the player.
     */
    public int getScore() {
        return this.score;
    }

    /**
     * function to set the score of the player.
     *
     * @param score the score as returned by the game function.
     */
    public void setScore(final int score) {
        if (score <= 0) {
            this.score = -1 * score;
        } else {
            this.score = score + 25;
        }
    }

    /**
     * function to set the level of word to be guessed by the player.
     *
     * @return the level selected by the player.
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * function to set the level selected by the player.
     *
     * @param level the level selected by the player as per the input.
     */
    public void setLevel(final int level) {
        this.level = level;
    }

    /**
     * function to give the details of the player.
     *
     * @return the details of player in form of string.
     */
    @Override
    public String toString() {
        String lvl = "";
        if (getLevel() == 1) {
            lvl = "Easy";
        } else if (getLevel() == 2) {
            lvl = "Medium";
        } else {
            lvl = "Hard";
        }
        return "{"
            + " name='" + getName() + "'"
            + ", score='" + getScore() + "'"
            + ", level='" + lvl + "'"
            + "}";
    }

    /**
     * function to compare the players based on scores and level.
     *
     * @param that player variable to be compared to.
     * @return the compared value of scores and levels.
     */
    public int compareTo(final Player that) {
        if (this.getScore() == that.getScore()) {
            return Integer.compare(that.getScore(), this.getScore());
        }
        return Integer.compare(that.getScore(), this.getScore());
    }
}
