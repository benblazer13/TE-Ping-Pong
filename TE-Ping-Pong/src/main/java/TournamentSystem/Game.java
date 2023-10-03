package TournamentSystem;

import Profiles.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private int score;
    private Player player1;
    private Player player2;
    private List<Player> pointTracker = new ArrayList();

    Scanner scanner = new Scanner(System.in);

    public Game(int score, Player player1, Player player2) {
        this.score = score;
        this.player1 = player1;
        this.player2 = player2;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
        System.out.println("1. " + getPlayer1());
        System.out.println("2. " + getPlayer2());

        String userInput = scanner.nextLine();


        if(userInput.equalsIgnoreCase("1")){
            //player1 goes up by 1; counter++
            pointTracker.add(player1);
        } else if (userInput.equalsIgnoreCase("2")) {
            //player2 goes up by 2; counter++
            pointTracker.add(player2);
        }
    }


}
