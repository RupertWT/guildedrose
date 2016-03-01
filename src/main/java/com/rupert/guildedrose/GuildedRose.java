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
		items[i].sellIn = (items[i].name.equals("Sulfuras, Hand of Ragnaros")) ? items[i].sellIn : items[i].sellIn - 1;	
	}
	
	//currentPlayer = (currentPlayer == 1) ? 2 : 1;

	private void quality(int i) {
		String name = items[i].name;
		switch(name) {
		case "Sulfuras, Hand of Ragnaros":
//			Do nothing to quality
			break;
		case "Aged Brie":
			qualityAgedBrieUpdateStrategy(i);
			break;
		default:
			if (name.contains("Backstage")) {
				qualityBackstagePassesUpdateStrategy(i);
			} else if (name.contains("Conjured")) {
				qualityConjuredUpdateStrategy(i);
			} else {
				qualityStandardUpdateStrategy(i);
			}
		}
	}

	private void qualityAgedBrieUpdateStrategy(int i) {
		items[i].quality = (items[i].sellIn) < 0 ? items[i].quality + 2: items[i].quality + 1;	
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
		items[i].quality = (items[i].sellIn < 0) ? items[i].quality - 4: items[i].quality - 2;	
    	QualityMin(i);
	}

	private void qualityStandardUpdateStrategy(int i) {
		items[i].quality = (items[i].sellIn < 0) ? items[i].quality - 2: items[i].quality - 1;	
		QualityMin(i);
	}
	
	private void QualityMax(int i) {
		items[i].quality = (items[i].quality > 50) ? 50: items[i].quality;	
	}

	private void QualityMin(int i) {
		items[i].quality = (items[i].quality < 0) ? 0: items[i].quality;
	}
}