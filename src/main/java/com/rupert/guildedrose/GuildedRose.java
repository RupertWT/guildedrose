package com.rupert.guildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
        	quality(i);
        	sellIn(i);
        }
    }

	private void sellIn(int i) {
		if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//			Do nothing to sellIn
        } else {
        	items[i].sellIn = items[i].sellIn - 1;
        }		
	}

	private void quality(int i) {
		if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//			Do nothing to quality
		} else if (items[i].name.equals("Aged Brie")) {
			qualityAgedBrieUpdateStrategy(i);
		} else if (items[i].name.contains("Backstage")) {
			qualityBackstagePassesUpdateStrategy(i);
		} else if (items[i].name.contains("Conjured")) {
			qualityConjuredUpdateStrategy(i);
		} else {
			qualityStandardUpdateStrategy(i);
		}		
	}

	private void qualityAgedBrieUpdateStrategy(int i) {
		if (items[i].sellIn < 0) {
			items[i].quality = items[i].quality + 2;
		} else {
			items[i].quality = items[i].quality + 1;
		}
    	QualityMax(i);
	}

	private void qualityBackstagePassesUpdateStrategy(int i) {
		if (items[i].sellIn <= 0) {
			items[i].quality = 0;
		} else if (items[i].sellIn < 6) {
			items[i].quality = items[i].quality + 3;
		} else if (items[i].sellIn < 11) {
			items[i].quality = items[i].quality + 2;
		} else {
			items[i].quality = items[i].quality + 1;
		}
    	QualityMax(i);
	}

	private void qualityConjuredUpdateStrategy(int i) {
		if (items[i].sellIn < 0) {
			items[i].quality = items[i].quality - 4;
		} else {
			items[i].quality = items[i].quality - 2;
		}
    	QualityMin(i);
	}

	private void qualityStandardUpdateStrategy(int i) {
		if (items[i].sellIn < 0) {
			items[i].quality = items[i].quality - 2;
		} else {
			items[i].quality = items[i].quality - 1;
		}	
		QualityMin(i);
	}
	
	private void QualityMax(int i) {
		if (items[i].quality > 50) {
			items[i].quality = 50;
		}
	}

	private void QualityMin(int i) {
		if (items[i].quality < 0) {
			items[i].quality = 0;
		}
	}
}