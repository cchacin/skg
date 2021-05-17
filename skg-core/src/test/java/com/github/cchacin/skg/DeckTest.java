package com.github.cchacin.skg;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class DeckTest implements WithAssertions {

    @Test
    void newDeckShouldNotReturnWhenDeal() throws Exception {
        assertThat(Deck.create().deal()).isNotEmpty();
    }

    @Test
    void newDeckShouldHave14Parrots() throws Exception {
        assertThat(
                Deck.create().cards()
                        .stream()
                        .filter(card -> card instanceof Card.Parrot)
        ).hasSize(14);
    }

    @Test
    void newDeckShouldHave14MapCards() throws Exception {
        assertThat(
                Deck.create().cards()
                        .stream()
                        .filter(card -> card instanceof Card.Map)
        ).hasSize(14);
    }

    @Test
    void newDeckShouldHave14ChestCards() throws Exception {
        assertThat(
                Deck.create().cards()
                        .stream()
                        .filter(card -> card instanceof Card.Chest)
        ).hasSize(14);
    }

    @Test
    void newDeckShouldHave14JollyRogerCards() throws Exception {
        assertThat(
                Deck.create().cards()
                        .stream()
                        .filter(card -> card instanceof Card.JollyRoger)
        ).hasSize(14);
    }

    @Test
    void newDeckShouldHave5EscapeCards() throws Exception {
        assertThat(
                Deck.create().cards()
                        .stream()
                        .filter(card -> card instanceof Card.Pirate)
        ).hasSize(5);
    }

    @Test
    void newDeckShouldHave5PirateCards() throws Exception {
        assertThat(
                Deck.create().cards()
                        .stream()
                        .filter(card -> card instanceof Card.Pirate)
        ).hasSize(5);
    }

    @Test
    void newDeckShouldHave1TigressCard() throws Exception {
        assertThat(
                Deck.create().cards()
                        .stream()
                        .filter(card -> card instanceof Card.Tigress)
        ).hasSize(1);
    }

    @Test
    void newDeckShouldHave2MermaidCard() throws Exception {
        assertThat(
                Deck.create().cards()
                        .stream()
                        .filter(card -> card instanceof Card.Mermaid)
        ).hasSize(2);
    }

    @Test
    void newDeckShouldHave1SkullKingCard() throws Exception {
        assertThat(
                Deck.create().cards()
                        .stream()
                        .filter(card -> card instanceof Card.SkullKing)
        ).hasSize(1);
    }
}