
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
}