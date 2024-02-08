package ru.netology.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Game {
    private HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    private Player findByName(String name) {
        return players.get(name);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);

        if (player1 == null) {
            throw new NotRegisteredException(
                    "Player" + playerName1 + " not registered"
            );
        }

        Player player2 = findByName(playerName2);

        if (player2 == null) {
            throw new NotRegisteredException(
                    "Player" + playerName2 + " not registered"
            );
        }
        return player1.compareTo(player2);
    }
}

