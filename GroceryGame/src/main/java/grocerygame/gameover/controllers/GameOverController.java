package grocerygame.gameover.controllers;

import grocerygame.database.PlayerDao;
import grocerygame.gameover.views.GameOverView;
import grocerygame.primaryview.models.Player;
import grocerygame.primaryview.views.PrimaryView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * GameOverController controls UI actions in the GameOverView.
 * 
 */
public class GameOverController {

    private GameOverView gameover;
    private Stage window;
    private Player player;

    public GameOverController(GameOverView gameoverview) throws Exception {
        this.gameover = gameoverview;
        this.player = gameoverview.getPlayer();
        this.window = gameoverview.getWindow();
        saveScore();
    }

    
    
    /**
     * Method to return back to primaryview
     * 
     */
    public void changeToPrimaryView() throws Exception {
        PrimaryView primaryview = new PrimaryView(window);
        window.setScene(primaryview.getView());
        window.show();
    }

    /**
     * Method to exit application.
     * 
     */
    public void exitGame(ActionEvent event) {
        Platform.exit();
    }

    /**
     * Method to calculate Players score and then add 
     * Player and score to the database.
     * 
     */
    public void saveScore() throws Exception {
        PlayerDao playerdao = new PlayerDao();
        player.calculateFinalScore();
        playerdao.create(player);
    }
}
