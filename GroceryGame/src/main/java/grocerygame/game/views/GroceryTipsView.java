
package grocerygame.game.views;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


//GroceryTipsView shows the color labels for different shelves
public class GroceryTipsView {
    private GridPane guide;

    public GroceryTipsView() {
        guide = new GridPane();
        
        
        
        Label legend = new Label("Guide");
        guide.add(legend, 0, 0);
        Label milkText = new Label("Milk");
        Rectangle milkColor = new Rectangle(10, 10);
        milkColor.setFill(Color.BURLYWOOD);
        guide.add(milkText, 0, 1);
        guide.add(milkColor, 1, 1);
        
        
        Label fruitText = new Label("Fruit");
        Rectangle fruitColor = new Rectangle(10, 10);
        fruitColor.setFill(Color.GREEN);
        guide.add(fruitText, 0, 2);
        guide.add(fruitColor, 1, 2);
        
        Label BreadText = new Label("Bread");
        Rectangle BreadColor = new Rectangle(10, 10);
        BreadColor.setFill(Color.YELLOW);
        guide.add(BreadText, 0, 3);
        guide.add(BreadColor, 1, 3);
        
        
        Label DrinksText = new Label("Drinks");
        Rectangle DrinksColor = new Rectangle(10, 10);
        DrinksColor.setFill(Color.AQUAMARINE);
        guide.add(DrinksText, 0, 4);
        guide.add(DrinksColor, 1, 4);
        
        Label FrozenText = new Label("Frozen");
        Rectangle FrozenColor = new Rectangle(10, 10);
        FrozenColor.setFill(Color.BLUEVIOLET);
        guide.add(FrozenText, 0, 5);
        guide.add(FrozenColor, 1, 5);
        
        Label MeatText = new Label("Meat");
        Rectangle MeatColor = new Rectangle(10, 10);
        MeatColor.setFill(Color.CADETBLUE);
        guide.add(MeatText, 0, 6);
        guide.add(MeatColor, 1, 6);
        
        Label FishText = new Label("Fish");
        Rectangle FishColor = new Rectangle(10, 10);
        FishColor.setFill(Color.LIGHTSEAGREEN);
        guide.add(FishText, 0, 7);
        guide.add(FishColor, 1, 7);
        
        Label VegetablesText = new Label("Vegetables");
        Rectangle VegetablesColor = new Rectangle(10, 10);
        VegetablesColor.setFill(Color.GREENYELLOW);
        guide.add(VegetablesText, 0, 8);
        guide.add(VegetablesColor, 1, 8);
        
        
        Label CandiesText = new Label("Candies");
        Rectangle CandiesColor = new Rectangle(10, 10);
        CandiesColor.setFill(Color.LIGHTCORAL);
        guide.add(CandiesText, 0, 9);
        guide.add(CandiesColor, 1, 9);
        
        Label HouseholdText = new Label("Household");
        Rectangle HouseholdColor = new Rectangle(10, 10);
        HouseholdColor.setFill(Color.GREENYELLOW);
        guide.add(HouseholdText, 0, 10);
        guide.add(HouseholdColor, 1, 10);
        
        Label CashierText = new Label("Cashier ");
        Rectangle CashierColor = new Rectangle(10, 10);
        CashierColor.setFill(Color.BLACK);
        guide.add(CashierText, 0, 11);
        guide.add(CashierColor, 1, 11);
        
        
        
    }

    public GridPane getGuide() {
        return guide;
    }
    
    
}
