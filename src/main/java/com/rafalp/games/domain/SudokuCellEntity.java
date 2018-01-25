package com.rafalp.games.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "SUDOKU_CELLS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SudokuCellEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Integer value;
    private Integer solution;
    private Integer rowNumber;
    private Integer columnNumber;
    private Boolean draftNumber;

}
