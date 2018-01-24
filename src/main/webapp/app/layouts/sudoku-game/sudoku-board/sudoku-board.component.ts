import {Component, Input, OnInit} from '@angular/core';
import {SudokuGenResponse} from '../sudoku-game.component';

@Component({
    selector: 'jhi-sudoku-board',
    templateUrl: './sudoku-board.component.html',
    styleUrls: ['./sudoku-board.component.css']
})
export class SudokuBoardComponent implements OnInit {


    board: Cell[][];
    draftBoard: Cell[][];

    @Input() public newSudokuResponse: SudokuGenResponse;

    constructor() {
    }

    ngOnInit() {

    }

    ngOnChanges(change) {
        this.createNewSudoku(this.newSudokuResponse);
    }


    createNewSudoku(sudoku: SudokuGenResponse): void {
        console.log(sudoku);
        this.setDraftAndBoard(sudoku.board, sudoku.solution);
    }

    setDraftAndBoard(board: number[][], solution: number[][]) {
        this.board = [];
        let isSet: boolean;
        for (let i = 0; i < 9; i++) {
            this.board[i] = [];
            for (let j = 0; j < 9; j++) {
                isSet = board[i][j] === 0 ? false : true;
                this.board[i][j] = new Cell(board[i][j], isSet, solution[i][j], i, j);
            }
        }

        this.draftBoard = [];
        for (let i = 0; i < 9; i++) {
            this.draftBoard[i] = [];
            for (let j = 0; j < 9; j++) {
                isSet = board[i][j] === 0 ? false : true;
                this.draftBoard[i][j] = new Cell(board[i][j], isSet, solution[i][j], i, j);
            }
        }
    }

    fillSudokuWithDummyData(): void {
        this.board = [];
        for (let i = 0; i < 9; i++) {
            this.board[i] = [];
            for (let j = 0; j < 9; j++) {
                this.board[i][j] = new Cell(0, true, 0, i, j);
            }
        }
    }

    init(): void {

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
            return true;
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
    solution: number;
    isDraftNumber: boolean;
    x: number;
    y: number;

    constructor(value, isDraftNumber, solution, x, y) {
        this.value = value;
        this.isDraftNumber = isDraftNumber;
        this.solution = solution;
        this.x = x;
        this.y = y;
    }

    public setValue(value): void {
        this.value = value;
    }

    public getValueAsString(): string {
        return this.value === 0 ? '' : this.value.toString();
    }

    public isEditable(): boolean {
        return !this.isDraftNumber;
    }

    getColorStyle(): String {
        if (this.isDraftNumber) {
            return "draft-cell";
        } else if (this.value === this.solution) {
            return "ok-cell";
        } else {
            return "wrong-cell";
        }
    }

    getBorderStyle(): string {
        let style:string ='';
        if ((this.y+1) % 3 === 0) {
            style+=" right-border-cell ";
        }
        if((this.x+1) % 3 === 0){
            style+=" bottom-border-cell ";
        }
        console.log(style);
        return style;
    }
}
