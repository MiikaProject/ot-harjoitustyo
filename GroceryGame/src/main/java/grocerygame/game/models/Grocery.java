/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game.models;

/**
 *
 * @author miika1
 */
public class Grocery {

    private String name;
    private String category;



    public Grocery(String name, String category) {
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Category: " + category;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    
    
    

}
