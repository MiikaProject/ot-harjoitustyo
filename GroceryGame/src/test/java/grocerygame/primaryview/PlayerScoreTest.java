/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.primaryview;

import grocerygame.primaryview.models.Player;
import java.util.ArrayList;
import java.util.Collections;
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
public class PlayerScoreTest {

    private Player player;

    public PlayerScoreTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        player = new Player("tester", 1);
    }

    @Test
    public void scoreStartsAtZero() {
        player.calculateFinalScore();
        assertEquals(0, player.getFinalScore());
    }

    @Test
    public void scoreIsRightWhenCollectingItems() {
        for (int i = 1; i < 10; i++) {
            player.addItemToScore();
            player.calculateFinalScore();
            assertEquals(i * 50, player.getFinalScore());
        }
    }

    @Test
    public void addingCashierAddsScore() {
        player.addCashier();
        player.calculateFinalScore();
        assertEquals(100, player.getFinalScore());
    }

    @Test
    public void timeCompletedAddsScore() {
        player.spendTime(10000);
        player.calculateFinalScore();
        assertEquals(20, player.getFinalScore());
    }

    @Test
    public void timeSpentDifferentLevelsWorks() {
        player.spendTime(10000);
        for (int i = 1; i < 3; i++) {
            player.getScore().setDifficulty(i);
            player.calculateFinalScore();
            assertEquals((20 * i), player.getFinalScore());

        }
    }

    @Test
    public void scoreWhen10secondsThreeItemsAndCashier() {
        player.spendTime(10000);
        player.addCashier();
        player.addItemToScore();
        player.addItemToScore();
        player.addItemToScore();
        player.calculateFinalScore();
        assertEquals(270, player.getFinalScore());

    }

    @Test
    public void compareToSortPlayersByScore() {
        Player opponent = new Player("opponent1", 1);
        opponent.addCashier();
        opponent.addItemToScore();
        Player opponent2 = new Player("opponent2", 2);
        opponent2.calculateFinalScore();
        Player opponent3 = new Player("opponent3", 1);
        opponent3.addItemToScore();
        player.addItemToScore();
        opponent.calculateFinalScore(); //150
        opponent2.calculateFinalScore(); //0
        opponent3.calculateFinalScore(); //50
        player.calculateFinalScore(); //50
        ArrayList<Player> players = new ArrayList();
        players.add(player);
        players.add(opponent);
        players.add(opponent2);
        players.add(opponent3);
        Collections.sort(players);
        ArrayList<String> rightOrder = new ArrayList();
        rightOrder.add("opponent1");
        rightOrder.add("tester");
        rightOrder.add("opponent3");
        rightOrder.add("opponent2");

        for (int i = 0; i < rightOrder.size(); i++) {
            assertEquals(rightOrder.get(i), players.get(i).getName());
        }

        assertEquals(1, player.compareTo(opponent));
    }

}
