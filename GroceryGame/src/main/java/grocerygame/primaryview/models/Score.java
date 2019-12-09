package grocerygame.primaryview.models;

/**
 * Score handles counting how many items player collected and how much time
 * he/she had remaining at the end of the game. Then score is calculated by
 * those variables and extra score will be rewarded if player made it to cashier
 * before time ended.
 *
 */
public class Score {

    private int items;
    private long timeRemaining;
    private long timeTotal;
    private boolean cashier;
    private int difficulty;

    public Score(int difficulty) {
        items = 0;
        this.timeTotal = 30000;
        this.timeRemaining = timeTotal;
        cashier = false;
        this.difficulty = difficulty;
    }

    /**
     * Returns the score at the end of the game.
     *
     * @return int score, the score at the end of the game.
     */
    public int calculateScore() {
        if (cashier == true) {
            return (int) (timeRemaining / 1000) * difficulty + (items * 50) + 100;
        } else {
            return (int) (timeRemaining / 1000) * difficulty + (items * 50);
        }
    }

    /**
     * Method updates timeremaining in the game based on timespent already in
     * game
     *
     * @param timeSpent method parameter is long time spent so far in the game
     */
    public void updateTime(long timeSpent) {
        this.timeRemaining = this.timeTotal - timeSpent;
        if (this.timeRemaining < 0) {
            this.timeRemaining = 0;
        }
    }

    /**
     * Method increments items collected in game. Method is called after a item
     * is removed from grocerylist.
     */
    public void addItem() {
        this.items++;
    }

    /**
     * Method switches boolean cashier to true. Method is called after player
     * reaches cashier. Cashier true gives player extra points at the end of the
     * game.
     */
    public void addCashier() {
        this.cashier = true;
    }

    /**
     * Method returns true if game time has ended and false if there is still
     * time left.
     *
     * @return returns boolean timeremaning < 0
     */
    public boolean timeOver() {
        return timeRemaining <= 0;
    }

    /**
     * Method returns number of collected items so far.
     *
     * @return number of items collected as integer
     */
    public int getItems() {
        return items;
    }

    /**
     * Sets difficulty to param
     *
     * @param difficulty is new difficulty
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isCashier() {
        return cashier;
    }

    public long getTimeTotal() {
        return timeTotal;
    }

    public long getTimeRemaining() {
        return timeRemaining;
    }

}
