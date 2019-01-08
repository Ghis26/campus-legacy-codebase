package com.gildedrose;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            item.specific = item.setSpecific(item);
            item.quality = item.sulfurasQuality(item);
        }
        final Logger logger = LoggerFactory.getLogger(GildedRose.class);
        for (Item item : items) {
            item.quality = generalMethod(item);
            item.quality = correctionQuality(item);
            displayLog(item, logger);
        }
    }

    //General method
    private int generalMethod(Item item) {
        if (item.quality >= 0 && item.quality <= 50) {
            if (!item.name.contains("Sulfuras")) {
                item.sellIn--;}
            if (item.specific) {
                return item.quality = specificItems(item);
            } else {
                return item.quality = noSpecificItems(item);}
        }
        return item.quality;
    }

    //Method when the item is specific
    private int specificItems(Item item) {
        item.quality = item.agedBrieQuality(item);
        item.quality = item.conjuredQuality(item);
        item.quality = item.passesQuality(item);
        return item.quality;
    }

    //Method when the item isn't specific
    private int noSpecificItems(Item item) {
        if (item.sellIn >= 0) {
            return item.quality = positiveSellIn(item);
        } else if (item.sellIn < 0) {
            return item.quality = negativeSellIn(item);
        } return item.quality;
    }

    //Method when the item sell in is positive
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

    // Method for displaying logs
    private void displayLog(Item item, Logger logger) {
        if (item.quality < 0) {
            logger.debug("Quality of item " + item.name + " is under 0");
        }
        if (item.quality > 50) {
            logger.debug("Quality of item " + item.name + "is over 50");
        } else {
            logger.info("item " + item.name + ", sellIn: " + item.sellIn +
                    " quality :" + item.quality + " is ok.");
        }
    }

    // Method used when the quality is over 50 or less than 0
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
