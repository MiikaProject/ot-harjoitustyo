/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame;
        
import grocerygame.game.views.GameView;
import grocerygame.primaryview.views.PrimaryView;
import javafx.application.Application;
import javafx.stage.Stage;

public class GroceryGame extends Application {
   

    @Override
    public void start(Stage window) throws Exception {
        
        //Launch the primarypage 
        window.setTitle("GroceryGame");
        window.setScene(new PrimaryView().getView());
        
        window.show();
    }
    
    

    public static void main(String[] args) {
        launch(GroceryGame.class);
    }

}
