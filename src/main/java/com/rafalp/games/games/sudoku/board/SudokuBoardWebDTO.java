package com.rafalp.games.games.sudoku.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SudokuBoardWebDTO {

    private CellWebDTO[][] board;
    private Long userId = (long)-1;

    public SudokuBoardWebDTO(CellWebDTO[][] board) {
        this.board = board;
    }
}
