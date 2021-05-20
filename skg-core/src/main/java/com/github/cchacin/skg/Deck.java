package com.github.cchacin.skg;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.List;

import java.util.Optional;
import java.util.function.Function;

public record Deck(
        List<Card> cards) {

    public Deck(
            final List<Card> cards,
            final Type type) {
        this(type.getFunction().apply(cards));
    }

    public Deck() {
        this(generateCards(), Type.SHUFFLED);
    }

    private enum Type {
        UNSORTED(Function.identity()),
        SHUFFLED(List::shuffle);

        private final Function<List<Card>, List<Card>> function;

        Type(final Function<List<Card>, List<Card>> function) {
            this.function = function;
        }

        public Function<List<Card>, List<Card>> getFunction() {
            return function;
        }
    }

    public static Deck newUnsorted() {
        return new Deck(generateCards(), Type.UNSORTED);
    }

    public static Deck newUnsorted(
            final List<Card> cards) {
        return new Deck(cards);
    }

    public static Deck newShuffled() {
        return new Deck();
    }

    public static Deck newShuffled(
            final List<Card> cards) {
        return new Deck(cards);
    }

    private static List<Card> generateCards() {
        return List.of(
                new Card.Parrot(1),
                new Card.Parrot(2),
                new Card.Parrot(3),
                new Card.Parrot(4),
                new Card.Parrot(5),
                new Card.Parrot(6),
                new Card.Parrot(7),
                new Card.Parrot(8),
                new Card.Parrot(9),
                new Card.Parrot(10),
                new Card.Parrot(11),
                new Card.Parrot(12),
                new Card.Parrot(13),
                new Card.Parrot(14),
                new Card.Chest(1),
                new Card.Chest(2),
                new Card.Chest(3),
                new Card.Chest(4),
                new Card.Chest(5),
                new Card.Chest(6),
                new Card.Chest(7),
                new Card.Chest(8),
                new Card.Chest(9),
                new Card.Chest(10),
                new Card.Chest(11),
                new Card.Chest(12),
                new Card.Chest(13),
                new Card.Chest(14),
                new Card.JollyRoger(1),
                new Card.JollyRoger(2),
                new Card.JollyRoger(3),
                new Card.JollyRoger(4),
                new Card.JollyRoger(5),
                new Card.JollyRoger(6),
                new Card.JollyRoger(7),
                new Card.JollyRoger(8),
                new Card.JollyRoger(9),
                new Card.JollyRoger(10),
                new Card.JollyRoger(11),
                new Card.JollyRoger(12),
                new Card.JollyRoger(13),
                new Card.JollyRoger(14),
                new Card.Map(1),
                new Card.Map(2),
                new Card.Map(3),
                new Card.Map(4),
                new Card.Map(5),
                new Card.Map(6),
                new Card.Map(7),
                new Card.Map(8),
                new Card.Map(9),
                new Card.Map(10),
                new Card.Map(11),
                new Card.Map(12),
                new Card.Map(13),
                new Card.Map(14),
                new Card.Escape(),
                new Card.Escape(),
                new Card.Escape(),
                new Card.Escape(),
                new Card.Escape(),
                new Card.Pirate(),
                new Card.Pirate(),
                new Card.Pirate(),
                new Card.Pirate(),
                new Card.Pirate(),
                new Card.Mermaid(),
                new Card.Mermaid(),
                new Card.Tigress(),
                new Card.SkullKing()
        );
    }

    public Tuple2<Optional<Card>, Deck> deal() {
        return Tuple.of(
                this.cards().isEmpty() ?
                        Optional.empty() :
                        Optional.of(this.cards().head()),
                new Deck(this.cards().tail())
        );
    }

    public Tuple2<java.util.List<Card>, Deck> deal(
            final int numberOfCards) {
        return Tuple.of(
                this.cards().subSequence(0, numberOfCards).asJava(),
                new Deck(this.cards().subSequence(numberOfCards))
        );
    }
}
