package com.rafalp.games.repository;

import com.rafalp.games.domain.CellEntity;
import org.springframework.data.repository.CrudRepository;

public interface CellEntityDao extends CrudRepository<CellEntity, Integer> {

    @Override
    CellEntity save(CellEntity entity);
}
