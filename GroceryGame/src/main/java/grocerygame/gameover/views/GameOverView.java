/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.gameover.views;

import grocerygame.game.controllers.GameController;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import grocerygame.game.views.OptionsPanel;
import grocerygame.gameover.controllers.GameOverController;

/**
 *
 * @author miika1
 */
public class GameOverView {

    private Scene gameover;
    Stage window;

    public GameOverView(Stage window) {
        this.window = window;
        BorderPane layout = new BorderPane();
        layout.setCenter(new Label("GAME OVER"));
        GameOverOptions options = new GameOverOptions(window);
        options.setController(new GameOverController(window));
        layout.setTop(options.getOptions());

        gameover = new Scene(layout, 400, 400);

    }

    public Scene getView() {
        return gameover;
    }

}
