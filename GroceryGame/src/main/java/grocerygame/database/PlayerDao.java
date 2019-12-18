package grocerygame.database;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import grocerygame.primaryview.models.Player;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * PlayerDao handles database operations with the Player model. It uses the
 * ORMLite ORM extension.
 *
 */
public class PlayerDao {

    Dao<Player, Long> playerDao;
    ConnectionSource connectionSource;
    boolean test;

    public PlayerDao() {

        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:grocerygame.db");
            playerDao = DaoManager.createDao(connectionSource, Player.class);
            if (!playerDao.isTableExists()) {
                TableUtils.createTable(connectionSource, Player.class);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PlayerDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public PlayerDao(boolean test) {
        if (test == true) {
            try {
                connectionSource = new JdbcConnectionSource("jdbc:sqlite:grocerygameTest.db");
                playerDao = DaoManager.createDao(connectionSource, Player.class);
                if (!playerDao.isTableExists()) {
                    TableUtils.createTable(connectionSource, Player.class);
                }

            } catch (SQLException ex) {
                Logger.getLogger(PlayerDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Adds Player to database
     *
     * @param player to be added to database
     * @throws Exception if database operation fails
     */
    public void create(Player player) throws Exception {
        playerDao.create(player);
    }

    /**
     * Gets all players from the database.
     *
     * @return returns list of players
     * @throws Exception if database operation fails.
     */
    public List<Player> getAll() throws Exception {
        ArrayList<Player> players = (ArrayList) playerDao.queryForAll();
        return players;
    }

    /**
     * Removes Players table
     */
    public void ClearDatabase() throws Exception {
        TableUtils.clearTable(connectionSource, Player.class);
    }
    
    

}
