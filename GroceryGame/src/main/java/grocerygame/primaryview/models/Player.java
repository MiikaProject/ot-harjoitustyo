package grocerygame.primaryview.models;

import java.time.ZonedDateTime;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Player class is used to contain information regarging the current player. Player class has contains players name, games difficulty
 * and Score object. Score object is used to handle things regarding keeping the score. Player class is also a database model for the 
 * ORMLite ORM-extension.
 * 
 */

@DatabaseTable(tableName = "players")
public class Player implements Comparable<Player> {

    @DatabaseField(id = true)
    private Integer id;
    @DatabaseField()
    private String name;
    @DatabaseField()
    private int difficulty;
    @DatabaseField()
    private int finalScore;

    private Score score;


    public Player() {
    }

    public Player(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
        this.score = new Score(difficulty);
        this.finalScore = 0;
    }

    public Player(String name, int difficulty, int score) {
        this.name = name;
        this.difficulty = difficulty;
        this.score = new Score(difficulty);
        this.finalScore = 0;
    }

    
/**
 * Returns player's name.
 * @return player's name as string.
 */
    public String getName() {
        return this.name;
    }

/**
 * Returns chosen difficulty as int
 * 
 * @return chosen difficulty as int
 */    
    public int getDifficulty() {
        return this.difficulty;
    }

    /**
     * Player contains Score object which keeps track of the score.
     * @return Score object which keeps track of the score.
     */
    public Score getScore() {
        return this.score;
    }

    /**
     * Method calls Score objects  calculateScore()method which returns players score, then
     * it sets the finalScore to the returned score. 
     */
    public void calculateFinalScore() {
        this.finalScore = getScore().calculateScore();
    }

    /**
     * ToString method, format name, difficulty, score. 
     * 
     */
    @Override
    public String toString() {
        return "name:" + this.name + "::" + "difficulty:" + this.difficulty + "::" + "score:" + this.finalScore;
    }

    /**
     * Method used to compare player objects. Used to sort players by their score.
     * @param player Player to be compared.
     * @return int -1, 0, 1 depending on which player had higher score.
     */
    @Override
    public int compareTo(Player player) {
        return player.getFinalScore() - this.finalScore;
    }

/**
 * Returns players score at the end of the game
 * @return finalScore as int
 */
    public int getFinalScore() {
        return finalScore;
    }

}
