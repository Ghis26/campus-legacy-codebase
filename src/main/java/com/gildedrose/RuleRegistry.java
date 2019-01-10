package com.gildedrose;

import com.google.common.collect.Range;

import static com.gildedrose.Item.decreaseQuality;
import static com.gildedrose.Item.increaseQuality;

public class RuleRegistry {

    public static final Rules RULE_FOR_BRIE = new Rules(
            new Rules.Rule(Range.atLeast(0), Item::increaseQuality),
            new Rules.Rule(Range.lessThan(0), brie -> {
                increaseQuality(brie);
                increaseQuality(brie);
            })
    );
    public static final Rules RULE_FOR_WINE = new Rules(
            new Rules.Rule(Range.lessThan(-100), Item::decreaseQuality),
            new Rules.Rule(Range.closed(-100, -1), Item::increaseQuality),
            new Rules.Rule(Range.atLeast(0), Item::frickYou)
    );
    public static final Rules RULE_FOR_CONJURED = new Rules(
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
    public static final Rules RULE_FOR_PASS = new Rules(
            new Rules.Rule(Range.greaterThan(10), Item::increaseQuality),
            new Rules.Rule(Range.openClosed(5, 10), pass -> {
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
    public static final Rules RULE_FOR_SULFURAS = new Rules(
            new Rules.Rule(Range.all(), Item::frickYou)
    );
    public static final Rules RULE_FOR_NORMAL_ITEM = new Rules(
            new Rules.Rule(Range.atLeast(0), Item::decreaseQuality),
            new Rules.Rule(Range.lessThan(0), defaultItem -> {
                decreaseQuality(defaultItem);
                decreaseQuality(defaultItem);
            })
    );
}
