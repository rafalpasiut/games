import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Cell} from "./sudoku-board/sudoku-board.component";

@Component({
    selector: 'jhi-sudoku-game',
    templateUrl: './sudoku-game.component.html',
    styleUrls: ['./sudoku-game.component.css']
})
export class SudokuGameComponent implements OnInit {

    newBoard: SudokuGenResponse;

    constructor(private http: HttpClient) {
    }

    ngOnInit() {
        this.init();
    }

    generateNew(): void {
        this.http.get<SudokuGenResponse>('http://localhost:8080/sudoku/new').subscribe((data) => {
            this.newBoard = data;
            console.log("FIRST");
            console.log(data);
            console.log("FIRST");
        });
    }

    init(): void {
        this.http.get<SudokuGenResponse>('http://localhost:8080/sudoku/init').subscribe((data) => {
            this.newBoard = data;
        });
    }
}

export interface SudokuGenResponse {
    board: Cell[][];
}
