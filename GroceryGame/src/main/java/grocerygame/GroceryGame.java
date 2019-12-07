package grocerygame;

import grocerygame.primaryview.views.PrimaryView;
import javafx.application.Application;
import javafx.stage.Stage;

public class GroceryGame extends Application {

    @Override
    public void start(Stage window) throws Exception {

        //Launch the primarypage 
        window.setTitle("GroceryGame");
        window.setScene(new PrimaryView(window).getView());

        window.show();
    }

    public static void main(String[] args) {
        launch(GroceryGame.class);
    }

}
