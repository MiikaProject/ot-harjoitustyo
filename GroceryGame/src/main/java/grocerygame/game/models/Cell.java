package grocerygame.game.models;

import grocerygame.game.views.CellView;
import javafx.scene.Node;



/**
 * Cell class is the building block of the gamegrid, it represents every unit in the game
 * 
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
    
    /**
     * Method sets cell type to param type.
     * @param type 
     */
    public void setCellType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
    
    /**
     * Method returns x coordinate of the cell.
     * @return x coordinate of the cell.
     */
    public int getX() {
        return x;
    }
    
    /**
     * Method returns y coordinate of the cell.
     * @return y coordinate of the cell.
     */
    public int getY() {
        return y;
    }
    
    /**
     * Sets x-coordinate of the cell to param.
     * @param x coordinate of the cell
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * Sets y-coordinate of the cell to param.
     * @param y coordinate of the cell
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Sets cell location to param y,x
     * @param y coordinate of the cell
     * @param x coordinate of the cell
     */
    public void setLocation(int y, int x) {
        this.y = y;
        this.x = x;
    }
    
    /**
     * Method creates a CellView object which is the JavaFX representation
     * of the cell. Then returns it.
     * @return Node of cell
     */
    public Node getImage() {
        CellView view = new CellView(this);
        return view.cellImage();

    }

    /**
     * Method returns cell type
     * @return returns cell type
     */
    public String getType() {
        return this.type;
    }

}
