import Profiles.Player;
import Profiles.PlayerData;
import TournamentSystem.Game;

import javax.print.DocFlavor;
import java.util.Scanner;

public class GameApp {
    private final Scanner userInput = new Scanner(System.in);

    private PlayerData data = new PlayerData();
    public static void main(String[] args) {
        GameApp gameApp = new GameApp();
        gameApp.runGame();
    }



    public void runGame(){

        Game game = new Game();

        game.setPlayer1Score(0);
        game.setPlayer2Score(0);


        System.out.println("Welcome to PingPong");
//        System.out.println("Please select a game mode");
//        System.out.println("[1] PingPong to 11");
//        System.out.println("[2] PingPong to 21");
//        String gameMode = userInput.nextLine();
//
//
//        System.out.println("Enter number of matches: ");
//        String matchNumber = userInput.nextLine();
//        int numberOfMatches = Integer.parseInt(matchNumber);

        System.out.println("Who is Player 1?");
        String player1input = userInput.nextLine();
        //Player player1 = data.findPlayerByFirstName();
        //instead of doing this, i should loop through my list of players and find the player in my database
        Player player1 = new Player(player1input, null, null, null);
        game.setPlayer1(player1);
       /* Player player1 =

       i need to take the string and take it into a player
        eventually want this to turn into a txt file searcher
        game.setPlayer1(player1);
       */
                System.out.println("Who is Player 2?");
        String player2input = userInput.nextLine();


        Player player2 = new Player(player2input, null, null, null);
        game.setPlayer2(player2);

        game.isGameStillActive();


    }


}
