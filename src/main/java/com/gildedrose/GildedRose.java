package com.gildedrose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for (Item item : items) {
            item.sellIn--;
            if (!item.name.equals("Aged Brie")) {
                item.quality--;
                if (item.sellIn < 0) {
                    item.quality--;
                }
                if (item.quality < 0) {
                    item.quality = 0;
                }
            }
            else{
                item.quality++;
                if(item.sellIn<0){
                    item.quality++;
                }
            }
        }
    }
}