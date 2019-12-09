package grocerygame.game.views;

import grocerygame.primaryview.models.Player;
import grocerygame.game.controllers.GameController;
import grocerygame.game.models.GameGrid;
import grocerygame.game.models.GroceryList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;



/**
 * The main view of the GameWindow, it holds other smaller views such as
 * GameDisplay, GroceryList,OptionsPanel.
 */
public class GameView {

    private Player player;
    private Scene game;
    private Stage window;
    private AnimationTimer animation;
    private GameDisplay gamefield;
    private GroceryListView listItems;
    private TimeLeftView timeleft;

    
    public GameView(Player player, Stage window) throws Exception {
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

        //Counter for remaining time
        timeleft = new TimeLeftView();
        layout.add(timeleft.getView(), 1, 1);

        //"Grocerylist"
        GroceryList grocerylist = new GroceryList(player.getDifficulty());
        listItems = new GroceryListView(grocerylist);
        layout.add(listItems.getView(), 1, 1);

        //The actual game
        gamefield = new GameDisplay(new GameGrid(20, 20, grocerylist, player));

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
            long startTime = System.currentTimeMillis();

            @Override
            public void handle(long now) {
                if (now - previous < 10000) {
                    return;
                }
                long elapsedTime = System.currentTimeMillis() - startTime;

                try {
                    gamecontroller.refreshView(elapsedTime);

                } catch (Exception ex) {
                    Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
                }

                this.previous = now;
            }
        };

        animation.start();
    }
    
    /**
     * Method returns the view.
     * 
     */
    public Scene getView() {
        return game;
    }
    
    /**
     * Method returns the Animation which provides the view the refresh ticks. Gives access
     * to the animation for gamecontroller.
     * @return Animation returns the Animation which provides the view the refresh ticks
     */
    public AnimationTimer getAnimation() {
        return animation;
    }

    /**
     * Method returns the GameDisplay object which contains the actual game.
     * @return returns the GameField containing the actual game.
     */
    public GameDisplay getGamefield() {
        return gamefield;
    }

    /**
     * Method returns the GroceryListView part of the GameView.
     * @return gives access to the GroceryListView.
     */
    public GroceryListView getListItems() {
        return listItems;
    }
    
    /**
     * Method returns the Stage window.
     * @return returns the window in which the application runs.
     */
    public Stage getWindow() {
        return window;
    }
    
    /**
     * Method returns the Player. 
     * @return returns the current Player.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Method returns the time left counter
     * @return returns TimeLeftView.
     */
    public TimeLeftView getTimeleft() {
        return timeleft;
    }

}
