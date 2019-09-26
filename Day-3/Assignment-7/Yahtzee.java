public final class Yahtzee {
    /**
     * Empty constructor.
    */
    private Yahtzee() {}

    /**
     * This method must return the outcome as if a die has been rolled.
     * @return the outcome when the die is rolled.
    */

    private int rollDice() {
        double output = Math.random();
        output *= 6;
        output += 1;
        return (int) output;
    }

    /**
     * This method must return the number of times it rolls the dice
     * to get the same number on all the dice.
    */

    public static void main(String[] args) {
        Yahtzee y = new Yahtzee();
        int die1 = y.rollDice();
        int die2 = y.rollDice();
        int die3 = y.rollDice();
        int die4 = y.rollDice();
        int die5 = y.rollDice();
        int count = 1;

        while(!(die1 == die2 && die2 == die3 && die3 == die4 && die4 == die5)) {
            die1 = y.rollDice();
            die2 = y.rollDice();
            die3 = y.rollDice();
            die4 = y.rollDice();
            die5 = y.rollDice();
            count += 1;
        }

        System.out.println(count);
    }
}