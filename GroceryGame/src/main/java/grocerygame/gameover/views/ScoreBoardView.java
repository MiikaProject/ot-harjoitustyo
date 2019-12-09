package grocerygame.gameover.views;

import grocerygame.primaryview.models.Player;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
/**
 * ScoreBoardView is a class which displays players score after game has ended.
 * It is a component in the GameOverView.
 * 
 */
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

    /**
     * Method returns the view as GridPane JavaFX object
     * @return view as GridPane JavaFX object
     */
    public GridPane getView() {
        return scoreboard;
    }

}
