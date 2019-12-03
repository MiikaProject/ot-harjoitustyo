/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game;

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
public class LocationTest {
    private Location location;
    public LocationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        location = new Location();
    }
    
    @Test
    public void constuctorWorks(){
        assertEquals(0, location.getX());
        assertEquals(0, location.getY());
    }
    
    @Test
    public void setXWorks(){
        location.setX(50);
        assertEquals(50, location.getX());   
    }
    
    @Test
    public void setYWorks(){
        location.setY(50);
        assertEquals(50, location.getY());   
    }
    
    @Test
    public void setLocationWorks(){
        location.setLocation(50,50);
        assertEquals(50, location.getY());
        assertEquals(50, location.getX());
    }
}
