package grocerygame.game.models;



/**
 * Grocery is a object which the player has to collect in the game
 * 
 */
public class Grocery {

    private String name;
    private String category;

    public Grocery(String name, String category) {
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Category: " + category;
    }
    
    /**
     * Returns the category of the grocery such as meat etc.
     * @return Returns the category of the grocery as String
     */
    public String getCategory() {
        return category;
    }
    
    /**
     * Returns the name of the grocery
     * @return Returns the name of the grocery as String
     */
    public String getName() {
        return name;
    }

}
