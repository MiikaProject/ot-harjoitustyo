/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game;

import grocerygame.game.models.Cell;
import grocerygame.game.models.GameGrid;
import grocerygame.game.models.GroceryList;
import grocerygame.game.models.Location;
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
        gamegrid = new GameGrid(20, 20, grocerylist);
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void gridSizeIsRight(){
        assertEquals(20, gamegrid.grid.length);
    }
    
    @Test
    public void gridContainsCells(){
        assertEquals(new Cell().getClass(), gamegrid.grid[0][0].getClass());
    }
    
    @Test
    public void gridContainsShopper(){
        assertEquals(new Location().getClass(),gamegrid.getShopper().getClass());
    }
    
    @Test
    public void ShopperAtRightBottomCroner(){
        assertEquals(19,gamegrid.getShopper().getX());
        assertEquals(19,gamegrid.getShopper().getY());
    }
    
    @Test
    public void moveUpShopper(){
        gamegrid.moveUpShopper();
        assertEquals(18, gamegrid.getShopper().getY());
    }
    
    
    @Test
    public void moveDownShopper(){
        gamegrid.moveUpShopper();
        gamegrid.moveUpShopper();
        gamegrid.moveUpShopper();
        gamegrid.moveDownShopper();
        assertEquals(17, gamegrid.getShopper().getY());
    }
    
    
    @Test
    public void moveLeftShopper(){
        gamegrid.moveLeftShopper();
        assertEquals(18, gamegrid.getShopper().getX());
    }
    
    @Test
    public void moveRightShopper(){
        gamegrid.moveLeftShopper();
        gamegrid.moveLeftShopper();
        gamegrid.moveLeftShopper();;
        gamegrid.moveRightShopper();
        assertEquals(17, gamegrid.getShopper().getX());
    }
    
    @Test
    public void levelWroks(){
        gamegrid.levelOne();
        assertEquals("M",gamegrid.grid[0][5].getType());
    }
    
    
    
    
    
}
