package com.rafalp.games.games.sudoku.board;

public class SudokuBoardWebDTO {

    private int[][] board;
    private int[][] solution;

    public SudokuBoardWebDTO(int[][] board, int[][] solution) {
        this.board = board;
        this.solution = solution;
    }

    public int[][] getBoard() {
        return board;
    }

    public int[][] getSolution() {
        return solution;
    }
}
