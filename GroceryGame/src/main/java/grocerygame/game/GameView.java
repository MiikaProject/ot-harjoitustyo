/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game;

import grocerygame.ui.PrimaryView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 *
 * @author miika1
 */
public class GameView {

    private String player;
    private int difficulty;
    private Scene game;
    private Map<KeyCode, Boolean> pressedButtons;

    //Build view
    public GameView(String player, int difficulty) {
        pressedButtons = new HashMap<>();
        this.player = player;
        this.difficulty = difficulty;

        GridPane layout = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(75);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(25);
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(25);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(75);
        layout.getColumnConstraints().addAll(column1,column2);
        layout.getRowConstraints().addAll(row1,row2);
        
        
        
        Button quit = new Button("Return");
        quit.setOnAction((event -> {
            changeToPrimaryView(event);
        }));
        Button exit = new Button("Exit");
        exit.setOnAction(event -> Platform.exit());
        
        Label items = new Label("Items remaining:");
        Label score = new Label("Time:");
        
        //make hbox for options and make them not toggleable with arrowkeys
        HBox options = new HBox(quit, exit, items, score);
        options.setSpacing(5);
        
        options.setFocusTraversable(true);
        
        layout.add(options, 0, 0);
        
        
        //Items
        ArrayList<String> remainingitems = new ArrayList();
        String milk = "Maito";
        String chicken = "Kana";
        remainingitems.add(milk);
        remainingitems.add(chicken);
        
        VBox listItems = new VBox();
        for(String item : remainingitems){
            listItems.getChildren().add(new Label(item));
        }
        
        layout.add(listItems, 1, 0);

        Pane gameField = new Pane();
        
        

        Shopper shopper = new Shopper();
        shopper.setLocation(300, 265);
        gameField.getChildren().add(shopper.getShopper());
        gameField.getChildren().add(new Shelf(0,0).getShelf());
        gameField.getChildren().add(new Shelf(100,0).getShelf());
        gameField.getChildren().add(new Shelf(225, 0).getShelf());
        
        
        layout.add(gameField,0, 1);
        game = new Scene(layout, 400, 400);

        game.setOnKeyPressed((event -> {
            for(Node shelf: gameField.getChildren()){
                System.out.println(shelf);
            }
            shopper.printLocation();
            KeyCode key = event.getCode();
            if(key==KeyCode.DOWN){
                shopper.moveDown();
            } else if (key==KeyCode.UP){
                shopper.moveUp();
            } else if (key==KeyCode.LEFT){
                shopper.moveLeft();
            } else if (key==KeyCode.RIGHT){
                shopper.moveRight();
            }
            
        }));

        
        

    }

    //get gameview
    public Scene getView() {

        return game;
    }

    //method to return back to primaryview
    public void changeToPrimaryView(ActionEvent event) {
        PrimaryView primaryview = new PrimaryView();
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(primaryview.getView());
        window.show();
    }

}
