package com.rafalp.games.games.rps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RPSFightResult {

    String userChampion;
    String opponentChampion;
    String fightResult;
    String fightMessage;

    public RPSFightResult(String userChampion, String opponentChampion, String fightResult, String fightMessage) {
        this.userChampion = userChampion;
        this.opponentChampion = opponentChampion;
        this.fightResult = fightResult;
        this.fightMessage = fightMessage;
    }
}
