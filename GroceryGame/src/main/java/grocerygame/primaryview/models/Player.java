/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.primaryview.models;

import java.time.ZonedDateTime;


//Player class represents user of the game
public class Player {

    private String name;
    private int difficulty;
    private ZonedDateTime time;
    private int score;

    public Player(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
        this.time = ZonedDateTime.now();
        this.score = 0;
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

    public boolean setScore(int score) {
        if (score < 0) {
            return false;
        } else {
            this.score = score;
            return true;
        }

    }

    public int getScore() {
        return this.score;
    }

}
