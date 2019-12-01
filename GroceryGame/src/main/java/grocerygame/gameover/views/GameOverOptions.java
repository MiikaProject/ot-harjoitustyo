/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.gameover.views;

import grocerygame.gameover.controllers.GameOverController;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author miika1
 */
public class GameOverOptions {

    HBox options;
    Button quit;
    Button exit;
    GameOverController gameovercontroller;
    Stage window;

    public GameOverOptions(Stage window) {
        options = new HBox();
        quit = new Button("Return");
        exit = new Button("Exit");
        this.window = window;
        options.getChildren().add(quit);
        options.getChildren().add(exit);
        options.setSpacing(5);
        options.setFocusTraversable(true);

    }

    public HBox getOptions() {
        return options;
    }

    public Button getQuit() {
        return quit;
    }

    public Button getExit() {
        return quit;
    }

    public void setController(GameOverController controller) {
        this.gameovercontroller = controller;
        quit.setOnAction(event -> gameovercontroller.changeToPrimaryView(event));
        exit.setOnAction(event -> gameovercontroller.exitGame(event));
    }
}
