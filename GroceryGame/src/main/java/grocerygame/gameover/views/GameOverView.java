package grocerygame.gameover.views;

import javafx.scene.Scene;
import javafx.stage.Stage;
import grocerygame.gameover.controllers.GameOverController;
import grocerygame.primaryview.models.Player;
import javafx.scene.layout.GridPane;

/**
 * GameOverView displays score at the end of the game and contains options
 * panel which allows player to return to main window or exit the game.
 * 
 */
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
    /**
     * Method returns the view.
     * @return the GameOverView as Scene JavaJX object
     */
    public Scene getView() {
        return gameover;
    }
    
    /**
     * Method gives access to the Stage.
     * @return returns the stage object.
     */
    public Stage getWindow() {
        return window;
    }
    
    /**
     * Method gives access to the current Player.
     * @return returns current Player object.
     */
    public Player getPlayer() {
        return player;
    }

}
