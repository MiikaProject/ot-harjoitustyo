package grocerygame.game.models;

import java.util.ArrayList;
import java.util.Random;


//GroceryList holds the collection of different groceies and creates 
// random shopping list for player. The number of items on list changes
// depending on the difficulty of the game
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

    public void addToGrocerylist(Grocery grocery) {
        grocerylist.add(grocery);
    }

    @Override
    public String toString() {
        return grocerylist.toString();
    }

    public ArrayList<Grocery> getGrocerylist() {
        return grocerylist;
    }

    public ArrayList<Grocery> getGroceryDatabase() {
        return groceryDatabase;
    }

    public void remove(Grocery grocery) {
        grocerylist.remove(grocery);
    }

    public void initDifficultyTwo() {
        while (grocerylist.size() < 5) {
            Grocery randomGrocery = randomGrocery();
            if (!grocerylist.contains(randomGrocery)) {
                grocerylist.add(randomGrocery);
            }
        }
    }

    private void initDifficultyThree() {
        while (grocerylist.size() < 7) {
            Grocery randomGrocery = randomGrocery();
            if (!grocerylist.contains(randomGrocery)) {
                grocerylist.add(randomGrocery);
            }
        }
    }

    private void initDifficultyOne() {
        while (grocerylist.size() < 3) {
            Grocery randomGrocery = randomGrocery();
            if (!grocerylist.contains(randomGrocery)) {
                grocerylist.add(randomGrocery);
            }
        }
    }

    public Grocery randomGrocery() {
        Random random = new Random();
        return groceryDatabase.get(random.nextInt(groceryDatabase.size()));
    }

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
