package ru.netology.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    private Player findByName(String name) {
        for (Player player : players) {
            if (Objects.equals(player.getName(), name)) {
                return player;
            }
        }
        return null;
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

