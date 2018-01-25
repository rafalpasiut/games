import {Component, OnInit} from '@angular/core';
import {Cell} from "./sudoku-board/sudoku-board.component";
import {SudokuGameRequestsService} from "./sudoku-game-requests.service";
import {JhiEventManager} from "ng-jhipster";

@Component({
    selector: 'jhi-sudoku-game',
    templateUrl: './sudoku-game.component.html',
    styleUrls: ['./sudoku-game.component.css']
})
export class SudokuGameComponent implements OnInit {

    newBoard?: SudokuGenResponse;
    loggedUserId: number;

    constructor(private sudokuRequest: SudokuGameRequestsService,
                private eventManager: JhiEventManager) {

    }

    ngOnInit() {
        this.registerAuthenticationSuccess();
        this.init();
    }

    generateNew(hardLevel: number): void {
        this.sudokuRequest.generateNew(hardLevel).subscribe(
            data => this.newBoard = data
        );
    }

    init(): void {
        this.sudokuRequest.getSavedSudoku().then(observable => observable.subscribe(
            data => {
                this.newBoard = data;
                console.log(data);
            }
        ));
    }

    registerAuthenticationSuccess() {
        this.eventManager.subscribe('authenticationSuccess', (message) => {
            console.log('kdjskdjsk');
            this.init();
        });
    }
}

export interface SudokuGenResponse {
    board: Cell[][];
    userId: number;
}
