/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.ui;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GroceryGameUi extends Application {

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("GroceryGame");
        
        //Settings
        Label user = new Label("Enter name");
        TextField userfield = new TextField();
        Label level = new Label("Difficulty Level");
        HBox levels = new HBox(new Button("1"),new Button("2"),new Button("3"));
        Button play = new Button("Play!");
        
        
        
        VBox settings = new VBox(user,userfield,level,levels,play);
        settings.setSpacing(10);
        
        
        
        //Ranking list
        Label rankingTitle = new Label("Highest scoring players");
        //here should access ranking list from database/file and set up list or just print
        // no players played yet if empty 
        VBox rankinglist = new VBox(rankingTitle);
        
        
        rankinglist.setSpacing(10);
                
                
        //Set up the grid for background
        HBox grid = new HBox(rankinglist,settings);
        grid.setSpacing(15);
        
        
        Scene view = new Scene(grid);
        
        window.setScene(view);
        
        window.show();
    }

    public static void main(String[] args) {
        launch(GroceryGameUi.class);
    }

}
