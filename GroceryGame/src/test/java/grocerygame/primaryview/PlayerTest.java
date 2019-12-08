/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.primaryview;

import grocerygame.primaryview.models.Player;
import com.sun.org.apache.xerces.internal.impl.dv.xs.DateTimeDV;
import java.sql.JDBCType;
import java.time.LocalDate;
import java.time.ZonedDateTime;
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
public class PlayerTest {

    private Player player;

    public PlayerTest() {
    }


    @Before
    public void setUp() {
        player = new Player("Pelaaja", 1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getPlayerName() {
        assertEquals("Pelaaja", player.getName());
    }

    @Test
    public void getPlayerLevel() {
        assertEquals(1, player.getDifficulty());
    }

    @Test
    public void getTime() {

        long erotus = ZonedDateTime.now().toEpochSecond() - player.getTime().toEpochSecond();
        boolean arvo = (erotus < 100);
        assertEquals(true, arvo);

    }

}
