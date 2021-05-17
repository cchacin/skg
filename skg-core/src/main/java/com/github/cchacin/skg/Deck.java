package com.github.cchacin.skg;

import java.util.Collections;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.IntStream;

public record Deck(
        Stack<Card> cards) {
    public Deck(final Stack<Card> cards) {
        this.cards = new Stack<>();
        this.cards.addAll(cards);
    }

    public Deck() {
        this(generateCards());
        Collections.shuffle(this.cards());
    }

    public static Deck create() {
        return new Deck();
    }

    public static Deck create(
            final Stack<Card> cards) {
        return new Deck(cards);
    }

    private static Stack<Card> generateCards() {
        final var cards = new Stack<Card>();
        IntStream.range(1, 15)
                .forEach(value -> {
                    cards.push(new Card.Parrot(value));
                    cards.push(new Card.Chest(value));
                    cards.push(new Card.Map(value));
                    cards.push(new Card.JollyRoger(value));
                });
        IntStream.range(1, 6)
                .forEach(value -> {
                    cards.push(new Card.Escape());
                    cards.push(new Card.Pirate());
                });
        IntStream.range(1,2)
                .forEach(value -> cards.push(new Card.Tigress()));
        IntStream.range(1,2)
                .forEach(value -> cards.push(new Card.SkullKing()));
        IntStream.range(1,3)
                .forEach(value -> cards.push(new Card.Mermaid()));
        return cards;
    }

    public Optional<Card> deal() {
        return this.cards().isEmpty() ?
                Optional.empty() :
                Optional.of(this.cards().pop());
    }
}
