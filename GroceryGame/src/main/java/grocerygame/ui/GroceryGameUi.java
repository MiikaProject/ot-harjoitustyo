/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class GroceryGameUi extends Application {

    @Override
    public void start(Stage window) throws Exception {

        //Settings
        //Player name
        
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
            
            //validate username
            if(userfield.getText().equals("")){
                errorfield.setText("Give player name!");
                return;
                
            } else {
                String playername = userfield.getText();
                System.out.println(playername);
            }
            
            
            //Validate chosen difficulty level
            if (levelgroup.getSelectedToggle() == null) {
                errorfield.setText("Select difficulty!");
            } else {
                ToggleButton chosen = (ToggleButton) levelgroup.getSelectedToggle();
                int difficulty = Integer.parseInt(chosen.getText());
                System.out.println(difficulty);
            }

        }));
        //Build the section of the Ui
        VBox settings = new VBox(settingsTitle, user, userfield, level, levels,errorfield, play);
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
        Scene view = new Scene(grid);
        window.setTitle("GroceryGame");
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(GroceryGameUi.class);
    }

}
