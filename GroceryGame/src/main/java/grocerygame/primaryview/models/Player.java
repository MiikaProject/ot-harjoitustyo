/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.primaryview.models;

import java.time.ZonedDateTime;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

//Player class represents user of the game
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

    private ZonedDateTime time;

    public Player() {
    }

    public Player(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
        this.time = ZonedDateTime.now();
        this.score = new Score(difficulty);
        this.finalScore = 0;
    }

    public Player(String name, int difficulty, int score) {
        this.name = name;
        this.difficulty = difficulty;
        this.score = new Score(difficulty);
        this.time = ZonedDateTime.now();
        this.finalScore = 0;
    }

    public ZonedDateTime getTime() {
        return this.time;
    }

    public String getName() {
        return this.name;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    public Score getScore() {
        return this.score;
    }

    public void calculateFinalScore() {
        this.finalScore = getScore().calculateScore();
    }

    @Override
    public String toString() {
        return "name:" + this.name + "::" + "difficulty:" + this.difficulty + "::" + "score:" + this.finalScore;
    }

    @Override
    public int compareTo(Player player) {
        return player.getFinalScore() - this.finalScore;
    }

    public int getFinalScore() {
        return finalScore;
    }

}
