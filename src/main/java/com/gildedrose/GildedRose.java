package com.gildedrose;

import static com.gildedrose.RuleRegistry.*;

class GildedRose {
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BRIE = "Aged Brie";
    private static final String PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String CONJURED = "Conjured";
    private static final String WINE = "Aging Red Wine";

    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }


    void updateQuality() {
        for (Item item : items) {
            Rules rules = whatKindIsIt(item);
            rules.apply(item);
        }
    }

    private Rules whatKindIsIt(Item item) {
        if (!item.name.startsWith("Sulfuras")) {
            decreaseSellIn(item);
        }

        return item.name.equals(SULFURAS) ? RULE_FOR_SULFURAS :
                item.name.equals(BRIE) ? RULE_FOR_BRIE :
                        item.name.equals(PASSES) ? RULE_FOR_PASS :
                                item.name.startsWith(CONJURED) ? RULE_FOR_CONJURED :
                                        item.name.equals(WINE) ? RULE_FOR_WINE :
                                                RULE_FOR_NORMAL_ITEM;
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }
}