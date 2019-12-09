/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game;

import grocerygame.game.models.Cell;
import grocerygame.game.models.GameGrid;
import grocerygame.game.models.Grocery;
import grocerygame.game.models.GroceryList;
import grocerygame.game.models.Location;
import grocerygame.primaryview.models.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miika1
 */
public class GameGridTest {

    private GroceryList grocerylist;
    private GameGrid gamegrid;

    public GameGridTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        grocerylist = new GroceryList(1);
        gamegrid = new GameGrid(20, 20, grocerylist, new Player("tester", 1));

    }

    @After
    public void tearDown() {
    }

    @Test
    public void gridSizeIsRight() {
        assertEquals(20, gamegrid.grid.length);
    }

    @Test
    public void gridContainsCells() {
        assertEquals(new Cell().getClass(), gamegrid.grid[0][0].getClass());
    }

    @Test
    public void gridContainsShopper() {
        assertEquals(new Location().getClass(), gamegrid.getShopper().getClass());
    }

    @Test
    public void ShopperAtRightBottomCroner() {
        assertEquals(19, gamegrid.getShopper().getX());
        assertEquals(19, gamegrid.getShopper().getY());
    }

    @Test
    public void moveUpShopper() {
        gamegrid.moveUpShopper();
        assertEquals(18, gamegrid.getShopper().getY());
    }
    
    
    @Test
    public void moveUpCantGoOverGrid(){
        gamegrid.clearLevel();
        int i = 0;
        while(i<30){
            gamegrid.moveUpShopper();
            i++;
        }
        assertEquals(0, gamegrid.getShopper().getY());
        
    }

    @Test
    public void moveDownShopper() {
        gamegrid.moveUpShopper();
        gamegrid.moveUpShopper();
        gamegrid.moveUpShopper();
        gamegrid.moveDownShopper();
        assertEquals(17, gamegrid.getShopper().getY());
    }
    
    @Test 
    public void moveDownShopperCantGoOverGrid(){
        gamegrid.moveDownShopper();
        assertEquals(19, gamegrid.getShopper().getY());
    }

    @Test
    public void moveLeftShopper() {
        gamegrid.moveLeftShopper();
        assertEquals(18, gamegrid.getShopper().getX());
    }

    @Test
    public void moveLeftCantGoOverGrid() {
        gamegrid.clearLevel();
        for(int i=0;i <50;i++){
            gamegrid.moveLeftShopper();
        }
        assertEquals(0, gamegrid.getShopper().getX());
        
    }

    @Test
    public void moveRightShopper() {
        gamegrid.moveLeftShopper();
        gamegrid.moveLeftShopper();
        gamegrid.moveLeftShopper();;
        gamegrid.moveRightShopper();
        assertEquals(17, gamegrid.getShopper().getX());
    }

    @Test
    public void moveRightCantGoOverGrid() {
        gamegrid.moveRightShopper();
        assertEquals(19, gamegrid.getShopper().getX());
    }

    @Test
    public void levelWorks() {
        gamegrid.levelOne();
        assertEquals("M", gamegrid.grid[0][5].getType());
    }
    
    
    @Test
    public void GroceryIsRemovedFromGroceryList(){
        grocerylist.addToGrocerylist(new Grocery("Test", "M"));
        gamegrid.getCell(18, 19).setCellType("M");
        gamegrid.moveUpShopper();
        assertEquals(3, grocerylist.getGrocerylist().size());
    }
    
    @Test
    public void GameOverInitsAsFalse(){
        assertEquals(false,gamegrid.gameover());
    }
    
    
    @Test
    public void EmptyGroceryListAtCashierEndsGame(){
        grocerylist.getGrocerylist().clear();
        gamegrid.getCell(18, 19).setCellType("C");
        gamegrid.moveUpShopper();
        assertEquals(true,gamegrid.gameover());
    }
    
    @Test
    public void FullGrocerListAtCashierWontEndGame(){
        gamegrid.getCell(18, 19).setCellType("C");
        gamegrid.moveUpShopper();
        assertEquals(false,gamegrid.gameover());
    }

}
