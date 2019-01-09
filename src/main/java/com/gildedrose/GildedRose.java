package com.gildedrose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for (Item item: items){
            item.sellIn--;
            item.quality--;
            if( item.sellIn < 0 ) {
                item.quality --;
            }
        }
    }
}