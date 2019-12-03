/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game;

import grocerygame.game.models.Grocery;
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
public class GroceryTest {
    private Grocery grocery;
    
    public GroceryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        grocery = new Grocery("name","category");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void getCategoryWorks(){
        assertEquals("category",grocery.getCategory());
    }
    
    @Test
    public void getNameWorks(){
        assertEquals("name",grocery.getName());
    }

}
