package grocerygame.game.views;

import grocerygame.game.models.GameGrid;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;


/**
 * GameDisplay renders GameGrid.
 * 
 */
public class GameDisplay {

    private Scene game;
    private GameGrid gamegrid;
    private GridPane gameview;

    public GameDisplay(GameGrid gamegrid) {
        gameview = new GridPane();
        game = new Scene(gameview, 40, 30);

        this.gamegrid = gamegrid;

        for (int i = 0; i < gamegrid.grid.length; i++) {
            for (int j = 0; j < gamegrid.grid[i].length; j++) {

                gameview.add(gamegrid.grid[i][j].getImage(), j, i);
            }
        }

    }
    
    /**
     * Method gives access to the view.
     * @return returns GameDisplay as Node.
     */
    public Node getView() {
        return gameview;
    }
    
    /**
     * Method returns the gamegrid which contains the actual location of cells in the game.
     * @return returns GameGrid which is [][] array.
     */
    public GameGrid getGrid() {
        return this.gamegrid;
    }

    /**
     * Method used to refresh the display of the game.
     * @return returns the updated status of the game UI.
     */
    public Node redrawGrid() {
        for (int i = 0; i < gamegrid.grid.length; i++) {
            for (int j = 0; j < gamegrid.grid[i].length; j++) {
                gameview.add(gamegrid.grid[i][j].getImage(), j, i);
            }
        }
        return gameview;
    }
}
