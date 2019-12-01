/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game.views;

import grocerygame.game.controllers.GameController;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author miika1
 */
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
    
    public HBox getOptions(){
        return options;
    }
    
    public Button getQuit(){
        return quit;
    }
    
    public Button getExit(){
        return quit;
    }
    
    public void setController(GameController controller){
        this.gamecontroller = controller;
        quit.setOnAction(event -> gamecontroller.changeToPrimaryView(event));
        exit.setOnAction(event -> gamecontroller.exitGame(event));
    }
    
    
    
    
}
