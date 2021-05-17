package com.github.cchacin.skg;

public interface Card {
    interface Character
            extends Special {
    }

    record Chest(
            int rank)
            implements Standard {
    }

    record Escape()
            implements Special {
    }

    record JollyRoger(
            int rank)
            implements Trump {
    }

    record Map(
            int rank)
            implements Standard {
    }

    record Mermaid()
            implements Character {
    }

    interface Numbered
            extends Card {
        int rank();
    }

    record Parrot(
            int rank)
            implements Standard {
    }

    record Pirate()
            implements Character {
    }

    record SkullKing()
            implements Character {
    }

    interface Special
            extends Card {
    }

    interface Standard
            extends Numbered {
    }

    record Tigress()
            implements Character {
    }

    interface Trump
            extends Numbered {
    }
}
