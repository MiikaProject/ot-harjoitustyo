/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
ta */
package grocerygame.game.models;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author miika
 */
public class Shopper extends Rectangle {

    private Rectangle shape;
    int x;
    int y;
    private double ylimit;
    private double xlimit;

    public Shopper() {
        shape = new Rectangle(30, 30);
        this.x = 0;
        this.y = 0;
        xlimit = 370;
        ylimit = 270;
        shape.setFill(Color.BLUEVIOLET);
    }

    public void moveUp() {
        printLocation();
        if (shape.getY() <= 0) {
            return;
        }
        shape.setY(shape.getY() - 5);
        this.y = y - 5;
    }

    public void moveDown() {
        if (shape.getY() >= ylimit) {
            return;
        }
        shape.setY(shape.getY() + 5);
        y = y + 5;
    }

    public void moveRight() {
        if (shape.getX() >= xlimit) {
            return;
        }
        shape.setX(shape.getX() + 5);
        x = x + 5;
    }

    public void moveLeft() {
        if (shape.getX() <= 0) {
            return;
        }
        shape.setX(shape.getX() - 5);
        this.x = this.x - 5;
    }

    public void printLocation() {
        System.out.println("X:" + x + " Y:" + y);
    }

    public void setLocation(int x, int y) {
        shape.setX(x);
        this.x = x;
        this.y = y;
        shape.setY(y);
    }

    public Rectangle getShopper() {
        return shape;
    }

    public void setLimits(int x, int y) {
        this.xlimit = x - shape.getWidth();
        this.ylimit = y - shape.getHeight();
    }

    public int getXCoordinate() {
        return this.x;
    }

    public int getYCoordinate() {
        return this.y;
    }

}
