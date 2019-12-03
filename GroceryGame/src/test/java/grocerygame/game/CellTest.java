/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game;

import grocerygame.game.models.Cell;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
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
public class CellTest {

    private Cell cell;

    public CellTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        cell = new Cell();
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void constuctorWorks() {
        assertEquals("O", cell.getType());
    }

    @Test
    public void setCellTypeWorks() {
        cell.setCellType("X");
        assertEquals("X", cell.getType());
    }

    @Test
    public void setXWorks() {
        cell.setX(50);
        assertEquals(50, cell.getX());
    }
    
    @Test
    public void setYWorks() {
        cell.setY(50);
        assertEquals(50, cell.getY());
    }
    
    @Test
    public void setLocationWorks() {
        cell.setLocation(50,50);
        assertEquals(50, cell.getY());
        assertEquals(50, cell.getX());
    }
    
    
    @Test
    public void voidGetImageWorks(){
        cell.setCellType("S");
        assertEquals(Rectangle.class, cell.getImage().getClass());
    }

}
