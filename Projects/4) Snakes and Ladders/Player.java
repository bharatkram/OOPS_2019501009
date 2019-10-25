public class Player implements Comparable<Player> {
    /**
     * the name of the player.
     */
    private String name;

    /**
     * the position of the player.
     */
    private int pos;

    /**
     * parameterised constructor which initialises the name as given
     * and the position of the player to zero.
     *
     * @param name the name passed by the player.
     */
    Player(final String name) {
        this.name = name;
        pos = 0;
    }

    /**
     * function to set the position of the player on the board.
     *
     * @param pos the position of the player to be updated.
     */
    public void setPos(final int pos) {
        this.pos = pos;
    }

    /**
     * function to get the position of the player on board.
     *
     * @return position of the player.
     */
    public int getPos() {
        return this.pos;
    }

    /**
     * function to get the name of the player.
     *
     * @return the name of player.
     */
    public String getName() {
        return this.name;
    }

    /**
     * function to add the count shown on die to the position
     * of the player.
     *
     * @param count the count shown on the die.
     */
    public void addDieCount(final int count) {
        if (this.pos + count <= 100) {
            this.pos += count;
        }
    }

    /**
     * compareTo method to compare the player's position and rank them
     * accordingly.
     *
     * @param that another player who the current player is being compared to.
     * @return the difference in position of the players.
     */
    public int compareTo(final Player that) {
        return this.pos - that.getPos();
    }

    /**
     * function to print the fields of the player.
     *
     * @return the fields of the class in string format.
     */
    public String toString() {
        return ("Name: " + this.name + "\tPosition: " + this.pos);
    }
}
