package com.rafalp.games.games.sudoku.generator;

import com.rafalp.games.games.sudoku.board.SudokuBoard;
import com.rafalp.games.games.sudoku.board.SudokuCell;

import java.util.Random;
import java.util.stream.IntStream;

public class SudokuGenerator {

    private int[][] board;

    public int[][] nextBoard(int difficulty) {
        board = new int[SudokuBoard.SUDOKU_SIZE][SudokuBoard.SUDOKU_SIZE];
        nextCell(0, 0);
        makeHoles(difficulty);
        return board;
    }

    public boolean nextCell(int x, int y) {
        int nextX = x;
        int nextY = y;
        int[] toCheck = IntStream.range(1, SudokuBoard.SUDOKU_SIZE + 1).toArray();
        Random random = new Random();
        int tmp;
        int current;
        int top = toCheck.length;

        for (int i = top - 1; i > 0; i--) {
            current = random.nextInt(i);
            tmp = toCheck[current];
            toCheck[current] = toCheck[i];
            toCheck[i] = tmp;
        }

        for (int aToCheck : toCheck) {
            if (legalMove(x, y, aToCheck)) {
                board[x][y] = aToCheck;
                if (x == 8) {
                    if (y == 8)
                        return true;
                    else {
                        nextX = 0;
                        nextY = y + 1;
                    }
                } else {
                    nextX = x + 1;
                }
                if (nextCell(nextX, nextY))
                    return true;
            }
        }
        board[x][y] = 0;
        return false;
    }

    private boolean legalMove(int x, int y, int current) {
        for (int i = 0; i < SudokuBoard.SUDOKU_SIZE; i++) {
            if (current == board[x][i])
                return false;
        }
        for (int i = 0; i < SudokuBoard.SUDOKU_SIZE; i++) {
            if (current == board[i][y])
                return false;
        }
        int cornerX = 0;
        int cornerY = 0;
        if (x > 2)
            if (x > 5)
                cornerX = 6;
            else
                cornerX = 3;
        if (y > 2)
            if (y > 5)
                cornerY = 6;
            else
                cornerY = 3;
        for (int i = cornerX; i < 10 && i < cornerX + 3; i++)
            for (int j = cornerY; j < 10 && j < cornerY + 3; j++)
                if (current == board[i][j])
                    return false;
        return true;
    }


    public void makeHoles(int holesToMake) {
        /* We define difficulty as follows:
            Easy: 32+ clues (49 or fewer holes)
			Medium: 27-31 clues (50-54 holes)
			Hard: 26 or fewer clues (54+ holes)
			This is human difficulty, not algorighmically (though there is some correlation)
		*/
        double remainingSquares = Math.pow(SudokuBoard.SUDOKU_SIZE, 2);
        double remainingHoles = (double) holesToMake;

        for (int i = 0; i < SudokuBoard.SUDOKU_SIZE; i++)
            for (int j = 0; j < SudokuBoard.SUDOKU_SIZE; j++) {
                double holeChance = remainingHoles / remainingSquares;
                if (Math.random() <= holeChance) {
                    board[i][j] = SudokuCell.EMPTY_CELL_VALUE;
                    remainingHoles--;
                }
                remainingSquares--;
            }
    }

    public void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + "  ");
            System.out.println();
        }
        System.out.println();
    }

    public void printRaw() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                if (board[i][j] != SudokuCell.EMPTY_CELL_VALUE) {
                    System.out.print((i + 1) + "," + (j + 1) + "," + board[i][j] + ",");
                }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SudokuGenerator sg = new SudokuGenerator();
        sg.nextBoard(45);
        sg.print();
        sg.printRaw();
    }
}
