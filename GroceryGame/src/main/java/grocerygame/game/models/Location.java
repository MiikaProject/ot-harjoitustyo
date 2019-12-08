package grocerygame.game.models;

//Location holds the x and y coordinates, it is used to hold the Player-icon
// location. 
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

    public void setLocation(int y, int x) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "X:" + x + " Y: " + y;
    }

}
