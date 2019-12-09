package grocerygame.gameover.views;

import grocerygame.gameover.controllers.GameOverController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


 

/**
 * OptionsPanel for game end. Buttons for returning to main page and exiting
 * game.
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
    
    /**
     * Method returns the optionPanel.
     * @return returns the optionpanel as HBox
     */
    public HBox getOptions() {
        return options;
    }
    /**
     * Method gives access to other objects to the quit-button in the options.
     * @return returns the quit-button in the optionPanel
     */
    public Button getQuit() {
        return quit;
    }
    
    /**
     * Method gives access to other objects to the exit-button in the options.
     * @return returns the exit-button in the optionPanel
     */
    public Button getExit() {
        return quit;
    }
    
    /**
     * Method sets controller for the option panel.
     * @param controller parameter controller is a gameovercontroller
     */
    public void setController(GameOverController controller) {
        this.gameovercontroller = controller;

        quit.setOnAction(event -> {
            try {
                gameovercontroller.changeToPrimaryView();
            } catch (Exception ex) {
                Logger.getLogger(GameOverOptions.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        exit.setOnAction(event -> gameovercontroller.exitGame(event));
    }
}
