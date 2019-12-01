/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game.views;

import grocerygame.game.models.GameGrid;
import javafx.scene.layout.Pane;

/**
 *
 * @author miika1
 */
public class GameField {
    Pane gamefield;
    GameGrid gamegrid;
    
    public GameField() {
        gamefield = new Pane();
        
        
        
    }
    
    
    public void drawGameField(){
        
        System.out.println("drawing");
        for(int i = 0;i < gamegrid.grid[0].length;i++){
            for(int j = 0; j < gamegrid.grid[i].length;j++){
                gamefield.getChildren().add(gamegrid.grid[i][j].getImage());
            }
        }
    }

    public Pane getGamefield() {
        return gamefield;
    }
    
    
    
    
}
