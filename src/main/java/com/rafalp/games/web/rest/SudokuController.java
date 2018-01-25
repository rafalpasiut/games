package com.rafalp.games.web.rest;

import com.rafalp.games.domain.SudokuCellEntity;
import com.rafalp.games.games.sudoku.board.SudokuBoardWebDTO;
import com.rafalp.games.games.sudoku.board.SudokuMapper;
import com.rafalp.games.games.sudoku.generator.SudokuGenerator;
import com.rafalp.games.repository.SudokuRepositoryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sudoku")
@CrossOrigin("*")
public class SudokuController {

    @Autowired
    private SudokuGenerator sudokuGenerator;
    @Autowired
    private SudokuRepositoryController repositoryController;
    @Autowired
    private SudokuMapper sudokuMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/getSaved")
    public SudokuBoardWebDTO initializeSudokuGame(@RequestParam Long userId) {
        List<SudokuCellEntity> cells = repositoryController.readSudokuCellEntities(userId);
        if(cells.isEmpty()){
            sudokuGenerator.nextBoard(50);
            return sudokuGenerator.getSudokuDTO();
        }else{
            return sudokuMapper.mapCellsEntitiesToWebBoardDto(cells);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/new")
    public SudokuBoardWebDTO generateNewGame() {
        sudokuGenerator.nextBoard(50);
        return sudokuGenerator.getSudokuDTO();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/saveSudoku", consumes = MediaType.APPLICATION_JSON_VALUE)
    public SudokuBoardWebDTO saveSudoku(@RequestBody SudokuBoardWebDTO sudoku) {
        repositoryController.saveSudoku(sudokuMapper.sudokuWebToSudokuCellEntity(sudoku));
        return sudoku;
    }
}
