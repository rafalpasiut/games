import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'jhi-sudoku-game',
  templateUrl: './sudoku-game.component.html',
  styleUrls: ['./sudoku-game.component.css']
})
export class SudokuGameComponent implements OnInit {

  constructor( private http: HttpClient) { }

  ngOnInit() {
  }

    generateNew():void {
        this.http.get('http://localhost:8080/sudoku/init').subscribe(data => {
            console.log(data); // using the HttpClient instance, http to call the API then subscribe to the data and display to console
        });
    }
}
