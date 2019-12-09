package grocerygame.primaryview.controllers;

import grocerygame.primaryview.models.Player;
import grocerygame.game.views.GameView;
import grocerygame.primaryview.views.SettingsView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * PrimaryViewController is a controller class for the PrimaryView window
 * 
 */
public class PrimaryViewController {

    private Stage window;

    public PrimaryViewController(Stage window) {
        this.window = window;
    }

    /**
     * Method is called when the change from PrimaryView to GameView is done.
     * @param player Current Player as argument
     * 
     */
    public void changeToGame(Player player) throws Exception {
        GameView game = new GameView(player, window);
        window.setScene(game.getView());
        window.show();
    }


    /**
     * Method is called when player has pressed "Play" button. First method validates
     * username and difficulty fields. Then is no validation error occurs, it will create
     * a new Player and call changeToGame method to switch screen to game.
     * @param settings method takes settingView  as argument to have access to Textfields.
     * @throws Exception 
     */
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
