/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.ui;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author miika1
 */
public class GameView {

    private String player;
    private int difficulty;

    public GameView(String player, int difficulty) {
        this.player = player;
        this.difficulty = difficulty;
    }
    
    //method to build the view and return it
    public Scene getView(){
        
        BorderPane layout = new BorderPane();
        Button quit = new Button("Quit");
        quit.setOnAction((event->{
            changeToPrimaryView(event);
        }));
        layout.setRight(quit);
        layout.setCenter(new Label("Game not implemented yet!"));
        Scene game = new Scene(layout,200,200);
        
        return game;
    }
    
    
    //method to return back to primaryview
    public void changeToPrimaryView(ActionEvent event){
        PrimaryView primaryview = new PrimaryView();
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(primaryview.getView());
        window.show();
    }
    
}
