package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TddGildedRose {

    @Test
    public void QualityShouldDecreaseWhenSellInDecrease() {
        Item testItem = new Item("Chievre", 1, 1);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Chievre", 0, 0));
    }

    @Test
    public void shouldDecreaseTwiceWhenSellInIsUnderZero() {
        Item testItem = new Item("Chievre", -5, 2);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();

        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Chievre", -6, 0));
    }
}
