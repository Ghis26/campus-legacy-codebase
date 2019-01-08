package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void VerifyIfQualityIsRight() {
        Item[] items = new Item[] { new Item("foo", -2, 11) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(9);
    }
    @Test
    void VerifyIfQualityOfConjuredItemIsRight() {
        Item[] items = new Item[] { new Item("Conjured foo", 2, 11) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(9);
    }

    @Test
    void VerifyIfQualityOfAgedBrieIsRight() {
        Item[] items = new Item[] { new Item("Aged Brie", -2, 11) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(13);
    }
}
