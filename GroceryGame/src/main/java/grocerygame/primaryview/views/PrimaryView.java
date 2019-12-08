/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.primaryview.views;

import grocerygame.primaryview.controllers.PrimaryViewController;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

//The main page
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

    public Scene getView() {
        return view;
    }

}
