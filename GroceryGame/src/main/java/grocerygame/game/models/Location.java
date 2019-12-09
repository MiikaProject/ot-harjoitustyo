package grocerygame.game.models;

//
// 

/**
 * Location holds the x and y coordinates, it is used to keep track of the Player-icon
 * location. 
 * 
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
    
    /**
     * Method returns the x-coordinate.
     * @return returns x-coordinate as integer.
     */
    public int getX() {
        return x;
    }
    
    /**
     * Method returns the y-coordinate.
     * @return returns y-coordinate as integer.
     */
    public int getY() {
        return y;
    }
    
    /**
     * Method sets the x-coordinate of the object to the parameter.
     * @param x parameter int x is the desired x coordinate.
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * Method sets the y-coordinate of the object to the parameter.
     * @param y parameter int y is the desired x coordinate.
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Method sets Location to certain y,x location.
     * @param y is the y-coordinate the object is set to.
     * @param x is the x-coordinate the object is set to.
     */
    public void setLocation(int y, int x) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "X:" + x + " Y: " + y;
    }

}
