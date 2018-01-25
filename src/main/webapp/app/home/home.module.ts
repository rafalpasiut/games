import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {SudokuGameComponent} from '../layouts/sudoku-game/sudoku-game.component';
import {RpsGameComponent} from '../layouts/rps-game/rps-game.component';

import {GamesSharedModule} from '../shared';

import {HOME_ROUTE, HomeComponent} from './';
import {SudokuBoardComponent} from '../layouts/sudoku-game/sudoku-board/sudoku-board.component';
import {SudokuGameRequestsService} from '../layouts/sudoku-game/sudoku-game-requests.service';

@NgModule({
    imports: [
        GamesSharedModule,
        RouterModule.forChild([ HOME_ROUTE ])
    ],
    declarations: [
        HomeComponent,
        SudokuGameComponent,
        RpsGameComponent,
        SudokuBoardComponent
    ],
    entryComponents: [
    ],
    providers: [
        SudokuGameRequestsService
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GamesHomeModule {}
