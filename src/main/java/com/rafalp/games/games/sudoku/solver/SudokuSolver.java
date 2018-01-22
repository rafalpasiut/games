package com.rafalp.games.games.sudoku.solver;

import com.rafalp.games.games.sudoku.board.SudokuBoard;
import com.rafalp.games.games.sudoku.exceptions.NoSolutionException;

public interface SudokuSolver {

    SudokuBoard solve(SudokuBoard sudokuToSolve) throws NoSolutionException, CloneNotSupportedException;
}
