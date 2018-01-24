package com.rafalp.games.repository;

import com.rafalp.games.domain.SudokuEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface SudokuEntityDao extends CrudRepository<SudokuEntity, Long> {

    @Override
    @Transactional
    SudokuEntity save(SudokuEntity entity);

    SudokuEntity getSudokuEntitiesById(Long id);
}
