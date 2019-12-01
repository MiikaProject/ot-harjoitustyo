/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game.models;

import java.util.ArrayList;

/**
 *
 * @author miika1
 */
public class GroceryList {
    private ArrayList<Grocery> grocerylist;

    public GroceryList() {
        grocerylist = new ArrayList<>();
        addToGrocerylist(new Grocery("Milk", "M"));
        addToGrocerylist(new Grocery("Bread", "B"));
    }
    
    
    public void addToGrocerylist(Grocery grocery){
        grocerylist.add(grocery);
    }

    @Override
    public String toString() {
        return grocerylist.toString();
    }

    public ArrayList<Grocery> getGrocerylist() {
        return grocerylist;
    }
    
    public void remove(Grocery grocery){
        grocerylist.remove(grocery);
    }
    
    
    
    
    
    
    
}
