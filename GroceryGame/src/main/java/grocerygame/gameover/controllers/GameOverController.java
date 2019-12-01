/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.gameover.controllers;

import grocerygame.primaryview.views.PrimaryView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 *
 * @author miika1
 */
public class GameOverController {

    private Stage window;

    public GameOverController(Stage window) {
        this.window = window;
    }

    //method to return back to primaryview
    public void changeToPrimaryView(ActionEvent event) {
        PrimaryView primaryview = new PrimaryView(window);
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(primaryview.getView());
        window.show();
    }

    //Exit game
    public void exitGame(ActionEvent event) {
        Platform.exit();
    }
}
