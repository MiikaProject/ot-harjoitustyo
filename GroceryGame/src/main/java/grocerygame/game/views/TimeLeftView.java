package grocerygame.game.views;

//Shows remaining time in the game
import javafx.scene.control.Label;

public class TimeLeftView {

    private Label timeleft;
    private long givenTime;

    public TimeLeftView() {
        givenTime = 30000;

        timeleft = new Label("Time left: " + calculateTimeLeft(givenTime));
    }

    public Label getView() {
        return timeleft;
    }

    public Label refreshTimeLeft(long time) {
        timeleft.setText("Time left: " + calculateTimeLeft(time));
        return timeleft;
    }

    public int calculateTimeLeft(long timespent) {
        return Math.round((givenTime - timespent) / 1000);
    }

}
