package com.github.cchacin.skg;

import java.util.Set;

public record Player(
        String name,
        Set<Card> cards) {
}
