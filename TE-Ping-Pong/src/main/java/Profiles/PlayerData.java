package Profiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerData {

    public List<Player> allPlayers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public PlayerData() {
        Player ben = new Player("Ben", "Hoffman", "", "");
        Player sam = new Player("Sam", "Somerdin", "", "");
        Player adi = new Player("Aditya", "?", "", "");

        allPlayers.add(ben);
        allPlayers.add(sam);
        allPlayers.add(adi);
    }

    public Player findPlayerByFirstName() {
        Player player = null;

        System.out.println("Who would you like to find? (Search by first name) ");
        String input = scanner.nextLine();

        //search through list for player by first name

        for (Player currPlayer : allPlayers){
            if(currPlayer.getFirstName() == input){}
            player =  currPlayer;
        }


        return player;
    }

}
