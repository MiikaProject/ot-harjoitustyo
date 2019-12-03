/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerygame.game.models;

import sun.misc.ObjectInputFilter;

/**
 *
 * @author miika1
 */
public class GameGrid {

    public Cell[][] grid;
    private Location shopper;
    private GroceryList grocerylist;
    private boolean gameover;

    public GameGrid(int x, int y, GroceryList groceryList) {
        grid = new Cell[y][x];
        this.grocerylist = groceryList;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Cell(i, j);
            }

        }

        shopper = new Location();
        grid[y - 1][x - 1].setCellType("S");
        shopper.setLocation(y - 1, x - 1);

        levelOne();

    }


    public void addCell(Cell cell) {
        grid[cell.getY()][cell.getX()] = cell;
    }

    public Location getShopper() {
        return shopper;
    }

    public Cell getCell(int y, int x) {
        return grid[y][x];
    }

    public void moveDownShopper() {
        if (shopper.getY() + 1 < grid.length && checkCell(shopper.getY() + 1, shopper.getX())) {
            grid[shopper.getY()][shopper.getX()].setCellType("O");
            shopper.setLocation(shopper.getY() + 1, shopper.getX());
            grid[shopper.getY()][shopper.getX()].setCellType("S");
        }

    }

    public void moveUpShopper() {
        if (shopper.getY() > 0 && checkCell(shopper.getY() - 1, shopper.getX())) {
            grid[shopper.getY()][shopper.getX()].setCellType("O");
            shopper.setLocation(shopper.getY() - 1, shopper.getX());
            grid[shopper.getY()][shopper.getX()].setCellType("S");
        }

    }

    public void moveLeftShopper() {
        if (shopper.getX() > 0 && checkCell(shopper.getY(), shopper.getX() - 1)) {
            grid[shopper.getY()][shopper.getX()].setCellType("O");
            shopper.setLocation(shopper.getY(), shopper.getX() - 1);
            grid[shopper.getY()][shopper.getX()].setCellType("S");
        }

    }

    public void moveRightShopper() {

        if (shopper.getX() + 1 < grid[0].length && checkCell(shopper.getY(), shopper.getX() + 1)) {
            grid[shopper.getY()][shopper.getX()].setCellType("O");
            shopper.setLocation(shopper.getY(), shopper.getX() + 1);
            grid[shopper.getY()][shopper.getX()].setCellType("S");
        }

    }

    public void levelOne() {
        
        for (int i = 5; i < 15; i++) {
            grid[0][i].setCellType("M");
        }

        for (int i = 3; i < 12; i++) {
            grid[i][15].setCellType("P");
            grid[i][16].setCellType("P");
        }

        for (int i = 2; i < 8; i++) {
            grid[i][0].setCellType("B");
        }

        for (int i = 10; i < 14; i++) {
            grid[i][0].setCellType("H");
        }

        for (int i = 3; i < 10; i++) {
            grid[i][4].setCellType("F");
        }

        for (int i = 3; i < 10; i++) {
            grid[i][5].setCellType("V");
        }

        for (int i = 3; i < 10; i++) {
            grid[i][8].setCellType("ME");
        }

        for (int i = 3; i < 10; i++) {
            grid[i][9].setCellType("FI");
        }

        for (int i = 3; i < 10; i++) {
            grid[i][19].setCellType("D");
        }

        for (int i = 0; i < 5; i++) {
            grid[grid.length - 1][i].setCellType("C");
            grid[grid.length - 2][i].setCellType("C");
        }

        for (int i = 10; i < 15; i++) {
            grid[grid.length - 4][i].setCellType("E");
            grid[grid.length - 5][i].setCellType("E");
        }

    }

    private boolean checkCell(int y, int x) {
        if (grid[y][x].getType().equals("M") | grid[y][x].getType().equals("P") | grid[y][x].getType().equals("L") | grid[y][x].getType().equals("F") | grid[y][x].getType().equals("R") | grid[y][x].getType().equals("B")
                | grid[y][x].getType().equals("C") | grid[y][x].getType().equals("E") | grid[y][x].getType().equals("V") | grid[y][x].getType().equals("D") | grid[y][x].getType().equals("ME")
                | grid[y][x].getType().equals("FI") | grid[y][x].getType().equals("H")) {

            if (!grocerylist.getGrocerylist().isEmpty()) {
                Grocery itemToBeRemove = null;
                for (Grocery grocery : grocerylist.getGrocerylist()) {

                    if (grocery.getCategory().equals(grid[y][x].getType())) {
                        itemToBeRemove = grocery;
                    }

                }
                grocerylist.remove(itemToBeRemove);
            } else {
                if (grid[y][x].getType().equals("C")) {
                    //System.out.println("DONE!");
                    gameover = true;
                }
            }

            return false;
        }
        return true;
    }

    public boolean gameover() {
        return gameover;
    }
}
