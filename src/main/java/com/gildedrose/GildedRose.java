package com.gildedrose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Sulfuras")) {
                item.sellIn--;
                if (!item.name.equals("Aged Brie")) {
                    decreaseQuality(item);
                    if (item.sellIn < 0) {
                        decreaseQuality(item);
                    }
                    if (item.quality < 0) {
                        item.quality = 0;
                    }
                } else {
                    increaseQuality(item);
                    if (item.sellIn < 0) {
                        increaseQuality(item);
                    }
                }
            }
        }
    }

    public void decreaseQuality(Item item) {
        item.quality--;
    }

    public void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}