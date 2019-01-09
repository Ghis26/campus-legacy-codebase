
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

    /**
     * isConjured ?
     * if name start with 'Conjured', return true
     *
     * @return boolean
     */
   public  boolean isConjured() {
        return this.name.startsWith("Conjured");
    }

    /**
     * isLegendary ?
     * if name equals 'Sulfuras, Hand of Ragnarso, return true
     *
     * @return boolean
     */
    public boolean isLegendary() {
        return this.name.equals("Sulfuras, Hand of Ragnaros");
    }

    /**
     * isAPass ?
     * if name start with 'Backstage passes', return true
     *
     * @return boolean
     */
    public boolean isAPass() {
        return this.name.startsWith("Backstage passes");
    }

    /**
     * isCheese ?
     * if name equals "Aged Brie", return true
     *
     * @return boolean
     */
    public boolean isCheese() {
        return this.name.equals("Aged Brie");
    }

    /**
     * isAgingRedWine ?
     * if name equals "Aging red wine", return true
     *
     * @return boolean
     */
    public boolean isAgingRedWine() {
        return this.name.equals("Aging Red Wine");
    }

    public boolean isToOld() {
    return this.sellIn < -100;
    }

    /**
     * isSoldOut ?
     * if sellIn in less than 0, return true
     *
     * @return
     */
    public boolean isSoldOut() {
        return this.sellIn < 0;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}