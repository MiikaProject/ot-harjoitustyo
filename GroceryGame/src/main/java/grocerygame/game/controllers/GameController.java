/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game.controllers;

import grocerygame.game.models.Shopper;
import grocerygame.primaryview.views.PrimaryView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 *
 * @author miika
 */
public class GameController {

    private Shopper shopper;

    public GameController(Shopper shopper) {
        this.shopper = shopper;
    }
    
    

    public void handleKeyPress(KeyEvent event) {

        KeyCode key = event.getCode();
        if (key == KeyCode.DOWN) {
            shopper.moveDown();
        } else if (key == KeyCode.UP) {
            shopper.moveUp();
        } else if (key == KeyCode.LEFT) {
            shopper.moveLeft();
        } else if (key == KeyCode.RIGHT) {
            shopper.moveRight();
        }

        

    }
    
    //method to return back to primaryview
    public void changeToPrimaryView(ActionEvent event) {
        PrimaryView primaryview = new PrimaryView();
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(primaryview.getView());
        window.show();
    }

    public void exitGame(ActionEvent event) {
        Platform.exit();
    }
    

}
