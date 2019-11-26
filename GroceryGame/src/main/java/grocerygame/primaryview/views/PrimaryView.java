/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.primaryview.views;

import grocerygame.game.views.GameView;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
    
/**
 *
 * @author miika1
 */
public class PrimaryView {

    private Scene view;

    public PrimaryView() {
        Label settingsTitle = new Label("Settings");
        Label user = new Label("Enter name");
        TextField userfield = new TextField();

        //Level difficulty
        ToggleGroup levelgroup = new ToggleGroup();
        Label level = new Label("Choose difficulty");
        ToggleButton levelOne = new ToggleButton("1");
        ToggleButton levelTwo = new ToggleButton("2");
        ToggleButton levelThree = new ToggleButton("3");
        levelgroup.getToggles().addAll(levelOne, levelTwo, levelThree);
        HBox levels = new HBox(levelOne, levelTwo, levelThree);
        levels.setSpacing(10);

        //Error field
        Label errorfield = new Label();

        //Check chosen difficulty, username and start game
        Button play = new Button("Play!");
        play.setOnAction((event -> {
            String playername = "";
            //validate username
            if (userfield.getText().equals("")) {
                errorfield.setText("Give player name!");
                return;

            } else {
                playername = userfield.getText();
                System.out.println(playername);
            }

            //Validate chosen difficulty level
            int difficulty = 0;
            if (levelgroup.getSelectedToggle() == null) {
                errorfield.setText("Select difficulty!");
            } else {
                ToggleButton chosen = (ToggleButton) levelgroup.getSelectedToggle();
                difficulty = Integer.parseInt(chosen.getText());
                System.out.println(difficulty);
            }

            //call method to launch game
            changeToGame(event, playername, difficulty);

        }));

        //Build the settings section of the Ui
        VBox settings = new VBox(settingsTitle, user, userfield, level, levels, errorfield, play);
        settings.setSpacing(10);

        //Ranking list
        Label rankingTitle = new Label("Highest scoring players");
        VBox rankinglist = new VBox(rankingTitle);
        //access ranking list from database/file and set up list or just print
        // "no players yet!" if empty. Access to database/file not yet implemented.
        if (false) {
            //code here to add highest scoring players to the ranking list
        } else {
            Label noPlayers = new Label("No players yet!");
            rankinglist.getChildren().add(noPlayers);
        }
        rankinglist.setSpacing(10);

        //Set up the layout
        HBox grid = new HBox(rankinglist, settings);
        grid.setSpacing(15);

        //Build the scene and display it
        view = new Scene(grid, 400, 400);
    }

    public Scene getView() {

        return view;
    }

    //Launch game
    public void changeToGame(ActionEvent event, String name, int level) {
        GameView game = new GameView(name, level);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(game.getView());
        window.show();
    }
}
