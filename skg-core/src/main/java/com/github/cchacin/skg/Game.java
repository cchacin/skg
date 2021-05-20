package com.github.cchacin.skg;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public final class Game {
    private static final int ROUNDS = 10;
    private static final int MAX_NUMBER_OF_PLAYERS = 6;

    private final AtomicInteger currentRound = new AtomicInteger(1);
    private Deck deck;
    private GameState.Builder gameState = GameState.builder().status(GameState.Status.NEW);

    public Game(
            final Deck deck,
            final int numberOfRounds) {
        this.deck = deck;
        IntStream.range(0, numberOfRounds)
                .forEach(i -> this.gameState.addRounds(Round.builder().build()));
    }

    public Game() {
        this(Deck.newShuffled(), ROUNDS);
    }

    public Game(
            final GameState gameState) {
        this();
        this.gameState = this.gameState.from(gameState);
    }

    public Game join(
            final Player player) {
        if (GameState.Status.NEW.equals(this.gameState.build().status()) &&
                this.gameState.build().players().size() < MAX_NUMBER_OF_PLAYERS) {
            this.gameState.addPlayers(player);
        } else {
            System.out.println("Game.join -> NOT ALLOWED");
        }
        return this;
    }

    public Game start() {
        this.gameState = this.gameState.status(GameState.Status.STARTED);
        return this.newRound();
    }

    private Game deal(
            final int round) {
        this.gameState.build().players().forEach(player -> {
            final var roundIndex = round - 1;
            final var dealResult = this.deck.deal(round);
            final var rounds = new ArrayList<>(this.gameState.build().rounds());
            final var roundToUpdate = rounds.get(roundIndex);
            rounds.remove(roundIndex);
            rounds.add(roundIndex, Round.builder()
                    .from(roundToUpdate)
                    .putHands(player, dealResult._1)
                    .build());
            this.gameState.rounds(rounds);
            this.deck = dealResult._2;
        });
        return this;
    }

    public Game newRound() {
        final var currentStatus = this.gameState.build().status();
        if (GameState.Status.STARTED.equals(currentStatus) ||
                GameState.Status.ROUND_FINISHED.equals(currentStatus)) {
            this.gameState.status(GameState.Status.ROUND_STARTED);
            return this.deal(this.currentRound.get());
        } else {
            System.out.println("NOT STARTED // NO-OP");
        }
        return this;
    }

    public Game bet(
            final Player player,
            final int bet) {
        if (GameState.Status.ROUND_STARTED.equals(this.gameState.build().status())) {
            final var roundNumber = this.currentRound.get();
            final var roundIndex = roundNumber - 1;
            final var rounds = new ArrayList<>(this.gameState.build().rounds());
            final var round = rounds.get(roundIndex);
            rounds.remove(roundIndex);
            rounds.add(roundIndex, Round.builder()
                    .from(round)
                    .putAllBets(new HashMap<>(rounds.get(roundNumber).bets()))
                    .putBets(player, bet)
                    .build());
            this.gameState.rounds(rounds);
        } else {
            System.out.println("NO ROUND STARTED // NO-OP");
        }
        return this;
    }

    public GameState getGameState() {
        return this.gameState.build();
    }
}
