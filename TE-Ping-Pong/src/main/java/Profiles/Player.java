package Profiles;

public class Player {

    private int playerId;
    private String firstName;
    private String lastName;
    private String nickname;
    private String description;

    //stats fields
    private int playerWins;
    private int playerLosses;
    private int gamesPlayed;

    //constructor
    public Player(){

    }
    public Player(String firstName, String lastName, String nickname, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.description = description;
    }
    //getters and setters


    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public void setPlayerWins(int playerWins) {
        this.playerWins = playerWins;
    }

    public int getPlayerLosses() {
        return playerLosses;
    }

    public void setPlayerLosses(int playerLosses) {
        this.playerLosses = playerLosses;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }


}
