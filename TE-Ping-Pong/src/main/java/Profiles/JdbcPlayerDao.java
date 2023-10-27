package Profiles;

public class JdbcPlayerDao {

   // private final JdbcTemplate

    int getPlayerCount(){
        int playerCount = 0;
        String sql = "SELECT COUNT(*) AS count FROM player;";


        return playerCount;
    }





//    List<String> getPlayerNames();
//    Player getPlayer();
//    Player getPlayerById(int playerId);
//    List<Player> getPlayersByWins();
//    Player createPlayer();
//    Player updatePlayer();
//    int deletePlayerById(int playerId);


}
