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







//    Player getPlayerById(int playerId);
//    List<Player> getPlayersByWins();
//    Player createPlayer();
//    Player updatePlayer();
//    int deletePlayerById(int playerId);


    private Player mapRowToPlayer (SqlRowSet rowSet){
        Player player = new Player();
        player.setFirstName(rowSet.getString("first_name"));
        player.setLastName(rowSet.getString("last_name"));
        player.setDescription(rowSet.getString("description"));
        player.setNickname(rowSet.getString("nickname"));
        return player;
    }

}
