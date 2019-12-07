package grocerygame.primaryview.views;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

//RankingListView displays ranking list of player who have played the game so
// far
public class RankingListView {

    private VBox rankingList;

    public RankingListView() {

        Label rankingTitle = new Label("Highest scoring players");
        rankingList = new VBox(rankingTitle);
        //access ranking list from database/file and set up list or just print
        // "no players yet!" if empty. Access to database/file not yet implemented.
        if (false) {
            //code here to add highest scoring players to the ranking list
        } else {
            Label noPlayers = new Label("No players yet!");
            rankingList.getChildren().add(noPlayers);
        }
        rankingList.setSpacing(10);

    }

    public VBox getView() {
        return rankingList;
    }

}
