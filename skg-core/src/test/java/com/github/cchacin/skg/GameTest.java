package com.github.cchacin.skg;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GameTest implements WithAssertions {

    @Test
    void newGameStatus() throws Exception {
        final var game = new Game();

        assertThat(game.getGameState()).isEqualTo(
                GameState.builder()
                        .status(GameState.Status.NEW)
                        .rounds(List.of(
                                Round.builder().build(),
                                Round.builder().build(),
                                Round.builder().build(),
                                Round.builder().build(),
                                Round.builder().build(),
                                Round.builder().build(),
                                Round.builder().build(),
                                Round.builder().build(),
                                Round.builder().build(),
                                Round.builder().build()
                                )
                        )
                        .build()
        );
    }

    @Test
    void playerJoins() throws Exception {
        final var player = Player.builder().build();
        final var game = new Game(Deck.newUnsorted(), 1).join(player);

        assertThat(game.getGameState()).isEqualTo(
                GameState.builder()
                        .status(GameState.Status.NEW)
                        .addPlayers(player)
                        .rounds(List.of(Round.builder().build()))
                        .build()
        );
    }

    @Test
    void gameStarted() throws Exception {
        final var player = Player.builder().build();
        final var game = new Game(Deck.newUnsorted(), 1)
                .join(player)
                .start();

        assertThat(game.getGameState()).isEqualTo(
                GameState.builder()
                        .status(GameState.Status.ROUND_STARTED)
                        .addPlayers(player)
                        .rounds(List.of(Round.builder().putHands(player, List.of(new Card.Parrot(1))).build()))
                        .build()
        );
    }
}