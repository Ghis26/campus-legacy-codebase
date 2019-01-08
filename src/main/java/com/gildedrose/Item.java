package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public boolean specific;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    // Method which set specific attribute for the item
    boolean setSpecific(Item item) {
        if (item.name.contains("Backstage passes") ||
                item.name.equals("Sulfuras, Hand of Ragnaros") ||
                item.name.startsWith("Conjured") ||
                item.name.equals("Aged Brie")) {
            return item.specific = true;
        } else {
            return item.specific = false;
        }
    }

    // Method which update brie quality
    int agedBrieQuality(Item item) {
        if (item.name.equals("Aged Brie")) {
            if (item.sellIn >= 0) {
                return item.quality + 1;
            } else {
                return item.quality + 2;
            }
        }
        return item.quality;
    }

    // Method which update conjured item quality
    int conjuredQuality(Item item) {
        if (item.name.startsWith("Conjured")) {
            if (item.sellIn >= 0) {
                return item.quality = item.quality - 2;
            } else {
                return item.quality = item.quality - 4;}
        }
        if (item.name.startsWith("Conjured") && item.quality == 1) {
            return item.quality = 0;}
        return item.quality;
    }

    // Method which update passes quality
    int passesQuality(Item item) {
        if (item.name.contains("Backstage passes")) {
            if (item.sellIn < 11 && item.sellIn >= 6 && item.quality <= 48) {
                return item.quality = item.quality + 2;
            } if (item.sellIn < 6 && item.quality <= 47) {
                return item.quality = item.quality + 3;}
        }
        if (item.sellIn < 0) {
            return item.quality = 0;
        } else {
            return item.quality = item.quality + 1;}
    }

    //Method which set sulfuras quality
    int sulfurasQuality(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return item.quality = 80;
        }
        return item.quality;
    }
}