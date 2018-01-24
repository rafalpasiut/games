package com.rafalp.games.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "rows")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(targetEntity = CellEntity.class, mappedBy = "row", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CellEntity> cells = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sudoku_id")
    private SudokuEntity sudoku;

    public void addCell(CellEntity cellEntity){
        cells.add(cellEntity);
        cellEntity.setRow(this);
    }
}
