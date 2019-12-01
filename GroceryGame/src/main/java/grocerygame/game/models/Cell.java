/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game.models;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author miika1
 */
public class Cell {

    private String type;
    int x;
    int y;
    Node image;

    //Cell types:
    // O = empty
    // S = shopper
    // M = Milk 
    // P = Frozen
    // F = Fruit
    // R = Rice/Pasta
    // B = Bread
    // C = Cashier
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        type = "O";
    }

    public Cell(String type) {
        this.type = type;
    }

    public void setCellType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
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

    public void setLocation(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public Node getImage() {
        if (type.equals("O")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.ANTIQUEWHITE);
            return cell;
        } else if (type.equals("S")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.AQUA);
            return cell;
        } else if (type.equals("M")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.BURLYWOOD);
            return cell;
        } else if (type.equals("P")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.BLUEVIOLET);
            return cell;
        } else if (type.equals("B")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.YELLOW);
            return cell;
        } else if (type.equals("F")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.GREEN);
            return cell;
        } else if (type.equals("R")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.DARKORANGE);
            return cell;
        } else if (type.equals("C")) {
            Rectangle cell = new Rectangle(10, 10);
            cell.setFill(Color.BLACK);
            return cell;
        }

        return null;
    }

    public String getType() {
        return this.type;
    }

}
