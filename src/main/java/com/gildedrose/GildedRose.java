package com.gildedrose;

public class GildedRose {
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BRIE = "Aged Brie";
    public static final String PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured Mana Cake";
    public static final String WINE = "Aging Red Wine";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case SULFURAS:
                    break;
                case BRIE:
                    decreaseSellIn(item);
                    updateAgedBrie(item);
                    break;
                case PASSES:
                    decreaseSellIn(item);
                    updateBackstagePasses(item);
                    break;
                case CONJURED:
                    decreaseSellIn(item);
                    updateConjured(item);
                    break;
                case WINE:
                    decreaseSellIn(item);
                    updateWineQuality(item);
                    break;
                default:
                    decreaseSellIn(item);
                    updateNormal(item);
                    break;
            }
        }
    }

    private void updateWineQuality(Item item) {
        if (item.sellIn < -100) {
            decreaseQuality(item);
        } else if (isSoldOut(item)) {
            increaseQuality(item);
        }
    }

    private void updateConjured(Item item) {
        decreaseQuality(item);
        decreaseQuality(item);
        if (isSoldOut(item)) {
            decreaseQuality(item);
            decreaseQuality(item);
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    private void updateNormal(Item item) {
        decreaseQuality(item);
        if (isSoldOut(item)) {
            decreaseQuality(item);
        }
    }

    private void updateBackstagePasses(Item item) {
        increaseQuality(item);
        if (item.sellIn <= 10) {
            increaseQuality(item);
        }
        if (item.sellIn <= 5) {
            increaseQuality(item);
        }
        if (isSoldOut(item)) {
            item.quality = 0;
        }
    }

    private void updateAgedBrie(Item item) {
        increaseQuality(item);
        if (isSoldOut(item)) {
            increaseQuality(item);
        }
    }

    private boolean isSoldOut(Item item) {
        return item.sellIn < 0;
    }

    public void decreaseQuality(Item item) {
        item.quality = Math.max(0, item.quality - 1);
    }

    public void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    public Item[] getItems() {
        return items;
    }
}