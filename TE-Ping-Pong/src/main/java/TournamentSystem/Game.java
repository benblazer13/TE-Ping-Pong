package TournamentSystem;

import Profiles.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private int player1Score;
    private int player2Score;
    private Player player1;
    private Player player2;
    private List<Player> pointTracker = new ArrayList();

    Scanner scanner = new Scanner(System.in);

    public Game(){

    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public void setPlayer2Score(int player2Score) {
        this.player2Score = player2Score;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void scorePoint(){
        System.out.println("Which Player scored:");
        System.out.println("1. " + getPlayer1().getFirstName());
        System.out.println("2. " + getPlayer2().getFirstName());

        String userInput = scanner.nextLine();

        if(userInput.equalsIgnoreCase("1")){
            //player1 goes up by 1; counter++
            player1Score ++;
            pointTracker.add(player1);
        } else if (userInput.equalsIgnoreCase("2")) {
            //player2 goes up by 2; counter++
            pointTracker.add(player2);
            player2Score++;
        }
    }

    public boolean isGameStillActive(){

        boolean isGameActive = true;
        while (isGameActive){

            if(getPlayer1Score() >= 21 & getPlayer1Score() > getPlayer2Score() + 1){
                System.out.println("The victor is: " + getPlayer1().getFirstName() + "!");
                System.out.println();

                isGameActive = false;
            } else if (getPlayer2Score() >= 21 & getPlayer2Score() > getPlayer1Score() + 1) {
                System.out.println("The victor is: " + getPlayer2().getFirstName() + "!");
                System.out.println();

                isGameActive = false;
            }else {
                scorePoint();
            }
            System.out.println(getPlayer1().getFirstName() + ") " + getPlayer1Score());
            System.out.println(getPlayer2().getFirstName() + ") " + getPlayer2Score());
        }
        return false;

    }

}
