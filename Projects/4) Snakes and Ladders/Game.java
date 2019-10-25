import java.util.ArrayList;
import java.util.Scanner;

/**
 * the game class.
 */
public class Game {

    /**
     * array list of players.
     */
    private ArrayList<Player> players;

    /**
     * parameterised constructor.
     *
     * @param number the number of players.
     */
    Game(final int number) {
        players = new ArrayList<Player>(number);
    }

    /**
     * function to add a new player.
     *
     * @param name the name of the player.
     */
    public void add(final String name) {
        players.add(new Player(name));
    }

    /**
     * function to roll a die.
     *
     * @return the number shown on the die.
     */
    public int rollADice() {
        return (int) (Math.random() * 6) + 1;
    }

    /**
     * function to check if the player has gone down a snake.
     *
     * @param player the player who is currently playing.
     */
    public void snakes(final Player player) {
        switch (player.getPos()) {
            case 43 :   player.setPos(16);
                        System.out.println("Whoa! you slipped down a snake.");
                        System.out.println("New Position: " + player.getPos());
                        break;
            case 55 :   player.setPos(34);
                        System.out.println("Whoa! you slipped down a snake.");
                        System.out.println("New Position: " + player.getPos());
                        break;
            case 70 :   player.setPos(48);
                        System.out.println("Whoa! you slipped down a snake.");
                        System.out.println("New Position: " + player.getPos());
                        break;
            case 78 :   player.setPos(42);
                        System.out.println("Whoa! you slipped down a snake.");
                        System.out.println("New Position: " + player.getPos());
                        break;
            case 95 :   player.setPos(73);
                        System.out.println("Whoa! you slipped down a snake.");
                        System.out.println("New Position: " + player.getPos());
                        break;
            case 96 :   player.setPos(82);
                        System.out.println("Whoa! you slipped down a snake.");
                        break;
            default :   break;
        }
    }

    /**
     * function to check if the player has climbed a ladder.
     *
     * @param player the player who is currently playing.
     */
    public void ladder(final Player player) {
        switch (player.getPos()) {
            case 6 :    player.setPos(27);
                        System.out.println("Yay! You climbed up a ladder.");
                        System.out.println("New Position: " + player.getPos());
                        break;
            case 9 :    player.setPos(50);
                        System.out.println("Yay! You climbed up a ladder.");
                        System.out.println("New Position: " + player.getPos());
                        break;
            case 20 :   player.setPos(39);
                        System.out.println("Yay! You climbed up a ladder.");
                        System.out.println("New Position: " + player.getPos());
                        break;
            case 25 :   player.setPos(57);
                        System.out.println("Yay! You climbed up a ladder.");
                        System.out.println("New Position: " + player.getPos());
                        break;
            case 53 :   player.setPos(72);
                        System.out.println("Yay! You climbed up a ladder.");
                        System.out.println("New Position: " + player.getPos());
                        break;
            case 54 :   player.setPos(85);
                        System.out.println("Yay! You climbed up a ladder.");
                        break;
            case 61 :   player.setPos(82);
                        System.out.println("Yay! You climbed up a ladder.");
                        break;
            default :   break;
        }
    }

    /**
     * function to return the position of the closest snake on the board.
     *
     * @param player the player whose is currently playing.
     */
    public void nextSnake(final Player player) {
        if (player.getPos() < 43) {
            System.out.println("Next snake is in block: 43");
        } else if (player.getPos() < 55) {
            System.out.println("Next snake is in block: 55");
        } else if (player.getPos() < 70) {
            System.out.println("Next snake is in block: 70");
        } else if (player.getPos() < 78) {
            System.out.println("Next snake is in block: 78");
        } else if (player.getPos() < 96) {
            System.out.println("Next snakes are in blocks: 95,96");
        } else {
            System.out.println("You crossed all snakes. No more left.");
        }
    }

    /**
     * function to return the position of the closest snake on the board.
     *
     * @param player the player whose is currently playing.
     */
    public void nextLadder(final Player player) {
        if (player.getPos() < 6) {
            System.out.println("Next ladder is in block: 6");
        } else if (player.getPos() < 9) {
            System.out.println("Next ladder is in block: 9");
        } else if (player.getPos() < 20) {
            System.out.println("Next ladder is in block: 20");
        } else if (player.getPos() < 25) {
            System.out.println("Next ladder is in block: 25");
        } else if (player.getPos() < 53) {
            System.out.println("Next ladders are in blocks: 53,54");
        } else if (player.getPos() < 61) {
            System.out.println("Next ladder is in block: 61");
        } else {
            System.out.println("You crossed all ladders. No more left.");
        }
    }

    /**
     * to increment the player who is playing.
     *
     * @param playerNumber the serial number of the player.
     * @param totalNumber the total number of players.
     * @return the serial number of player after incrementation.
     */
    public int increment(final int playerNumber, final int totalNumber) {
        if (playerNumber == totalNumber - 1) {
            return 0;
        }
        return playerNumber + 1;
    }

    /**
     * function to run the game.
     *
     * @param numberOfPlayers the total number of players.
     * @return the array list of players.
     */
    public ArrayList<Player> play(final int numberOfPlayers) {
        Scanner scan = new Scanner(System.in);
        int move;

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter name of player-" + (i + 1));
            try {
                String name = scan.nextLine();
                if (name.equals("")) {
                    throw new NullInputException("Enter a name");
                }
                players.add(new Player(name));
            } catch (NullInputException nie) {
                System.out.println(nie.getMessage());
            }
        }

        int i = 0;
        String ch;

        while (true) {
            System.out.println(players.get(i).getName() + "'s turn"
                    + "\nPress 'r' to roll dice or '.' to know "
                    + "everyone's position:");
            while (true) {
                try {
                    ch = scan.nextLine();
                    if (ch.equals("")) {
                        throw new NullInputException("Enter 'r' or '.' "
                                + "to proceed:");
                    } else if (!(ch.equals("r") || ch.equals("."))) {
                        throw new IncorrectInputException("Enter only 'r' "
                                + "or '.':");
                    } else if (ch.equals(".")) {
                        for (int j = 0; j < numberOfPlayers; j++) {
                            System.out.println(players.get(j).getName() + " : "
                                    + players.get(j).getPos());
                        }
                        System.out.println("Enter 'r' to play:");
                    } else {
                        break;
                    }
                } catch (NullInputException nie) {
                    System.out.println(nie.getMessage());
                } catch (IncorrectInputException iie) {
                    System.out.println(iie.getMessage());
                }
            }
            move = rollADice();
            players.get(i).addDieCount(move);
            System.out.println("\n\nDie count = " + move);
            System.out.print("New Position: " + players.get(i).getPos()
                    + "\n");
            snakes(players.get(i));
            ladder(players.get(i));
            nextSnake(players.get(i));
            nextLadder(players.get(i));

            if (players.get(i).getPos() == 100) {
                break;
            }
            if (move != 6) {
                i = increment(i, numberOfPlayers);
            } else {
                System.out.println("Play again.");
            }
        }
        return players;
    }
}
