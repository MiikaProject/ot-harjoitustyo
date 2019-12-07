package grocerygame.primaryview.views;

import grocerygame.primaryview.controllers.PrimaryViewController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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

    public VBox getView() {
        return this.settings;
    }

    public void setController(PrimaryViewController controller) {
        this.controller = controller;
        play.setOnAction(event -> controller.startGame(this));
    }

    public TextField getUserField() {
        return userField;
    }

    public ToggleGroup getDifficulty() {
        return difficulty;
    }

    public Label getErrorField() {
        return errorField;
    }
    
    
    
    

    
    
    
    
    

}
