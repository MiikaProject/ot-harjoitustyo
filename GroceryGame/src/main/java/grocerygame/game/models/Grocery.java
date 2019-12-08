package grocerygame.game.models;

// Grocery is a object which the player has to collect in the game
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

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

}
