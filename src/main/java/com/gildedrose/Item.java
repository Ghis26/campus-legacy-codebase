
package com.gildedrose;

public class Item {

    public String name;
    public int sellIn;
    public int quality;

    /**
     * constructor
     *
     * @param name
     * @param sellIn
     * @param quality
     */
    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    static void decreaseQuality(Item item) {
        item.quality = Math.max(0, item.quality - 1);
    }

    static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    static void frickYou(Item item) {
        System.out.println("F*ck You, damn " + item.name);
    }
}