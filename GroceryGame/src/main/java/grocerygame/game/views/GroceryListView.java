package grocerygame.game.views;

import grocerygame.game.models.Grocery;
import grocerygame.game.models.GroceryList;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


/**
 * GroceryListView renders the shopping list
 *
 */
public class GroceryListView {

    private GroceryList grocerylist;
    private VBox list;

    GroceryListView(GroceryList grocerylist) {
        this.grocerylist = grocerylist;
        list = new VBox();
        createView();
    }
    
    /**
     * Method updates the displayed grocerylist to match the inner status of the grocerylist. 
     */
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

    /**
     * Method returns the view as VBox
     * 
     */
    public VBox getView() {
        return this.list;
    }

}
