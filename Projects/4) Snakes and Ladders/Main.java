import java.util.Scanner;
import java.util.ArrayList;

class Main {

    /**
     * the main function.
     *
     * @param args parameters of the main function.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String numberOfPlayers;
        Game game;

        System.out.println("Enter the number of players:");
        while (true) {
            try {
                numberOfPlayers = scan.nextLine();
                if (numberOfPlayers.equals("")) {
                    throw new NullInputException("Enter a number:");
                }
                game = new Game(Integer.parseInt(numberOfPlayers));
                break;
            } catch (NullInputException nie) {
                System.out.println(nie.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.println("Enter only numbers:");
            }
        }

        ArrayList<Player> players = game.play(
                    Integer.parseInt(numberOfPlayers));

        players.forEach((player) -> System.out.println(player));

        scan.close();
    }
}
