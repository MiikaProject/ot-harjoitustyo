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

public class PlayerDao {

    Dao<Player, Long> playerDao;

    public PlayerDao() {

        try {
            ConnectionSource connectionSource = new JdbcConnectionSource("jdbc:sqlite:grocerygame.db");
            playerDao = DaoManager.createDao(connectionSource, Player.class);
            if (!playerDao.isTableExists()) {
                TableUtils.createTable(connectionSource, Player.class);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PlayerDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void create(Player player) throws Exception {
        playerDao.create(player);
    }

    public List<Player> getAll() throws Exception {
        ArrayList<Player> players = (ArrayList) playerDao.queryForAll();
        return players;
    }

}
