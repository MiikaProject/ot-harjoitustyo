/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game.views;

import grocerygame.game.models.GameGrid;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

/**
 *
 * @author miika1
 */
public class GameView2 {

    private Scene game;
    private GameGrid gamegrid;
    private GridPane gameview;

    public GameView2(GameGrid gamegrid) {
        gameview = new GridPane();
        game = new Scene(gameview, 40, 30);

        this.gamegrid = gamegrid;

        for (int i = 0; i < gamegrid.grid.length; i++) {
            for (int j = 0; j < gamegrid.grid[i].length; j++) {

                gameview.add(gamegrid.grid[i][j].getImage(), j, i);
            }
        }

    }

    //get gameview
    public Node getView() {

        return gameview;
    }

    public GameGrid getGrid() {
        return this.gamegrid;
    }

    public Node redrawGrid() {
        for (int i = 0; i < gamegrid.grid.length; i++) {
            for (int j = 0; j < gamegrid.grid[i].length; j++) {

                gameview.add(gamegrid.grid[i][j].getImage(), j, i);
            }
        }

        return gameview;
    }
}
