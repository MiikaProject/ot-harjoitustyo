package grocerygame.primaryview.views;

import grocerygame.primaryview.controllers.PrimaryViewController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * 
 * SettingsView class generates UI in which user can choose his player name 
 * and difficulty of the game before starting the game
 */



public class SettingsView {

    private VBox settings;
    private PrimaryViewController controller;
    private Button play;
    private TextField userField;
    private ToggleGroup difficulty;
    private Label errorField;

    public SettingsView() {

        Label settingsTitle = new Label("Settings");
        Label user = new Label("Enter name");
        userField = new TextField();

        //ToggleGroup to choose difficulty
        difficulty = new ToggleGroup();
        Label level = new Label("Choose difficulty");
        ToggleButton levelOne = new ToggleButton("1");
        ToggleButton levelTwo = new ToggleButton("2");
        ToggleButton levelThree = new ToggleButton("3");
        difficulty.getToggles().addAll(levelOne, levelTwo, levelThree);
        HBox levels = new HBox(levelOne, levelTwo, levelThree);
        levels.setSpacing(10);

        //Error field for displaying validation errors
        errorField = new Label();

        //Play button
        play = new Button("Play!");
        //Build the settings section of the Ui
        settings = new VBox(settingsTitle, user, userField, level, levels, errorField, play);
        settings.setSpacing(10);
    }

    /**
     * 
     * getView() method return a VBox javafx component containing the UI
     */
    public VBox getView() {
        return this.settings;
    }

    /**
     * setController() is used to set controller to the SettingsView panel
     * 
     */
    public void setController(PrimaryViewController controller)  {
        this.controller = controller;
        play.setOnAction(event -> {
            try {
                controller.startGame(this);
            } catch (Exception ex) {
                Logger.getLogger(SettingsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    /**
     * getUserField() method returns the userField javafx TextField component. This method 
     * is used by the controller to get access of the TextField.
     * 
     */
    
    public TextField getUserField() {
        return userField;
    }
    
    /**
     * Method returns the difficulty ToggleGroup. The togglegroup is used to 
     * choose difficulty of the game before entering the game. Method is used by the controller
     * to get access to the togglegroup.
     * 
     */

    public ToggleGroup getDifficulty() {
        return difficulty;
    }

    /**
     * Method is used by the controller to get access of the Label "ErrorField". Errorfield is used to 
     * display validation errors.
     * 
     */
    public Label getErrorField() {
        return errorField;
    }

}
