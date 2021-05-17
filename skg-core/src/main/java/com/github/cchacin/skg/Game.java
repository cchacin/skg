package com.github.cchacin.skg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class Game {
    private static final int ROUNDS = 10;
    private static final int MAX_NUMBER_OF_PLAYERS = 6;

    private final List<Player> players = new ArrayList<>(MAX_NUMBER_OF_PLAYERS);
    private final AtomicInteger currentRound = new AtomicInteger(1);
    private final Deck deck;

    public Game(
            final Deck deck) {
        this.deck = deck;
    }

    public void join(
            final Player player) {
        this.players.add(player);
    }

    public void start() {
        this.players.forEach(player -> {
            deck.deal().ifPresentOrElse(
                    card -> player.cards().add(card),
                    null
            );
        });
        System.out.println(this.players);
    }

    public static void main(
            final String[] args) {
        final var game = new Game(Deck.create());
        game.join(new Player("carlos", new HashSet<>()));
        game.join(new Player("ube", new HashSet<>()));
        game.start();
    }

}
