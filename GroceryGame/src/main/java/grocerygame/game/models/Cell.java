package grocerygame.game.models;

import grocerygame.game.views.CellView;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//Cell class is the building block of the gamegrid, it represents 
// every unit in the game
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
    // E = Candies
    // V = Vegetables
    // D = Drinks
    // ME = Meat
    // FI = Fish
    // H = Household
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        type = "O";
    }

    public Cell() {
        this.x = 0;
        this.y = 0;
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
        CellView view = new CellView(this);
        return view.cellImage();

    }

    public String getType() {
        return this.type;
    }

}
