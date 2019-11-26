/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game;

import grocerygame.game.models.Shopper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miika
 */
public class ShopperTest {
    private Shopper shopper;
    
    public ShopperTest() {
    }
    
    
    
    
    @Before
    public void setUp() {
        shopper = new Shopper();
        
    }
    
    @After
    public void tearDown() {
    }
    
    
    
    @Test
    public void moveDownWorks(){
        
        shopper.moveDown();
        shopper.moveDown();
        int y = shopper.getYCoordinate();
        assertEquals(10, y);
    }
    
    
    @Test
    public void moveUpWorks(){
        shopper.setLocation(0, 10);
        shopper.moveUp();
        assertEquals(5, shopper.getYCoordinate());
    }
    
    
    
    @Test
    public void cantMoveUpOverGrid(){
        
        shopper.setLocation(0, 0);
        shopper.moveUp();
        assertEquals(0, shopper.getYCoordinate());
    }
    
    
    @Test
    public void CantMoveOverGrid(){
        shopper.moveUp();
        shopper.moveUp();
        int y = shopper.getYCoordinate();
        assertEquals(0, y);
    }
    
    
    
    
    @Test
    public void setLocationWorks(){
        shopper.setLocation(50, 50);
        int y = shopper.getYCoordinate();
        int x = shopper.getXCoordinate();
        assertEquals(50, x);
        assertEquals(50, y);
        
    }
    
    
    
    @Test
    public void getLocation(){
        int x = (int) shopper.getXCoordinate();
        int y = (int) shopper.getYCoordinate();
        assertEquals(0, x);
        assertEquals(0, y);
    }
    
    
    @Test 
    public void setLimitsWorks(){
        shopper.setLimits(50, 50);
        shopper.setLocation(50, 50);
        shopper.moveDown();
        assertEquals(50, shopper.getYCoordinate());
    }
    
    
    @Test
    public void moveRightWorks(){
        shopper.moveRight();
        int x = shopper.getXCoordinate();
        assertEquals(5, x);
    }
    
    
    @Test
    public void moveRightWontGoOverScreen(){
        shopper.setLimits(10, 10);
        shopper.setLocation(10, 0);
        shopper.moveRight();
        assertEquals(10, shopper.getXCoordinate());
    }
    
    
    
    @Test
    public void moveLeftWorks(){
        shopper.setLocation(10, 0);
        shopper.moveLeft();
        assertEquals(5, shopper.getXCoordinate());
        
    }
    
    
    @Test
    public void moveLeftWontGoOverGrid(){
        shopper.moveLeft();
        assertEquals(0,shopper.getXCoordinate());
    }
    
    
    
    
    
    
    
    

    
}
