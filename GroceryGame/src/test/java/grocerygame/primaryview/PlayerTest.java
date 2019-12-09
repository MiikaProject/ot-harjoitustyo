/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.primaryview;

import grocerygame.primaryview.models.Player;
import java.time.ZonedDateTime;
import org.junit.After;
import org.junit.Before;
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


}
