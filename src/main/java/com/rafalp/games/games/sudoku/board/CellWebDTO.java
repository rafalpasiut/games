package com.rafalp.games.games.sudoku.board;

import javax.persistence.Entity;


public class CellWebDTO {

    private int value;
    private int solution;
    private boolean isDraftNumber;
    private int x;
    private int y;

    public CellWebDTO(int value, int solution, boolean isDraftNumber, int x, int y) {
        this.value = value;
        this.solution = solution;
        this.isDraftNumber = isDraftNumber;
        this.x = x;
        this.y = y;
    }

    public int getValue() {
        return value;
    }

    public int getSolution() {
        return solution;
    }

    public boolean isDraftNumber() {
        return isDraftNumber;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
