package com.rafalp.games.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "SUDOKU_CELLS")
public class SudokuCellEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;
    private Long userId;
    private Integer value;
    private Integer solution;
    private Integer rowNumber;
    private Integer columnNumber;
    private Boolean draftNumber;

    public SudokuCellEntity() {
    }

    public SudokuCellEntity(Long userId, Integer value, Integer solution, Integer rowNumber, Integer columnNumber, Boolean draftNumber) {
        this.userId = userId;
        this.value = value;
        this.solution = solution;
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.draftNumber = draftNumber;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getSolution() {
        return solution;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public Integer getColumnNumber() {
        return columnNumber;
    }

    public Boolean getDraftNumber() {
        return draftNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setSolution(Integer solution) {
        this.solution = solution;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setColumnNumber(Integer columnNumber) {
        this.columnNumber = columnNumber;
    }

    public void setDraftNumber(Boolean draftNumber) {
        this.draftNumber = draftNumber;
    }
}
