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
        this.setDraftAndBoard(sudoku.board);
    }

    setDraftAndBoard(board: Cell[][]) {
        this.board = [];
        for (let i = 0; i < 9; i++) {
            this.board[i] = [];
            for (let j = 0; j < 9; j++) {
                this.board[i][j] = new Cell(board[i][j].value, board[i][j].solution, board[i][j].x, board[i][j].y, board[i][j].draftNumber);
            }
        }
        console.log(this.board);
        this.draftBoard = [];
        for (let i = 0; i < 9; i++) {
            this.draftBoard[i] = [];
            for (let j = 0; j < 9; j++) {
                this.draftBoard[i][j] = new Cell(board[i][j].value, board[i][j].solution, board[i][j].x, board[i][j].y, board[i][j].draftNumber);
            }
        }
    }

    fillSudokuWithDummyData(): void {
        this.board = [];
        for (let i = 0; i < 9; i++) {
            this.board[i] = [];
            for (let j = 0; j < 9; j++) {
                this.board[i][j] = new Cell(0, 0, i, j, true);
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
    x: number;
    y: number;
    draftNumber: boolean;

    constructor(value, solution, x, y, isDraftNumber) {
        this.value = value;
        this.solution = solution;
        this.x = x;
        this.y = y;
        this.draftNumber = isDraftNumber;
    }


    public setValue(value): void {
        this.value = value;
    }

    public getValueAsString(): string {
        return this.value === 0 ? '' : this.value.toString();
    }

    public isEditable(): boolean {
        return !this.draftNumber;
    }

    getColorStyle(): String {
        if (this.draftNumber) {
            return "draft-cell";
        } else if (this.value === this.solution) {
            return "ok-cell";
        } else {
            return "wrong-cell";
        }
    }

    getBorderStyle(): string {
        let style: string = '';
        if ((this.y + 1) % 3 === 0) {
            style += " right-border-cell ";
        }
        if ((this.x + 1) % 3 === 0) {
            style += " bottom-border-cell ";
        }
        return style;
    }
}
