package grocerygame.game.views;

import grocerygame.primaryview.models.Player;
import grocerygame.game.controllers.GameController;
import grocerygame.game.models.GameGrid;
import grocerygame.game.models.GroceryList;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

//The main view of the GameWindow, it holds other smaller views such as
// GameDisplay, GroceryList,OptionsPanel
public class GameView {

    private Player player;
    private Scene game;
    private Stage window;
    private AnimationTimer animation;
    private GameDisplay gamefield;
    private GroceryListView listItems;

    //Build view
    public GameView(Player player, Stage window) {
        this.player = player;
        this.window = window;

        //Set up grid for the window
        GridPane layout = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(75);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(25);
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(50);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(50);
        layout.getColumnConstraints().addAll(column1, column2);
        layout.getRowConstraints().addAll(row1, row2);

        //Buttons to return back to primary view and exit game
        OptionsPanel options = new OptionsPanel();

        layout.add(options.getOptions(), 0, 0);

        //"Grocerylist"
        GroceryList grocerylist = new GroceryList(player.getDifficulty());
        listItems = new GroceryListView(grocerylist);
        layout.add(listItems.getView(), 1, 1);

        //The actual game
        gamefield = new GameDisplay(new GameGrid(20, 20, grocerylist));

        layout.add(gamefield.getView(), 0, 1);

        //Legend for shelves
        GroceryTipsView guide = new GroceryTipsView();

        layout.add(guide.getGuide(), 1, 0);

        game = new Scene(layout, 400, 400);
        GameController gamecontroller = new GameController(this);
        game.setOnKeyPressed(event -> gamecontroller.handleKeyPress(event));
        options.setController(gamecontroller);

        animation = new AnimationTimer() {
            long previous;

            @Override
            public void handle(long now) {
                if (now - previous < 10000) {
                    return;
                }
                gamecontroller.refreshView();

                this.previous = now;
            }
        };

        animation.start();
    }

    
    public Scene getView() {
        return game;
    }

    public AnimationTimer getAnimation() {
        return animation;
    }

    public GameDisplay getGamefield() {
        return gamefield;
    }

    public GroceryListView getListItems() {
        return listItems;
    }

    public Stage getWindow() {
        return window;
    }

}
