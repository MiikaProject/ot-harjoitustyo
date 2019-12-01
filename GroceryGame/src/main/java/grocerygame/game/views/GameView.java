/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game.views;

import grocerygame.game.controllers.GameController;
import grocerygame.game.models.GameGrid;
import grocerygame.game.models.GroceryList;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 *
 * @author miika1
 */
public class GameView {

    private String player;
    private int difficulty;
    private Scene game;
    private Map<KeyCode, Boolean> pressedButtons;
    private Stage window;

    //Build view
    public GameView(String player, int difficulty, Stage window) {
        pressedButtons = new HashMap<>();
        this.player = player;
        this.difficulty = difficulty;
        this.window = window;

        //Set up grid for the window
        GridPane layout = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(75);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(25);
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(25);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(75);
        layout.getColumnConstraints().addAll(column1, column2);
        layout.getRowConstraints().addAll(row1, row2);

        //Buttons to return back to primary view and exit game
        OptionsPanel options = new OptionsPanel();

        layout.add(options.getOptions(), 0, 0);

        //"Grocerylist"
        GroceryList grocerylist = new GroceryList();
        GroceryListView listItems = new GroceryListView(grocerylist);
        layout.add(listItems.getView(), 1, 0);
        
        //The actual game
        GameDisplay gamefield = new GameDisplay(new GameGrid(20, 20, grocerylist));
        
        layout.add(gamefield.getView(), 0, 1);
        
        
        //Legend for shelves
        GroceryTipsView guide = new GroceryTipsView();
        
        layout.add(guide.getGuide(), 1, 1);
        
        game = new Scene(layout, 400, 400);
        GameController gamecontroller = new GameController(gamefield, listItems, window);
        game.setOnKeyPressed(event -> gamecontroller.handleKeyPress(event));
        options.setController(gamecontroller);
    }

    //get gameview
    public Scene getView() {

        return game;
    }

}
