package grocerygame.primaryview.models;

//Score handles counting how many items player collected and how much time
//he/she had remaining at the end and calculates score
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

    public int calculateScore() {
        if (cashier == true) {
            return (int) (timeRemaining / 1000) * difficulty + (items * 50) + 100;
        } else {
            return (int) (timeRemaining / 1000) * difficulty + (items * 50);
        }
    }

    public void updateTime(long timeSpent) {
        this.timeRemaining = this.timeTotal - timeSpent;
    }

    public void addItem() {
        this.items++;
    }

    public void addCashier() {
        this.cashier = true;
    }

    public boolean timeOver() {
        return timeRemaining < 0;
    }

}
