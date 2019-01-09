package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TddGildedRose {

    private GildedRose mainGilded;
    private Item[] items;

    public TddGildedRose() {
        Item testItem = new Item("chievre",1,1);
        this.items = new Item[]{testItem};
        this.mainGilded = new GildedRose(items);
    }

    @Test
    public void QualityShouldDecreaseWhenSellInDecrease() {
        mainGilded.updateQuality();
        assertThat(items[0]).isEqualToComparingFieldByField(new Item("chievre",0,0));
    }
}
