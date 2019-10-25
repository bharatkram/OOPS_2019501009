import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
            }
            catch(NullInputException nie) {
                System.out.println(nie.getMessage());
            }
            catch(NumberFormatException nfe) {
                System.out.println("Enter only numbers:");
            }
        }
        
        scan.close();
    }
}