package com.rafalp.games.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "cells")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CellEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer value;
    private Integer solution;
    private Integer rowNumber;
    private Integer columnNumber;
    private boolean draftNumber;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name = "ROW_ID")
    private RowEntity row;
}
