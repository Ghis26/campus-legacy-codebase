package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TddGildedRose {

    @Test
    void QualityShouldDecreaseWhenSellInDecrease() {
        Item testItem = new Item("Chievre", 1, 1);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Chievre", 0, 0));
    }

    @Test
    void shouldDecreaseTwiceWhenSellInIsUnderZero() {
        Item testItem = new Item("Chievre", -5, 2);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Chievre", -6, 0));
    }

    @Test
    void shouldResetToZeroWhenQualityIsUnderZero() {
        Item testItem = new Item("Chievre", 3, -1);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();

        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Chievre", 2, 0));
    }

    @Test
    void itemQualityShouldNeverBeUnderZero() {
        Item testItem = new Item("Chievre", 1, 0);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Chievre", 0, 0));
    }

    @Test
    void itemQualityDecrease() {
        Item testItem = new Item("Chievre", 1, 1);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Chievre", 0, 0));
    }

    @Test
    void itemQualityShouldNeverBeUnderZeroEvenSellInisnegative() {
        Item testItem = new Item("Chievre", 0, 0);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Chievre", -1, 0));
    }

    @Test
    void itemShouldNamedAgedBrie() {
        Item testItem = new Item("Aged Brie", 0, 0);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0].name).isEqualTo("Aged Brie");
    }

    @Test
    void AgedBrieShouldGrow() {
        Item testItem = new Item("Aged Brie", 1, 0);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0].quality).isEqualTo(1);
    }

    @Test
    void AgedBrieShouldGrowTwiceWhenSellInIsAtZero() {
        Item testItem = new Item("Aged Brie", -1, 0);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0].quality).isEqualTo(2);
    }

    @Test
    void shouldTestDecreaseQualityMethod() {
        Item testItem = new Item("Aged Brie", 1, 2);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        Item.decreaseQuality(testItem);
        assertThat(new Item[]{testItem}[0].quality).isEqualTo(1);
    }

    @Test
    void shouldTestIncreaseQualityMethod() {
        Item testItem = new Item("Aged Brie", 1, 2);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        Item.increaseQuality(testItem);
        assertThat(new Item[]{testItem}[0].quality).isEqualTo(3);
    }


    @Test
    void gildedRoseShouldAcceptNewRefacoredMethod() {
        Item testItem = new Item("Aged Brie", 1, 2);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0].quality).isEqualTo(3);
    }

    @Test
    void itemQualityShouldNeverBeMoreThan50() {
        Item testItem = new Item("Aged Brie", 1, 50);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0].quality).isEqualTo(50);
    }

    @Test
    void itemNamedSulfurasQualityAndSellInNeverMove() {
        Item testItem = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
    }

    @Test
    void backstageQualityShouldIncrease() {
        Item testItem = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 2);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 3));
    }

    @Test
    void backstageQualityShouldIncreaseByTwoWhenSellInIsUnderEleven() {
        Item testItem = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 2);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Backstage passes to a TAFKAL80ETC concert", 8, 4));
    }

    @Test
    void backstageQualityShouldIncreaseByTwoWhenSellInIsEqualsToTen() {
        Item testItem = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 2);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 4));
    }

    @Test
    void backstageQualityShouldIncreaseByTwoWhenSellInIsUnderSix() {
        Item testItem = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 2);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Backstage passes to a TAFKAL80ETC concert", 4, 5));
    }

    @Test
    void backstageQualityShouldIncreaseByTwoWhenSellInIsEqualsToFive() {
        Item testItem = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 2);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5));
    }

    @Test
    void backstageQualityShouldBeZeroWhenSoldOut() {
        Item testItem = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 48);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0));
    }

    @Test
    void itemNameShouldStartByConjured() {
        Item testItem = new Item("Conjured Mana Cake", 0, 48);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item("Conjured Mana Cake",0,48).name).contains("Conjured");
    }

    @Test
    void itemConjuredQualityShouldDecreaseTwice() {
        Item testItem = new Item("Conjured Mana Cake", 3, 14);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Conjured Mana Cake", 2, 12));
    }

    @Test
    void itemConjuredQualityShouldDecreaseByFourWhenSellInIsUnderZero() {
        Item testItem = new Item("Conjured Mana Cake", -2, 14);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Conjured Mana Cake", -3, 10));
    }

    @Test
    void wineQualityShouldNotMoveWhenSellInPositive() {
        Item testItem = new Item("Aging Red Wine", 20, 10);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Aging Red Wine", 19, 10));
    }

    @Test
    void wineQualityShouldIncreaseWhenSellInNegative() {
        Item testItem = new Item("Aging Red Wine", -20, 10);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Aging Red Wine", -21, 11));
    }

    @Test
    void wineQualityShouldDecreaseWhenSellInIsUnderMinusHundred() {
        Item testItem = new Item("Aging Red Wine", -100, 10);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Aging Red Wine", -101, 9));
    }

    @Test
    void wineQualityShouldIncreaseWhenSellInIsEqualsToHundred() {
        Item testItem = new Item("Aging Red Wine", -99, 10);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Aging Red Wine", -100, 11));
    }

    @Test
    void brieSellInShouldDecrease() {
        Item testItem = new Item("Aged Brie", -99, 10);
        GildedRose mainGilded = new GildedRose(new Item[]{testItem});
        mainGilded.updateQuality();
        assertThat(new Item[]{testItem}[0]).isEqualToComparingFieldByField(new Item("Aged Brie", -100, 12));
    }

}
