/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.database;

import grocerygame.primaryview.models.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miika
 */
public class PlayerDaoTest {

    PlayerDao playerDao;

    public PlayerDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        playerDao = new PlayerDao(true);
    }

    @After
    public void tearDown() throws Exception {
        playerDao.ClearDatabase();
        
    }

    @Test
    public void getPlayersIsInitiallyEmpty() throws Exception {
        assertEquals(0, playerDao.getAll().size());
    }

    @Test
    public void addPlayerToDatabaseWorks() throws Exception {
        Player player = new Player("test", 1);
        playerDao.create(player);
        assertEquals(1, playerDao.getAll().size());

    }

    @Test
    public void cleaDataBaseWorks() throws Exception {
        Player player = new Player("test", 1);
        playerDao.create(player);
        playerDao.ClearDatabase();
        assertEquals(0, playerDao.getAll().size());
    }

}
