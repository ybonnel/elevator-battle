/*
 * Copyright 2013- Yan Bonnel
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.ybonnel.services;

import fr.ybonnel.model.PlayerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.RestAdapter;

import java.util.ArrayList;
import java.util.List;

public class BattleService {

    private static final Logger logger = LoggerFactory.getLogger(BattleService.class);

    private PlayerService playerService;

    public BattleService() {
        playerService = new RestAdapter.Builder().setServer("http://elevator.code-story.net/").build().create(PlayerService.class);
    }

    public List<String> getPseudos() {
        List<String> pseudos = new ArrayList<>();
        for (PlayerInfo player : playerService.leaderboard()) {
            pseudos.add(player.getPseudo());
        }
        return pseudos;
    }


    public List<PlayerInfo> getPlayersInfo(String pseudo1, String pseudo2) {
        List<PlayerInfo> result = new ArrayList<>();

        PlayerInfo player1 = null;
        PlayerInfo player2 = null;

        for (PlayerInfo player : playerService.leaderboard()) {
            if (pseudo1.equals(player.getPseudo())) {
                player1 = player;
            }
            if (pseudo2.equals(player.getPseudo())) {
                player2 = player;
            }
        }

        if (player1 != null) {
            result.add(player1);
        }
        if (player2 != null) {
            result.add(player2);
        }

        return result;
    }
}
