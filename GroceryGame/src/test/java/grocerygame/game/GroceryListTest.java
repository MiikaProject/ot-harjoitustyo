/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game;

import grocerygame.game.models.Grocery;
import grocerygame.game.models.GroceryList;
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
public class GroceryListTest {
    private GroceryList groceries;
    
    public GroceryListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        groceries = new GroceryList();
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void emptyConstuctorWorks(){
        assertEquals(0,groceries.getGrocerylist().size());
    }
    
    @Test
    public void groceryDatabaseInits(){
        assertEquals(10,groceries.getGroceryDatabase().size());
    }
    
    @Test
    public void levelOneConstuctorWorks(){
        groceries = new GroceryList(1);
        assertEquals(3,groceries.getGrocerylist().size());
    }
    
    @Test
    public void levelTwoConstuctorWorks(){
        groceries = new GroceryList(2);
        assertEquals(5,groceries.getGrocerylist().size());
    }
    
    @Test
    public void levelThreeConstuctorWorks(){
        groceries = new GroceryList(3);
        assertEquals(7,groceries.getGrocerylist().size());
    }
    
    @Test
    public void randomGrocery(){
        assertEquals(new Grocery("name","category").getClass(),groceries.randomGrocery().getClass() );
        
        
    }
    
    
}
