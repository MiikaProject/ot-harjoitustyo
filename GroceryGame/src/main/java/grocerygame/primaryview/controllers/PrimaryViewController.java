package grocerygame.primaryview.controllers;

import grocerygame.primaryview.models.Player;
import grocerygame.game.views.GameView;
import grocerygame.primaryview.views.SettingsView;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

//Controller for the PrimaryView
public class PrimaryViewController {

    private Stage window;

    public PrimaryViewController(Stage window) {
        this.window = window;
    }

    //Launch game
    public void changeToGame(Player player) throws Exception {
        GameView game = new GameView(player, window);
        window.setScene(game.getView());
        window.show();
    }

    //Method called when "Play" button is pressed, validates input then
    //changes to game
    public void startGame(SettingsView settings) throws Exception {
        TextField userField = settings.getUserField();
        Label errorField = settings.getErrorField();
        ToggleGroup difficulty = settings.getDifficulty();

        //validate username and difficulty
        if (userField.getText().equals("")) {
            errorField.setText("Give player name!");
        } else if (difficulty.getSelectedToggle() == null) {
            errorField.setText("Set difficulty!");
        } else {
            String playername = userField.getText();
            ToggleButton chosen = (ToggleButton) difficulty.getSelectedToggle();
            int chosenDifficulty = Integer.parseInt(chosen.getText());
            Player player = new Player(playername, chosenDifficulty);
            changeToGame(player);

        }

    }
}
