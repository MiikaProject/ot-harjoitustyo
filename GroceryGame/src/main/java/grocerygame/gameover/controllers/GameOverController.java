package grocerygame.gameover.controllers;

import grocerygame.database.PlayerDao;
import grocerygame.gameover.views.GameOverView;
import grocerygame.primaryview.models.Player;
import grocerygame.primaryview.views.PrimaryView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

//Controller to handle action that happen after game ends
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

    //method to return back to primaryview
    public void changeToPrimaryView() throws Exception {
        PrimaryView primaryview = new PrimaryView(window);
        window.setScene(primaryview.getView());
        window.show();
    }

    //Exit game
    public void exitGame(ActionEvent event) {
        Platform.exit();
    }

    //Add player and score to database
    public void saveScore() throws Exception {
        PlayerDao playerdao = new PlayerDao();
        player.calculateFinalScore();
        playerdao.create(player);
    }
}
