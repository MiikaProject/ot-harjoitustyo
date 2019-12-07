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

//View that renders the shopping list
public class GroceryListView {

    private GroceryList grocerylist;
    private VBox list;

    GroceryListView(GroceryList grocerylist) {
        this.grocerylist = grocerylist;
        list = new VBox();
        createView();
    }

    public void createView() {
        list.getChildren().clear();
        
        //If list is empty, show message to go to cashier, if not show
        //remaining items.
        if (grocerylist.getGrocerylist().isEmpty()) {
            list.getChildren().add(new Label("Cashier next!"));
        } else {
            list.getChildren().add(new Label("GroceryList:"));
            for (Grocery grocery : grocerylist.getGrocerylist()) {
                list.getChildren().add(new Label(grocery.getName()));
            }
        }

    }

    public VBox getView() {
        return this.list;
    }

}
