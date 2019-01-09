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

    @Test
    public void itemQualityShouldNeverBeUnderZero() {
        Item testItem = new Item("Chievre", 1, 0);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Chievre", 0, 0));
    }

    @Test
    public void itemQualityShouldNeverBeUnderZeroEvenSellInisnegative() {
        Item testItem = new Item("Chievre", 0, 0);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Chievre", -1, 0));
    }

    @Test
    public void itemShouldNamedAgedBrie() {
        Item testItem = new Item("Aged Brie", 0, 0);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0].name).isEqualTo("Aged Brie");
    }

    @Test
    public void AgedBrieShouldGrow() {
        Item testItem = new Item("Aged Brie", 1, 0);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0].quality).isEqualTo(1);
    }

    @Test
    public void AgedBrieShouldGrowTwiceWhenSellInIsAtZero() {
        Item testItem = new Item("Aged Brie", -1, 0);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0].quality).isEqualTo(2);
    }

    @Test
    public void shouldTestDecreaseQualityMethod() {
        Item testItem = new Item("Aged Brie", 1, 2);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.decreaseQuality(testItem);
        assertThat(new Item[]{testItem}[0].quality).isEqualTo(1);
    }

    @Test
    public void shouldTestIncreaseQualityMethod() {
        Item testItem = new Item("Aged Brie", 1, 2);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.increaseQuality(testItem);
        assertThat(new Item[]{testItem}[0].quality).isEqualTo(3);
    }


    @Test
    public void gildedRoseShouldAcceptNewRefacoredMethod() {
        Item testItem = new Item("Aged Brie", 1, 2);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0].quality).isEqualTo(3);
    }

    @Test
    public void itemQualityShouldNeverBeMoreThan50() {
        Item testItem = new Item("Aged Brie", 1, 50);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0].quality).isEqualTo(50);
    }

    @Test
    public void itemNamedSulfurasQualityAndSellInNeverMove() {
        Item testItem = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
    }

    @Test
    public void backstageQualityShouldIncrease() {
        Item testItem = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 2);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 3));
    }

    @Test
    public void backstageQualityShouldIncreaseByTwoWhenSellInIsUnderEleven() {
        Item testItem = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 2);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Backstage passes to a TAFKAL80ETC concert", 8, 4));
    }

    @Test
    public void backstageQualityShouldIncreaseByTwoWhenSellInIsUnderSix() {
        Item testItem = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 2);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Backstage passes to a TAFKAL80ETC concert", 4, 5));
    }

    @Test
    public void backstageQualityShouldBeZeroWhenSoldOut() {
        Item testItem = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 48);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0));
    }
}
