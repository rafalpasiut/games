package com.rafalp.games.games.sudoku.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class CellWebDTO {

    private int value;
    private int solution;
    private Boolean draftNumber;
    private int x;
    private int y;

    public CellWebDTO(int value, int solution, boolean draftNumber, int x, int y) {
        this.value = value;
        this.solution = solution;
        this.draftNumber = draftNumber;
        this.x = x;
        this.y = y;
    }


}
