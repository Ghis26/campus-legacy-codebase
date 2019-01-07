package com.gildedrose;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    // method which update item quality
    void updateQuality() {
        final Logger logger = LoggerFactory.getLogger(GildedRose.class);
        for (Item item : items) {
            try {

                if (item.quality >= 0 && item.quality <= 50) {

                    //Downgrade items sellIn
                    if (!item.name.contains("Sulfuras")) {
                        item.sellIn--;
                    }

                    // quality if sell in > 0
                    if (item.sellIn >= 0) {
                        item.quality = positiveSellIn(item);
                    } else {
                        // quality if sell in < 0
                        item.quality = negativeSellIn(item);
                    }

                    // Update quality of Brie
                    item.quality = agedBrieQuality(item);

                    //Set quality of Sulfuras
                    item.quality = sulfurasQuality(item);

                    //Update Quality of conjured items
                    item.quality = conjuredQuality(item);

                    //Update quality of passes
                    item.quality = passesQuality(item);
                }
            } catch (Exception e) {
                logger.debug("error on item " + item.name + ", sellIn : " + item.sellIn + " quality :" + item.quality +
                        "with error : " + e);
            }
        }
        logger.info("Update complete.");
    }

    public Item[] getItems() {
        return items;
    }

    //General method when the item sell in is positive
    private int positiveSellIn(Item item) {
        if (!item.name.contains("Backstage passes") && !item.name.equals("Sulfuras, Hand of Ragnaros")
                && !item.name.contains("Conjured") && !item.name.equals("Aged Brie")) {
            return item.quality = item.quality - 1;
        }
        return item.quality;
    }

    //General method when the item sell in is negative
    private int negativeSellIn(Item item) {
        if (!item.name.contains("Backstage passes") && !item.name.equals("Sulfuras, Hand of Ragnaros")
                && !item.name.contains("Conjured") && !item.name.equals("Aged Brie")) {
            return item.quality = item.quality - 2;
        }
        return item.quality;
    }

    // Method which update brie quality
    private int agedBrieQuality(Item item) {
        if (item.name.equals("Aged Brie")) {
            if (item.sellIn >= 0) {
                return item.quality = item.quality + 1;
            } else {
                return item.quality = item.quality + 2;
            }
        }
        return item.quality;
    }

    // Method which update conjured item quality
    private int conjuredQuality(Item item) {
        if (item.name.contains("Conjured") && item.quality > 1) {
            if (item.sellIn >= 0) {
                return item.quality = item.quality - 2;
            } else {
                return item.quality = item.quality - 4;
            }
        }
        if (item.name.contains("Conjured") && item.quality == 1) {
            return item.quality = 0;
        }
        return item.quality;
    }

    // Method which update passes quality
    private int passesQuality(Item item) {
        if (item.name.contains("Backstage passes")) {
            if (item.sellIn < 11 && item.sellIn >= 0) {
                if (item.sellIn > 6 && item.quality <= 48) {
                    return item.quality = item.quality + 2;
                }
                if (item.sellIn < 6 && item.quality <= 47) {
                    return item.quality = item.quality + 3;
                } else {
                    return item.quality = 50;
                }
            }
            if (item.sellIn < 0) {
                return item.quality = 0;
            } else {
                return item.quality = item.quality + 1;
            }
        }
        return item.quality;
    }

    //Method which set sulfuras quality
    private int sulfurasQuality(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return item.quality = 80;
        }
        return item.quality;
    }
}
