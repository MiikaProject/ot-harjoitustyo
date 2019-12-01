/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game.views;

import grocerygame.game.models.Grocery;
import grocerygame.game.models.GroceryList;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author miika1
 */
public class GroceryListView {
    private GroceryList grocerylist;
    private VBox list;
    
    GroceryListView(GroceryList grocerylist) {
        this.grocerylist = grocerylist;
        list = new VBox();
        createView();
    }
    
    public void createView(){
        list.getChildren().clear();
        if(grocerylist.getGrocerylist().isEmpty()){
            list.getChildren().add(new Label("Cashier next!"));
        }
        for(Grocery grocery : grocerylist.getGrocerylist()){
            list.getChildren().add(new Label(grocery.getName()));
        }
    }
    
    public VBox getView(){
        return this.list;
    }
    
}
