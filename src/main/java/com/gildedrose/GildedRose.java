package com.gildedrose;

import com.google.common.collect.Range;

public class GildedRose {
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BRIE = "Aged Brie";
    public static final String PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured";
    public static final String WINE = "Aging Red Wine";

    public void frickYou(Item item) {
        System.out.println("F*ck You, damn " + item.name);
    }

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for (Item item : items) {
            Rules rules = whatKindIsIt(item);
            rules.apply(item);
        }
    }

    private Rules whatKindIsIt(Item item) {

        Rules ruleForBrie = new Rules(
                new Rules.Rule(Range.closed(1, 3), this::decreaseQuality)
        );
        Rules ruleForWine = new Rules(
                new Rules.Rule(Range.lessThan(-100), this::decreaseQuality),
                new Rules.Rule(Range.closed(-99, 0), this::decreaseQuality),
                new Rules.Rule(Range.greaterThan(0), this::frickYou)
        );
        Rules ruleForConjured = new Rules(
                new Rules.Rule(Range.greaterThan(0), conjured -> {
                    decreaseQuality(conjured);
                    decreaseQuality(conjured);
                }),
                new Rules.Rule(Range.atMost(0), conjured -> {
                    decreaseQuality(conjured);
                    decreaseQuality(conjured);
                    decreaseQuality(conjured);
                    decreaseQuality(conjured);
                })
        );
        Rules ruleForPass = new Rules(
                new Rules.Rule(Range.greaterThan(10), this::increaseQuality),
                new Rules.Rule(Range.closedOpen(5, 10), pass -> {
                    increaseQuality(pass);
                    increaseQuality(pass);
                }),
                new Rules.Rule(Range.closed(0, 5), pass -> {
                    increaseQuality(pass);
                    increaseQuality(pass);
                    increaseQuality(pass);
                }),
                new Rules.Rule(Range.lessThan(0), pass -> {
                    pass.quality = 0;
                })
        );
        Rules ruleForSulfuras = new Rules(
                new Rules.Rule(Range.all(), this::frickYou)
        );

        Rules ruleForNormalItem = new Rules(
                new Rules.Rule(Range.atLeast(0), this::decreaseQuality),
                new Rules.Rule(Range.lessThan(0), defaultItem -> {
                    decreaseQuality(defaultItem);
                    decreaseQuality(defaultItem);
                })
        );
        increaseQuality(item);

        return item.name.equals(SULFURAS) ? ruleForSulfuras :
                item.name.equals(BRIE) ? ruleForBrie :
                        item.name.equals(PASSES) ? ruleForPass :
                                item.name.startsWith(CONJURED) ? ruleForConjured :
                                        item.name.equals(WINE) ? ruleForWine :
                                                ruleForNormalItem;
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
        if (Range.closed(0, 10).contains(item.sellIn)) {
            increaseQuality(item);
        }
        if (Range.closed(0, 5).contains(item.sellIn)) {
            increaseQuality(item);
        }
        if (Range.lessThan(0).contains(item.sellIn)) {
            item.quality = 0;
        }
//
//        increaseQuality(item);
//        if (item.sellIn <= 10) {
//            increaseQuality(item);
//        }
//        if (item.sellIn <= 5) {
//            increaseQuality(item);
//        }
//        if (isSoldOut(item)) {
//            item.quality = 0;
//        }
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