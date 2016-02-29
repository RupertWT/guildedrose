package com.rupert.guildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {
	
//	TO DO
//	Finish tests before refactoring
	
    @Test
    public void randomNormalItemTestStillWithinSellByDate() {
        Item[] items = new Item[] { new Item("Normal Item", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Normal Item", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);		
    }
	
    @Test
    public void randomNormalItemTestPassedSellByDate() {
        Item[] items = new Item[] { new Item("Normal Item", -5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Normal Item", app.items[0].name);
        assertEquals(-6, app.items[0].sellIn);
        assertEquals(18, app.items[0].quality);		
    }
    
    @Test
    public void randomNormalItemTestQualityNotNegative() {
        Item[] items = new Item[] { new Item("Normal Item", -5, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Normal Item", app.items[0].name);
        assertEquals(-6, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);		
    }
  
    
}