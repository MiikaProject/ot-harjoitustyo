package grocerygame.primaryview.views;

import grocerygame.database.PlayerDao;
import grocerygame.primaryview.models.Player;
import java.util.Collections;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

//RankingListView displays ranking list of player who have played the game so
// far
public class RankingListView {

    private VBox rankingList;

    public RankingListView() throws Exception {

        Label rankingTitle = new Label("Highest scoring players");
        rankingList = new VBox(rankingTitle);

        //access ranking list from database/file and set up list or just print
        // "no players yet!" if empty.
        PlayerDao playerdao = new PlayerDao();
        List<Player> players = playerdao.getAll();
        Collections.sort(players);
        if (!players.isEmpty()) {

            if (players.size() > 5) {
                for (int i = 0; i < 5; i++) {
                    Player player = players.get(i);
                    String label = player.getName() + "    " + player.getFinalScore();
                    rankingList.getChildren().add(new Label(label));
                }
            } else {
                for (Player player : players) {
                    String label = player.getName() + "    " + player.getFinalScore();
                    rankingList.getChildren().add(new Label(label));
                }
            }

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
