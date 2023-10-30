package Profiles;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcPlayerDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPlayerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getPlayerCount(){
        int playerCount = 0;
        String sql = "SELECT COUNT(*) AS count FROM player;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if (results.next()){
            playerCount = results.getInt("count");
        }

        return playerCount;
    }


     public List<String> getPlayerNames(){
        List<String> playerNames = new ArrayList<>();
        String sql = "SELECT first_name FROM player order by first_name asc;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            playerNames.add(results.getString("first_name"));
        }
        return playerNames;
     }
     public Player getPlayerByFirstName(String name){
        Player player = null;
        String sql = "SELECT * FROM player where first_name = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        if(results.next()){
            player = mapRowToPlayer(results);
        }
        return player;
     }

     public Player getPlayerById(int playerId){
        Player player = null;
        String sql = "SELECT * FROM player where player_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, playerId);
        if (results.next()){
            player = mapRowToPlayer(results);
        }
        return player;
     }

     public Player createPlayer(Player player){
        Player newPlayer;
        String sql = "insert into player (first_name, last_name, description, nickname) " +
                "values (?,?,?,?) returning id;";
        int playerId = jdbcTemplate.queryForObject(sql, int.class,
                player.getFirstName(),
                player.getLastName(),
                player.getDescription(),
                player.getNickname());
        newPlayer = getPlayerById(playerId);
        return newPlayer;
     }

//     public Player updatePlayer(Player player){
//        String sql = ""
//     }

//    Player updatePlayer();
//    int deletePlayerById(int playerId);


    private Player mapRowToPlayer (SqlRowSet rowSet){
        Player player = new Player();
        player.setPlayerId(rowSet.getInt("player_id"));
        player.setFirstName(rowSet.getString("first_name"));
        player.setLastName(rowSet.getString("last_name"));
        player.setDescription(rowSet.getString("description"));
        player.setNickname(rowSet.getString("nickname"));
        player.setPlayerWins(rowSet.getInt("player_wins"));//player wins int
        player.setPlayerLosses(rowSet.getInt("player_losses"));//player losses int
        player.setGamesPlayed(rowSet.getInt("games_played"));//games_played
        return player;
    }

}
