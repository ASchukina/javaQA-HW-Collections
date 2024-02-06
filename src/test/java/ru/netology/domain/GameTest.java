package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();

    Player player1 = new Player(1, "Vasya", 15);
    Player player2 = new Player(2, "Vitya", 20);
    Player player3 = new Player(3, "Misha", 25);
    Player player4 = new Player(4, "Kolya", 15);
    Player player5 = new Player(5, "Dima", 40);

    @Test
    public void shouldFindUnregisteredFirstPlayer() {

        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Masha", "Vitya");
        });
    }

    @Test
    public void shouldFindUnregisteredSecondPlayer() {

        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Vasya", "Masha");
        });
    }


    @Test
    public void whenFirstPlayerWins() {

        game.register(player3);
        game.register(player4);

        Assertions.assertEquals(1, game.round(player3.getName(), player4.getName()));
    }

    @Test
    public void whenSecondPlayerWins() {

        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(2, game.round("Vasya", "Vitya"));
    }

    @Test
    public void whenDraw() {

        game.register(player1);
        game.register(player4);

        Assertions.assertEquals(0, game.round("Vasya", "Kolya"));
    }

}
