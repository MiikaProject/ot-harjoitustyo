/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.primaryview;

import grocerygame.primaryview.models.Score;
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
public class ScoreTest {
    private Score score;
    public ScoreTest() {
    }
    

    @Before
    public void setUp() {
        score = new Score(1);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void startingScoreIsZero(){
        assertEquals(0, score.calculateScore());
        score.setDifficulty(2);
        assertEquals(0, score.calculateScore());
        score.setDifficulty(3);
        assertEquals(0, score.calculateScore());
    }
    
    @Test
    public void addItemWorks(){
        score.addItem();
        assertEquals(1, score.getItems());
    }
    
    
    @Test
    public void CashierInitsFalse(){
        assertEquals(false, score.isCashier());
    }
    
    @Test
    public void addCashierWorks(){
        score.addCashier();
        assertEquals(true, score.isCashier());
    }
    
    @Test
    public void initiallyTimeRemainingIsTimeTotal(){
        assertEquals(score.getTimeTotal(), score.getTimeRemaining());
    }
    
    @Test 
    public void timeSpentWorks(){
        long timespent = 10000;
        score.updateTime(timespent);
        assertEquals(score.getTimeTotal()-timespent, score.getTimeRemaining());
    }
    
    
    @Test
    public void TimeRemainingWontGoNegative(){
        long timeremoved=score.getTimeTotal()*2;
        score.updateTime(timeremoved);
        assertEquals(0, score.getTimeRemaining());
    }
    
    @Test
    public void TimeEndsGameEnds(){
        long timeremoved=score.getTimeTotal()*2;
        score.updateTime(timeremoved);
        assertEquals(true, score.timeOver());
    }
    
    @Test
    public void WhenTimeLeftGameOverIsFalse(){
        score.updateTime((score.getTimeTotal()/3));
        assertEquals(false, score.timeOver());
    }
}
