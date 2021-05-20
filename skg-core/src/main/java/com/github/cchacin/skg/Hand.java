package com.github.cchacin.skg;

import io.vavr.collection.List;
import org.immutables.value.Value;

@Value.Immutable
public interface Hand {
    List<Card> cards();

    default Hand addCard(
            final Card card) {
        return Hand.builder()
                .from(this)
                .cards(cards().append(card))
                .build();
    }

    static Builder builder() {
        return new Builder();
    }

    class Builder extends HandInternalBuilder {
    }
}
