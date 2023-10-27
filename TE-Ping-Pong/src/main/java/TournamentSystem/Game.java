package TournamentSystem;

import Profiles.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private int player1Score;
    private int player2Score;
    private int player1MatchesWon;
    private int player2MatchesWon;

    private Player player1;
    private Player player2;
    private List<Player> pointTracker = new ArrayList();
    private List<Player> gameTracker = new ArrayList();
    private int gameEnd = 0;
    private boolean isServing = true;
    private int serveCounter = 0;


    public Game() {

    }

    public Game(int gameEnd) {
        this.gameEnd = gameEnd;
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

    public int getPlayer1MatchesWon() {
        return player1MatchesWon;
    }

    public int getPlayer2MatchesWon() {
        return player2MatchesWon;
    }

    public Player getPlayerServing() {
        if (isServing) {
            return getPlayer1();
        } else {
            return getPlayer2();
        }
    }

    public List<Player> getPointTracker() {
        return pointTracker;
    }

    public List<Player> getGameTracker() {
        return gameTracker;
    }

    public void toggleServe() {
        isServing = !isServing;
    }

    public void scorePoint(String whoScored) {

        if (whoScored.equalsIgnoreCase("1")) {
            //player1 goes up by 1; counter++
            player1Score++;
            pointTracker.add(player1);
        } else if (whoScored.equalsIgnoreCase("2")) {
            //player2 goes up by 2; counter++
            pointTracker.add(player2);
            player2Score++;
        } else {
            throw new IllegalArgumentException();
        }

        serveCounter++;
        if (serveCounter == getGameServes()) {
            toggleServe();
            serveCounter = 0;
        }


    }

    private int getGameServes() {
        if (gameEnd == 11) {
            return 2;
        } else {
            return 5;
        }
    }

    public boolean isGameStillActive() {
        //make constants for game type variables
        boolean isGameActive = true;


        if (getPlayer1Score() >= gameEnd & getPlayer1Score() > getPlayer2Score() + 1) {

            isGameActive = false;
        } else if (getPlayer2Score() >= gameEnd & getPlayer2Score() > getPlayer1Score() + 1) {

            isGameActive = false;
        }
        return isGameActive;
    }


    public Player getWinner() {

        if (getPlayer1Score() > getPlayer2Score()) {
            return player1;
        } else {
            return player2;
        }

    }

    public int matchSelection(int selection) {

        if (selection % 2 == 1) {
            return (selection / 2) + 1;
        } else {
            throw new IllegalArgumentException();
        }
    }


    public boolean isMatchActive(int numberOfWinsNeeded) {
        boolean isMatchActive = true;
        if (player1MatchesWon == numberOfWinsNeeded) {
            isMatchActive = false;
        } else if (player2MatchesWon == numberOfWinsNeeded) {
            isMatchActive = false;
        }
        return isMatchActive;
    }

    public Player getMatchWinner() {

        if (getPlayer1MatchesWon() > getPlayer2MatchesWon()) {
            return player1;
        } else {
            return player2;
        }
    }

    public void scoreGame(String whoWon) {

        if (whoWon.equalsIgnoreCase(getPlayer1().getFirstName())) {
            //player1 goes up by 1; counter++
            player1MatchesWon++;
            gameTracker.add(player1);
        } else if (whoWon.equalsIgnoreCase(getPlayer2().getFirstName())) {
            //player2 goes up by 2; counter++
            gameTracker.add(player2);
            player2MatchesWon++;
        } else {
            throw new IllegalArgumentException();
        }
    }


}
