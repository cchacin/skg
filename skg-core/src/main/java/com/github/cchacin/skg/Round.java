package com.github.cchacin.skg;

import org.immutables.value.Value;

import java.util.List;
import java.util.Map;


@Value.Immutable
public interface Round {
    Map<Player, List<Card>> hands();

    Map<Player, Integer> bets();

    static Builder builder() {
        return new Builder();
    }

    class Builder extends RoundInternalBuilder {
    }
}
