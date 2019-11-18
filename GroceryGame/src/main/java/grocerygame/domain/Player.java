/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.domain;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.print.attribute.standard.DateTimeAtCompleted;

/**
 *
 * @author miika
 */
public class Player {

    private String name;
    private int level;
    private ZonedDateTime time;
    private int score;

    public Player(String name, int level) {
        this.name = name;
        this.level = level;
        this.time = ZonedDateTime.now();
        this.score = 0;
    }

    public ZonedDateTime getTime() {
        return this.time;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
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
