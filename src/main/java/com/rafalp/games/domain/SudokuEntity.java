package com.rafalp.games.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "SUDOKU")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SudokuEntity {

    @Id
    @JoinColumn(name="user_id")
    private Long id;

    @OneToMany(targetEntity = RowEntity.class, mappedBy = "sudoku", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<RowEntity> rows = new ArrayList<>();

    public void addRows(RowEntity rowEntity){
        rows.add(rowEntity);
        rowEntity.setSudoku(this);
    }

}
