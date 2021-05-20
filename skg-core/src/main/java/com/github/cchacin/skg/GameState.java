package com.github.cchacin.skg;

import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
public interface GameState {
    Status status();

    List<Player> players();

    List<Round> rounds();

    List<Card> currentPlay();

    static Builder builder() {
        return new Builder();
    }

    class Builder extends GameStateInternalBuilder {
    }

    enum Status {
        NEW,
        STARTED,
        ROUND_STARTED,
        ROUND_FINISHED,
        FINISHED
    }
}
