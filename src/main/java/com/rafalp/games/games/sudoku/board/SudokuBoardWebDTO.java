package com.rafalp.games.games.sudoku.board;

import javax.persistence.Entity;


public class SudokuBoardWebDTO {

    private CellWebDTO[][] board;

    public SudokuBoardWebDTO(CellWebDTO[][] board) {
        this.board = board;
    }

    public CellWebDTO[][] getBoard() {
        return board;
    }

}
