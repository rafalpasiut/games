package com.rafalp.games.games.sudoku.board;

import com.rafalp.games.domain.CellEntity;
import com.rafalp.games.domain.RowEntity;
import com.rafalp.games.domain.SudokuEntity;
import com.rafalp.games.games.sudoku.creator.CellValueDTO;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
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

    public SudokuBoardWebDTO mapBoardToWebDTO(int[][] board, SudokuBoard solution){
        int[][] solutionArray = sudokuArrayFromBoard(solution);
        CellWebDTO[][] webBoard = new CellWebDTO[9][9];
        int i=0,j;
        for(int[] row : board){
            j=0;
            for(int cell : row){
                boolean isDraft = (board[i][j] != 0);
                webBoard[i][j] = new CellWebDTO(cell,solutionArray[i][j],isDraft,i,j);
                j++;
            }
            i++;
        }
        return new SudokuBoardWebDTO(webBoard);
    }

    public SudokuEntity sudokuWebToSudokuEntity(SudokuBoardWebDTO boardWebDTO){
        SudokuEntity sudoku = new SudokuEntity(boardWebDTO.getUserId(),new ArrayList<>());

        for(CellWebDTO[] row : boardWebDTO.getBoard()){
            sudoku.addRows(mapCellsRowToRowEntity(row));
        }
        return sudoku;
    }

    private RowEntity mapCellsRowToRowEntity(CellWebDTO[] cellRow){

        RowEntity rowEntity = new RowEntity();

        for(CellWebDTO cell : cellRow){
            rowEntity.addCell(mapWebCellToCellEntity(cell));
        }
        return rowEntity;
    }

    private CellEntity mapWebCellToCellEntity(CellWebDTO cellWebDTO){
        CellEntity cellEntity = new CellEntity();

        cellEntity.setValue(cellWebDTO.getValue());
        cellEntity.setSolution(cellWebDTO.getSolution());
        cellEntity.setRowNumber(cellWebDTO.getX());
        cellEntity.setColumnNumber(cellWebDTO.getY());
        cellEntity.setDraftNumber(cellWebDTO.isDraftNumber());

        return cellEntity;
    }
}
