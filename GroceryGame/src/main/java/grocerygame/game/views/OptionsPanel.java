package grocerygame.game.views;

import grocerygame.game.controllers.GameController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

//Options panel shows buttons for quitting game and returning to main page
public class OptionsPanel {

    HBox options;
    Button quit;
    Button exit;
    GameController gamecontroller;

    public OptionsPanel() {
        options = new HBox();
        quit = new Button("Return");
        exit = new Button("Exit");
        options.getChildren().add(quit);
        options.getChildren().add(exit);
        options.setSpacing(5);
        options.setFocusTraversable(true);

    }

    public HBox getOptions() {
        return options;
    }

    public Button getQuit() {
        return quit;
    }

    public Button getExit() {
        return quit;
    }

    public void setController(GameController controller) {
        this.gamecontroller = controller;
        quit.setOnAction(event -> {
            try {
                gamecontroller.changeToPrimaryView(event);
            } catch (Exception ex) {
                Logger.getLogger(OptionsPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        exit.setOnAction(event -> gamecontroller.exitGame(event));
    }

}
