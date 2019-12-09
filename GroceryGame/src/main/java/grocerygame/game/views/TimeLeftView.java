package grocerygame.game.views;


import javafx.scene.control.Label;

/**
 * TimeLeftView is a class containing label which shows remaining time in the game
 * 
 */
public class TimeLeftView {

    private Label timeleft;
    private long givenTime;

    public TimeLeftView() {
        //time as milliseconds.
        givenTime = 30000;

        timeleft = new Label("Time left: " + calculateTimeLeft(givenTime));
    }
    /**
     * Method returns the TimeLEftView
     * @return timeleftview as Label.
     */
    public Label getView() {
        return timeleft;
    }
    
    /**
     * Method is used to refresh the timer.
     * @param time parameter time as time elapsed from the start of the game as milliseconds.
     * @return returns Label containing the updated time.
     */
    public Label refreshTimeLeft(long time) {
        timeleft.setText("Time left: " + calculateTimeLeft(time));
        return timeleft;
    }
    
    /**
     * Method is a utility function used to calculate how much time is remaining till the end of the game. Calculates 
     * time remaining by using timespent parameter. Then converts milliseconds(long) into integer and returns integer.
     * @param timespent parameter timespent as time elapsed from the start of the game as milliseconds.
     * @return returns remaining time in the game as integer.
     */
    public int calculateTimeLeft(long timespent) {
        return Math.round((givenTime - timespent) / 1000);
    }

}
