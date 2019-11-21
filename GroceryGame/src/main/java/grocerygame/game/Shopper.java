/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
ta */
package grocerygame.game;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author miika
 */
public class Shopper extends Rectangle{
    
    private Rectangle shopper;
    
    public Shopper() {
        shopper = new Rectangle(30, 30);
        
        shopper.setFill(Color.BLUEVIOLET);
    }
    
    public void moveUp(){
        System.out.println(shopper.getY());
        if(shopper.getY()<=0){
            return;
        }
        shopper.setY(shopper.getY()-5);
    }
    public void moveDown(){
        if(shopper.getY()>=270){
            return;
        }
        shopper.setY(shopper.getY()+5);
    }
    public void moveRight(){
        if(shopper.getX()>=300){
            return;
        }
        shopper.setX(shopper.getX()+5);
    }
    public void moveLeft(){
        if(shopper.getX()<=0){
            return;
        }
        shopper.setX(shopper.getX()-5);
    }
    
    
    public void printLocation(){
        System.out.println("X:"+shopper.getX()+" Y:"+shopper.getY());
    }
    
    
    public void setLocation(int x, int y){
        shopper.setX(x);
        shopper.setY(y);
    }
    
    public Rectangle getShopper(){
        return shopper;
    }

    
}
