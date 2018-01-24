package com.rafalp.games.repository;

import com.rafalp.games.domain.SudokuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SudokuRepositoryController {

    @Autowired
    private SudokuEntityDao sudokuEntityDao;

    public void saveSudoku(SudokuEntity sudokuEntity){
        sudokuEntityDao.save(sudokuEntity);
    }

    public SudokuEntity getSudoku(Long userId){
        return sudokuEntityDao.getSudokuEntitiesById(userId);
    }
}
