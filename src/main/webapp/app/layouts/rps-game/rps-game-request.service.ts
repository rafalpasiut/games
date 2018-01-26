import {Injectable} from '@angular/core';
import {FightResult} from "./rps-game.component";
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class RpsGameRequestService {

    constructor(private http: HttpClient) {
    }

    public fight(champion: string): Observable<FightResult> {
        return this.http.get<FightResult>('http://localhost:8080/rps/fightWithAI?champion=' + champion).map((data) => {
            return data;
        });
    }

}
