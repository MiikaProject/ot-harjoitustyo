package grocerygame.game.models;

import java.util.ArrayList;
import java.util.Random;


/**
 * GroceryList holds the collection of different groceries and creates
 * random shopping list for player. The number of items on list changes
 * depending on the difficulty of the game
 * 
 */
public class GroceryList {

    private ArrayList<Grocery> grocerylist;
    private ArrayList<Grocery> groceryDatabase;

    public GroceryList() {
        grocerylist = new ArrayList<>();
        groceryDatabase = new ArrayList<>();
        initDatabase();
    }

    public GroceryList(int difficulty) {
        grocerylist = new ArrayList<>();
        groceryDatabase = new ArrayList<>();
        initDatabase();

        if (difficulty == 3) {
            initDifficultyThree();
        } else if (difficulty == 2) {
            initDifficultyTwo();
        } else {
            initDifficultyOne();
        }
    }
    
    /**
     * Method adds Grocery to the Grocerylist
     * @param grocery is the grocery to be added to grocerylist.
     */
    public void addToGrocerylist(Grocery grocery) {
        grocerylist.add(grocery);
    }

    @Override
    public String toString() {
        return grocerylist.toString();
    }
    
    /**
     * Method gives other objects access to the grocerylist ArrayList
     * @return returns the grocerylist ArrayList
     */
    public ArrayList<Grocery> getGrocerylist() {
        return grocerylist;
    }
    
    /**
     * Method returns all possible groceries. 
     * @return returns the groceryDatabase ArrayList
     */
    public ArrayList<Grocery> getGroceryDatabase() {
        return groceryDatabase;
    }
    
    /**
     * Method removes Grocery specified in the parameter from grocerylist
     * @param grocery to be removed from grocerylist
     */
    public void remove(Grocery grocery) {
        grocerylist.remove(grocery);
    }

    /**
     * Method inits grocerylist with 5 items
     */
    public void initDifficultyTwo() {
        while (grocerylist.size() < 5) {
            Grocery randomGrocery = randomGrocery();
            if (!grocerylist.contains(randomGrocery)) {
                grocerylist.add(randomGrocery);
            }
        }
    }
    
    /**
     * Method inits grocerylist with 7 items
     */
    private void initDifficultyThree() {
        while (grocerylist.size() < 7) {
            Grocery randomGrocery = randomGrocery();
            if (!grocerylist.contains(randomGrocery)) {
                grocerylist.add(randomGrocery);
            }
        }
    }
    
    /**
     * Method inits grocerylist with 3 items
     */
    private void initDifficultyOne() {
        while (grocerylist.size() < 3) {
            Grocery randomGrocery = randomGrocery();
            if (!grocerylist.contains(randomGrocery)) {
                grocerylist.add(randomGrocery);
            }
        }
    }
    
    /**
     * Method is used to generate random Grocery from the grocerydatabase.
     * @return returns random Grocey from the grocery database
     */
    public Grocery randomGrocery() {
        Random random = new Random();
        return groceryDatabase.get(random.nextInt(groceryDatabase.size()));
    }
    
    /**
     * Method inits the grocerydatabase with all different grocery options.
     */
    private void initDatabase() {
        groceryDatabase.add(new Grocery("Milk", "M"));
        groceryDatabase.add(new Grocery("Icecream", "P"));
        groceryDatabase.add(new Grocery("Banana", "F"));
        groceryDatabase.add(new Grocery("Chicken", "ME"));
        groceryDatabase.add(new Grocery("Salmon", "FI"));
        groceryDatabase.add(new Grocery("Chocolate", "E"));
        groceryDatabase.add(new Grocery("Sandwitch", "B"));
        groceryDatabase.add(new Grocery("Salad", "V"));
        groceryDatabase.add(new Grocery("CocaCola", "D"));
        groceryDatabase.add(new Grocery("Soap", "H"));
    }

}
