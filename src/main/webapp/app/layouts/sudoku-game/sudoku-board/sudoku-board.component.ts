import {Component, OnInit} from '@angular/core';

@Component({
    selector: 'jhi-sudoku-board',
    templateUrl: './sudoku-board.component.html',
    styleUrls: ['./sudoku-board.component.css']
})
export class SudokuBoardComponent implements OnInit {

    board: Cell[][];
    draftBoard: Cell[][];
    solution: Cell[][];

    constructor() {
    }

    ngOnInit() {
        this.fillSampleSudoku();
    }

    fillSampleSudoku(): void {
        this.board = [];
        for (let i = 0; i < 9; i++) {
            this.board[i] = [];
            for (let j = 0; j < 9; j++) {
                this.board[i][j] = new Cell(-1, true);
            }
        }
    }

    init(): void{

    }

    valueEntered(event, i, j) {
        console.log('key pressed');
        const charCode = (event.which) ? event.which : event.keyCode;
        console.log(charCode);
        if (charCode > 48 && charCode < 58) {
            this.setCellValue(Number(String.fromCharCode(charCode)), i, j);
        } else if (charCode > 96 && charCode < 106) {
            this.setCellValue(Number(String.fromCharCode(charCode - 48)), i, j);
        } else if (charCode === 8 || charCode === 46 || charCode === 32) {
            console.log('backspace');
            this.setCellValue(0, i, j);
        } else if (charCode === 9 || charCode === 38 || charCode === 39) {
            return true; //TAB
        }
        return false;
    }

    setCellValue(value, i, j): void {
        console.log(value);
        this.board[i][j].setValue(value);
    }
}

export class Cell {
    value: number;
    isDraftNumber: boolean;

    constructor(value, isDraftNumber) {
        this.value = value;
        this.isDraftNumber = isDraftNumber;
    }

    public setValue(value): void {
        this.value = value;
    }

    public getValueAsString(): string {
        return this.value === 0 ? '' : this.value.toString();
    }
}
