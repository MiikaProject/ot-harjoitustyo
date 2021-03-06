package grocerygame.game.controllers;

import grocerygame.game.models.GameGrid;
import grocerygame.game.views.GameDisplay;
import grocerygame.game.views.GameView;
import grocerygame.game.views.GroceryListView;
import grocerygame.game.views.TimeLeftView;
import grocerygame.gameover.views.GameOverView;
import grocerygame.primaryview.views.PrimaryView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

//

/**
 * Gamecontroller handles events that happen in the GameView View
 * 
 */
public class GameController {

    private GameGrid gamegrid;
    private GameDisplay gameDisplay;
    private GameView gameview;
    private GroceryListView grocerylistview;
    private TimeLeftView timeleft;
    private boolean gameover;
    private Stage window;

    public GameController(GameView gameview) {

        this.gameview = gameview;
        this.gameDisplay = gameview.getGamefield();
        this.gamegrid = gameDisplay.getGrid();
        this.grocerylistview = gameview.getListItems();
        this.window = gameview.getWindow();
        this.timeleft = gameview.getTimeleft();

    }
    
    /**
     * Method handles keyEvents in the game.
     * 
     */
    public void handleKeyPress(KeyEvent event) {

        KeyCode key = event.getCode();
        if (key == KeyCode.DOWN) {
            gamegrid.moveDownShopper();
        } else if (key == KeyCode.UP) {
            gamegrid.moveUpShopper();
        } else if (key == KeyCode.LEFT) {
            gamegrid.moveLeftShopper();
        } else if (key == KeyCode.RIGHT) {
            gamegrid.moveRightShopper();
        }

    }
    
    /**
     * Method updates the gameview. 
     * @param timeSpendInGame is used to calculate time remaining
     */
    public void refreshView(long timeSpendInGame) throws Exception {
        if (gamegrid.gameover() == true) {
            changeToGameOver();
        }

        gameview.getPlayer().getScore().updateTime(timeSpendInGame);
        if (gameview.getPlayer().getScore().timeOver()) {
            changeToGameOver();
        }
        gameDisplay.redrawGrid();
        grocerylistview.createView();

        timeleft.refreshTimeLeft(timeSpendInGame);

    }

   
    /**
     * Method to return back to primaryview after clicking return
     */
    public void changeToPrimaryView(ActionEvent event) throws Exception {

        PrimaryView primaryview = new PrimaryView(window);
        window.setScene(primaryview.getView());
        window.show();
    }
    
    /**
     * Method to change to gameOverView after game ends.
     */
    public void changeToGameOver() throws Exception {
        GameOverView gameoverview = new GameOverView(window, gameview.getPlayer());
        gameview.getAnimation().stop();
        window.setScene(gameoverview.getView());

    }
    
    /**
     * Method to exit game.
     * @param event 
     */
    public void exitGame(ActionEvent event) {
        Platform.exit();
    }

}
