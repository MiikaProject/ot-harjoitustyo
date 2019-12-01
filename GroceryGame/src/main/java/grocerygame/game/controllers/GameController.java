/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game.controllers;

import grocerygame.game.models.GameGrid;
import grocerygame.game.models.Shopper;
import grocerygame.game.views.GameView2;
import grocerygame.game.views.GroceryListView;
import grocerygame.gameover.views.GameOverView;
import grocerygame.primaryview.views.PrimaryView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author miika
 */
public class GameController {

    private GameGrid gamegrid;
    private GameView2 gameview2;
    private GroceryListView grocerylistview;
    private boolean gameover;
    private Stage window;

    public GameController(GameView2 gameview2, GroceryListView grocerylistview, Stage window) {

        this.gameview2 = gameview2;
        this.gamegrid = gameview2.getGrid();
        this.grocerylistview = grocerylistview;
        this.window = window;

    }

    public void handleKeyPress(KeyEvent event) {

        KeyCode key = event.getCode();
        if (key == KeyCode.DOWN) {
            gamegrid.moveDownShopper();
            refreshView();
        } else if (key == KeyCode.UP) {
            gamegrid.moveUpShopper();
            refreshView();
        } else if (key == KeyCode.LEFT) {
            gamegrid.moveLeftShopper();
            refreshView();
        } else if (key == KeyCode.RIGHT) {
            gamegrid.moveRightShopper();
            refreshView();
        }

    }

    public void refreshView() {
        if (gamegrid.gameover() == true) {
            changeToGameOver();
        }
        gameview2.redrawGrid();
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
        window.setScene(gameoverview.getView());

    }

    public void exitGame(ActionEvent event) {
        Platform.exit();
    }

}
