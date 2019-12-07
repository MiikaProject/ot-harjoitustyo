package grocerygame.game.controllers;

import grocerygame.game.models.GameGrid;
import grocerygame.game.views.GameDisplay;
import grocerygame.game.views.GameView;
import grocerygame.game.views.GroceryListView;
import grocerygame.gameover.views.GameOverView;
import grocerygame.primaryview.views.PrimaryView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

//Gamecontroller handles events that happen in the GameView View
public class GameController {

    private GameGrid gamegrid;
    private GameDisplay gameDisplay;
    private GameView gameview;
    private GroceryListView grocerylistview;
    private boolean gameover;
    private Stage window;

    public GameController(GameView gameview) {
        
        this.gameview = gameview;
        this.gameDisplay = gameview.getGamefield();
        this.gamegrid = gameDisplay.getGrid();
        this.grocerylistview = gameview.getListItems();
        this.window = gameview.getWindow();

    }

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

    public void refreshView() {
        if (gamegrid.gameover() == true) {
            changeToGameOver();
        }
        gameDisplay.redrawGrid();
        grocerylistview.createView();

    }

    //method to return back to primaryview
    public void changeToPrimaryView(ActionEvent event) {

        PrimaryView primaryview = new PrimaryView(window);
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(primaryview.getView());
        window.show();
    }

    public void changeToGameOver() {
        GameOverView gameoverview = new GameOverView(window);
        gameview.getAnimation().stop();
        window.setScene(gameoverview.getView());

    }

    public void exitGame(ActionEvent event) {
        Platform.exit();
    }

}
