import java.util.*;

/**
 * the main class that runs the whole package.
 */
public class Main {

    /**
     * the main function to run the whole program.
     * @param args the parameters of the main function.
     */
    public static void main(final String[] args) {
        //the instance of the class game.
        Game game = new Game();
        // game.readTxt();
        // game.fixWords();

        //start of the game.
        System.out.println("Enter the number of players.");
        Scanner scan = new Scanner(System.in);
        int numberOfPlayers = 0;

        while (true) {
            try {
                numberOfPlayers = Integer.parseInt(scan.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number:");
            }
        }
        Player[] players = new Player[numberOfPlayers];

        //the loop to run the game for times equal to number
        //of players.
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = "";
            System.out.print("Enter name of player " + (i + 1) + ": ");
            while (true) {
                try {
                    name = scan.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Please enter something:");
                }
            }
            players[i] = new Player(name);

            //allowing the user to choose the level of his/her choice.
            System.out.println("Enter the level of word to be guessed:"
                    + "\n1.Easy\n2.Medium\n3.Hard\n4.Random");
            while (true) {
                try {
                    int temp;
                    temp = Integer.parseInt(scan.nextLine());
                    players[i].setLevel(temp);
                    if (temp >= 1 && temp <= 4){   
                        break;
                    }
                    System.out.println("Enter a number between 1 and 4");
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number:");
                }
            }
            // players[i].setScore((int)(Math.random() * 10));
            players[i].setScore(game.guess(players[i].getLevel()));
        }

        //statement to sort the leader board in descending order of
        //the scores of the players.
        Arrays.sort(players);
        //loop to display the leader board.
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println(players[i].toString());
        }
    }
}
