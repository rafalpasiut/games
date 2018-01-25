package com.rafalp.games.games.rps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RPSFightResult {

    String userChampion;
    String opponentChampion;
    String fightResult;
    String fightMessage;
}
