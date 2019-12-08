package grocerygame.gameover.views;

import grocerygame.primaryview.models.Player;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ScoreBoardView {

    private GridPane scoreboard;
    private Player player;

    public ScoreBoardView(Player player) {
        this.player = player;

        scoreboard = new GridPane();
        scoreboard.add(new Label(), 0, 0);
        scoreboard.add(new Label("GAMEOVER"), 4, 4);
        scoreboard.add(new Label("YOUR SCORE WAS   "), 4, 5);
        scoreboard.add(new Label("" + player.getScore().calculateScore()), 5, 5);

    }

    public GridPane getView() {
        return scoreboard;
    }

}
