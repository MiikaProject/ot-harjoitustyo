/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.gameover.views;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import grocerygame.gameover.controllers.GameOverController;
import grocerygame.primaryview.models.Player;
import javafx.scene.layout.GridPane;

//The main window for GameOver
public class GameOverView {

    private Scene gameover;
    Stage window;
    Player player;

    public GameOverView(Stage window, Player player) throws Exception {
        this.player = player;
        this.window = window;
        this.player = player;
        GridPane layout = new GridPane();

        //Create optionPanel and give it to gameovercontroller
        GameOverOptions options = new GameOverOptions(window);
        options.setController(new GameOverController(this));
        layout.add(options.getOptions(), 0, 0);

        ScoreBoardView scoreboard = new ScoreBoardView(player);
        layout.add(scoreboard.getView(), 10, 10);

        gameover = new Scene(layout, 400, 400);

    }

    public Scene getView() {
        return gameover;
    }

    public Stage getWindow() {
        return window;
    }

    public Player getPlayer() {
        return player;
    }

}
