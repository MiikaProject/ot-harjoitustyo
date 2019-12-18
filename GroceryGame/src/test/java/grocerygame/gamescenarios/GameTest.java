package grocerygame.gamescenarios;

import grocerygame.database.PlayerDao;
import grocerygame.game.models.GameGrid;
import grocerygame.game.models.Grocery;
import grocerygame.game.models.GroceryList;
import grocerygame.primaryview.models.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    GameGrid gamegrid;
    GroceryList grocerylist;
    Player player;
    PlayerDao playerDao;

    public GameTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        grocerylist = new GroceryList();
        player = new Player("player", 1);
        grocerylist.addToGrocerylist(new Grocery("Chocolate", "E"));
        grocerylist.addToGrocerylist(new Grocery("Chicken", "ME"));
        grocerylist.addToGrocerylist(new Grocery("Soap", "H"));
        gamegrid = new GameGrid(20, 20, grocerylist, player);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void goToCandyShelfAndPickUpChocolate() {
        for (int i = 0; i < 10; i++) {
            gamegrid.moveLeftShopper();
        }
        for (int i = 0; i < 4; i++) {
            gamegrid.moveUpShopper();
        }
        gamegrid.moveRightShopper();
        assertEquals(2, grocerylist.getGrocerylist().size());
        player.calculateFinalScore();
        assertEquals(50, player.getFinalScore());
    }

    @Test
    public void continueToMeatShelf() {
        for (int i = 0; i < 10; i++) gamegrid.moveLeftShopper();
        for (int i = 0; i < 4; i++) gamegrid.moveUpShopper();
        gamegrid.moveRightShopper();
        gamegrid.moveLeftShopper();
        for(int i = 0;i <5;i++) gamegrid.moveUpShopper();
        gamegrid.moveUpShopper();
        assertEquals(1, grocerylist.getGrocerylist().size());
        player.calculateFinalScore();
        assertEquals(100, player.getFinalScore());
    }
    
    
    @Test
    public void thenGoToHouseHold(){
        for (int i = 0; i < 10; i++) gamegrid.moveLeftShopper();
        for (int i = 0; i < 4; i++) gamegrid.moveUpShopper();
        gamegrid.moveRightShopper();
        gamegrid.moveLeftShopper();
        for(int i = 0;i <5;i++) gamegrid.moveUpShopper();
        gamegrid.moveUpShopper();
        for(int i = 0; i <8;i++) gamegrid.moveLeftShopper();
        assertEquals(0, grocerylist.getGrocerylist().size());
        player.calculateFinalScore();
        assertEquals(150, player.getFinalScore()); 
    }
    
    
    @Test
    public void andFinishByGoingToCashier(){
        for (int i = 0; i < 10; i++) gamegrid.moveLeftShopper();
        for (int i = 0; i < 4; i++) gamegrid.moveUpShopper();
        gamegrid.moveRightShopper();
        gamegrid.moveLeftShopper();
        for(int i = 0;i <5;i++) gamegrid.moveUpShopper();
        gamegrid.moveUpShopper();
        for(int i = 0; i <8;i++) gamegrid.moveLeftShopper();
        for(int i = 0; i<8;i++) gamegrid.moveDownShopper();
        player.spendTime(15000);
        player.calculateFinalScore();
        assertEquals(265, player.getFinalScore());
        assertEquals(true, gamegrid.gameover());
    }
    
    
    

}
