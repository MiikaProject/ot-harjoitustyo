/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game.models;

import javafx.scene.shape.Rectangle;

/**
 *
 * @author miika
 */
public class Shelf extends Rectangle{
    private Rectangle shelf;

    public Shelf(int x, int y) {
        shelf = new Rectangle(100, 50);
        shelf.setX(x);
        shelf.setY(y);
    }
    
    public Rectangle getShelf(){
        return shelf;
    }
    
    public boolean isShelf(){
        return true;
    }
    
    
    
}
