package com.rafalp.games.repository;

import com.rafalp.games.domain.RowEntity;
import org.springframework.data.repository.CrudRepository;

public interface RowEntityDao extends CrudRepository<RowEntity, Integer>{

    @Override
    RowEntity save(RowEntity entity);
}
