package com.rafalp.games.games.sudoku.board;

import com.rafalp.games.games.sudoku.creator.CellValueDTO;

public class SudokuMapper {

    public SudokuBoard boardFromArray(int[][] board){
        SudokuBoard sudokuBoard = new SudokuBoard();
        int i=1;
        for(int[] row : board){
            int j=1;
            for(int cellValue : row){
                sudokuBoard.setCell(new CellValueDTO(i,j,cellValue));
                j++;
            }
            i++;
        }
        return sudokuBoard;
    }

    public int[][] sudokuArrayFromBoard(SudokuBoard sudokuBoard){
        int[][] board = new int[9][9];

        sudokuBoard.getRows().stream().forEach(row -> {
            row.getCells().stream().forEach(cell -> {
                board[cell.getRowNumber()-1][cell.getColumnNumber()-1] = cell.getValue();
            });
        });
        return board;
    }
}
