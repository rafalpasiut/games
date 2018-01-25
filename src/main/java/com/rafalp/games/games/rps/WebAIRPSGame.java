package com.rafalp.games.games.rps;

import com.rafalp.games.games.rps.exception.CantCreateChampionException;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@NoArgsConstructor
public class WebAIRPSGame extends Game {

    public RPSFightResult play(String userChampion) throws CantCreateChampionException {

        Champion playerChampion = createChampionFromString(userChampion);
        Champion aIChampion = randomChampion();
        FightResult fightResult = fight(playerChampion, aIChampion);
        String message = gameMaster.fightResult(fightResult, playerChampion, aIChampion);

        return new RPSFightResult(playerChampion.getName(), aIChampion.getName(), fightResult.toString(), message);
    }

    private Champion createChampionFromString(String champion) throws CantCreateChampionException {

        champion = "com.rafalp.games.games.rps." + champion;
        try {
            Class<Champion> championObject = (Class<Champion>) Class.forName(champion);
            return championObject.newInstance();
        } catch (Exception e) {
            throw new CantCreateChampionException("Cant create champion. " + champion + " not found.");
        }
    }

}
