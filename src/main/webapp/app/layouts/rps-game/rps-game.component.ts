import {Component, OnInit} from '@angular/core';
import {RpsGameRequestService} from "./rps-game-request.service";

@Component({
    selector: 'jhi-rps-game',
    templateUrl: './rps-game.component.html',
    styleUrls: [
        './rps-game.component.css'
    ]
})
export class RpsGameComponent implements OnInit {

    maxGamesCount = 3;
    winCount = 0;
    looseCount = 0;
    fightResultText = '';
    fightMessage = '';
    playerChampion = '';
    opponentChampion = '';
    gameFinished = false;
    gameWon = false;

    constructor(private rpsRequestServices: RpsGameRequestService) {
    }

    ngOnInit() {
    }

    fight(champion: string): void {
        this.clearIfFinished();
        this.playerChampion = champion;
        this.rpsRequestServices.fight(champion).subscribe(result => {
            this.fightMessage = result.fightMessage;
            this.fightResultText = result.fightResult;
            this.opponentChampion = result.opponentChampion;
            if (result.fightResult === 'WIN') {
                this.winCount++;
            } else if (result.fightResult === "LOOSE") {
                this.looseCount++;
            }
            this.checkIfGameFinished();
            if(this.gameFinished){
                this.fightResultText = this.gameWon ? 'Game won!' : 'Game lost';
                this.fightMessage = this.fightMessage + ' ' + this.fightResultText;
            }
        });
    }

    checkIfGameFinished(): void {
        if (this.winCount >= this.maxGamesCount) {
            this.gameFinished = true;
            this.gameWon = true;
        } else if (this.looseCount >= this.maxGamesCount) {
            this.gameFinished = true;
            this.gameWon = false;
        }
    }

    clearIfFinished():void{
        if(this.gameFinished){
            this.gameFinished = false;
            this.clearGame();
        }
    }

    clearGame(): void {
        this.looseCount = 0;
        this.winCount = 0;
        this.fightResultText = '';
        this.fightMessage = '';
        this.playerChampion = '';
        this.opponentChampion = '';
    }

}

export interface FightResult {
    userChampion: string;
    opponentChampion: string;
    fightResult: string;
    fightMessage: string;
}
