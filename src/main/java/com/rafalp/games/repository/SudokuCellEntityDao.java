package com.rafalp.games.repository;

import com.rafalp.games.domain.SudokuCellEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SudokuCellEntityDao extends CrudRepository<SudokuCellEntity, Integer> {

    @Override
    SudokuCellEntity save(SudokuCellEntity entity);

    SudokuCellEntity findByUserIdAndColumnNumberAndRowNumber(Long userId, Integer column, Integer row);

    List<SudokuCellEntity> findAllByUserId(Long userId);
}
