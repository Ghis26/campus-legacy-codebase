package com.gildedrose;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    // method which update item quality
    public void updateQuality() {

        // Method who set the specificity of the items
        for (Item item : items) {
            item.specific = item.setSpecific(item);
            item.quality = item.sulfurasQuality(item);
        }

        final Logger logger = LoggerFactory.getLogger(GildedRose.class);
        for (Item item : items) {
            if (item.quality >= 0 && item.quality <= 50) {
                //Downgrade items sellIn
                if (!item.name.contains("Sulfuras")) {
                    item.sellIn--;
                }
                if (item.specific) {

                    // Update quality of Brie
                    item.quality = item.agedBrieQuality(item);

                    //Update Quality of conjured items
                    item.quality = item.conjuredQuality(item);

                    //Update quality of passes
                    item.quality = item.passesQuality(item);
                } else {
                    // quality if sell in > 0
                    if (item.sellIn >= 0) {
                        item.quality = positiveSellIn(item);
                    } else {
                        // quality if sell in < 0
                        item.quality = negativeSellIn(item);
                    }
                }
                item.quality = correctionQuality(item);
                displayLog(item, logger);
            }
        }
    }

    //General method when the item sell in is positive
    private int positiveSellIn(Item item) {
        if (item.quality > 0) {
            return item.quality = item.quality - 1;
        } else {
            return item.quality;
        }
    }

    //General method when the item sell in is negative
    private int negativeSellIn(Item item) {
        if (item.quality > 1) {
            return item.quality = item.quality - 2;
        } else {
            return item.quality;
        }
    }

    private void displayLog(Item item, Logger logger) {
        if (item.quality < 0) {
            logger.debug("Quality of item " + item.name + " is under 0");
        }
        if (item.quality > 50) {
            logger.debug("Quality of item " + item.name + "is over 50");
        } else {
            logger.info("item " + item.name + ", sellIn : " + item.sellIn + " quality :" + item.quality + " is ok.");
        }
    }

    private int correctionQuality(Item item) {
        if (item.quality < 0) {
            return item.quality = 0;
        }
        if (item.quality > 50 && !item.name.contains("Sulfuras")) {
            return item.quality = 50;
        }
        return item.quality;
    }
}
