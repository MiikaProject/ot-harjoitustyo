package grocerygame.primaryview.views;

import grocerygame.primaryview.controllers.PrimaryViewController;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * PrimaryView is the main page of the application. It is used to display the ranking list
 * of previous players and settings panel in which player can insert his/her name and preferred
 * difficulty before the game starts.
 * 
 */
public class PrimaryView {

    private Scene view;
    private Stage window;
    PrimaryViewController controller;

    public PrimaryView(Stage window) throws Exception {

        this.window = window;
        controller = new PrimaryViewController(this.window);

        SettingsView settings = new SettingsView();
        settings.setController(controller);
        RankingListView rankinglist = new RankingListView();

        //Set up the layout
        HBox grid = new HBox(rankinglist.getView(), settings.getView());
        grid.setSpacing(15);

        //Build the scene and display it
        view = new Scene(grid, 400, 400);
    }

    /**
     * Returns the PrimaryView page as javafx Scene object.
     * 
     */
    public Scene getView() {
        return view;
    }

}
