package com.rafalp.games.web.rest;

import com.rafalp.games.games.sudoku.generator.SudokuGenerator;
import com.rafalp.games.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sudoku")
@CrossOrigin("*")
public class SudokuController {

    @Autowired
    private SudokuGenerator sudokuGenerator;

    @RequestMapping(method = RequestMethod.GET, value = "/init")
    public String inicializeSudokuGame(UserDTO user) {
        sudokuGenerator.nextBoard(45);
        return "hh";//sudokuGenerator.getRawData();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/new")
    public String generateNewGame(UserDTO user) {
        sudokuGenerator.nextBoard(45);
        return "kk";//sudokuGenerator.getRawData();
    }
}
