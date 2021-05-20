package com.github.cchacin.skg;

import org.immutables.value.Value;


@Value.Immutable
public interface Player {
    String name();

    static Builder builder() {
        return new Builder();
    }

    class Builder extends PlayerInternalBuilder {
    }
}
