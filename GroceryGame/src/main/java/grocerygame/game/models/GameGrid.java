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

    public void printGrid() {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println("");

        }
        System.out.println();
    }

    public void addCell(Cell cell) {
        grid[cell.getY()][cell.getX()] = cell;
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
        for (int i = 2; i < 7; i++) {
            grid[0][i].setCellType("M");
        }

        for (int i = 3; i < 8; i++) {
            grid[i][grid[i].length - 1].setCellType("P");
        }

        for (int i = 0; i < 5; i++) {
            grid[i][0].setCellType("B");
        }

        for (int i = 3; i < 7; i++) {
            grid[i][4].setCellType("F");
        }

        for (int i = 3; i < 7; i++) {
            grid[i][5].setCellType("R");
        }

        for (int i = 0; i < 3; i++) {
            grid[grid.length - 1][i].setCellType("C");
        }

    }

    private boolean checkCell(int y, int x) {
        if (grid[y][x].getType().equals("M") | grid[y][x].getType().equals("P") | grid[y][x].getType().equals("L") | grid[y][x].getType().equals("F") | grid[y][x].getType().equals("R") | grid[y][x].getType().equals("B")
                | grid[y][x].getType().equals("C")) {

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
