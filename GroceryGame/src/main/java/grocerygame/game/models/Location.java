/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game.models;

/**
 *
 * @author miika1
 */
public class Location {
    private int x;
    private int y;
    
    public Location() {
    }
    
    
    public Location(int y, int x) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setLocation(int y, int x){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "X:"+x+ " Y: "+y;
    }
    
    
    
}
