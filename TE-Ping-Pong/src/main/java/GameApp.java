import Profiles.Player;
import TournamentSystem.Game;

import java.util.Scanner;

public class GameApp {
    private final Scanner userInput = new Scanner(System.in);

    Game game = new Game();

    public static void main(String[] args) {
        GameApp gameApp = new GameApp();
        gameApp.runGame();
    }

    public void runGame(){

        System.out.println("Welcome to PingPong");

        System.out.println("Who is Player 1?");
        String player1input = userInput.nextLine();
        //Player player1 = data.findPlayerByFirstName();
        //instead of doing this, i should loop through my list of players and find the player in my database
        Player player1 = new Player(player1input, null, null, null);
        game.setPlayer1(player1);

        System.out.println("Who is Player 2?"); // hello
        String player2input = userInput.nextLine();
        Player player2 = new Player(player2input, null, null, null);
        game.setPlayer2(player2);

        System.out.println("Please select a game mode");
        System.out.println("[1] PingPong to 11");
        System.out.println("[2] PingPong to 21");
        String gameMode = userInput.nextLine();
        int gameEnd = getGameEnd(gameMode);


        int numberOfWinsNeeded = 0;
        //gameMode input
        while(true) {
        System.out.println("Select Number of Matches: ");
//        System.out.println("[1] Single Match");
//        System.out.println("[2] Best of 3 Games");
//        System.out.println("[1] Best of 5 Games");
        String matchNumber = userInput.nextLine();
        int numberOfMatches = Integer.parseInt(matchNumber);

            try {
                numberOfWinsNeeded = game.matchSelection(numberOfMatches);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Please Select an Odd Number!");
            }
        }




        while (game.isMatchActive(numberOfWinsNeeded)) {
            game.setPlayer1Score(0);
            game.setPlayer2Score(0);

            while (game.isGameStillActive(gameEnd)) {
                scorePoint();
                System.out.println("----------------------------");
                System.out.println(game.getPlayer1().getFirstName() + ") " + game.getPlayer1Score());
                System.out.println(game.getPlayer2().getFirstName() + ") " + game.getPlayer2Score());
                System.out.println("----------------------------");
            }
            System.out.println("The victor is: " + game.getWinner().getFirstName() + "!");
            System.out.println();
            scoreGame(game.getWinner().getFirstName());
            System.out.println("----------------------------");
            System.out.println(game.getPlayer1().getFirstName() + ") " + game.getPlayer1MatchesWon());
            System.out.println(game.getPlayer2().getFirstName() + ") " + game.getPlayer2MatchesWon());
            System.out.println("----------------------------");

        }
        //while loop, call scorePoint within loop
        System.out.println("The victor is: " + game.getMatchWinner().getFirstName() + "!");
        System.out.println();
        //game.getWinner

    }

    public void scorePoint(){
        while(true) {
            System.out.println("Which Player scored:");
            System.out.println("1. " + game.getPlayer1().getFirstName());
            System.out.println("2. " + game.getPlayer2().getFirstName());

            String whoScored = userInput.nextLine();

            try {
                game.scorePoint(whoScored);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Input");
                System.out.println("Try again:");
            }
        }
    }

    public int getGameEnd(String gameMode){
        int gameEnd = 0;
        while(true) {
            try {
                if(gameMode.equals("1")){
                    gameEnd = 11;
                    break;
                } else if (gameMode.equals("2")) {
                    gameEnd = 21;
                    break;
                }else{
                    System.out.println("Invalid Selection..");
                    System.out.println("Try Again");
                }
            } catch (NumberFormatException e) {
                System.out.println("Something went wrong, try again");
            }
        }
        return gameEnd;
    }

    public void scoreGame(String whoWon){
        while(true) {
//            System.out.println("Which Player scored:");
//            System.out.println("1. " + game.getPlayer1().getFirstName());
//            System.out.println("2. " + game.getPlayer2().getFirstName());
//              String whoWon = userInput.nextLine();

            try {
                game.scoreGame(whoWon);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Input");
                System.out.println("Try again:");
            }
        }
    }

}
