package com.rupert.guildedrose;

import static org.junit.Assert.*;

//import org.junit.Ignore;
import org.junit.Test;

public class GildedRoseTest {
	
//	End to end test
	
    @Test
    public void end_To_End_Basic_Item() {
        Item[] items = new Item[] { new Item("Normal Item", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertEquals(9, app.items[0].sellIn);	
        assertEquals(19, app.items[0].quality);	
    }
	
//	Normal Items
	
    @Test
    public void normalItem_Within_SellByDate_Has_SellByDate_DecreaseBy1() {
        Item[] items = new Item[] { new Item("Normal Item", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateSellIn();
        assertEquals(9, app.items[0].sellIn);	
    }
    
    @Test
    public void normalItem_Outside_SellByDate_Has_SellByDate_DecreaseBy1() {
        Item[] items = new Item[] { new Item("Normal Item", -5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateSellIn();
        assertEquals(-6, app.items[0].sellIn);	
    }
    
    @Test
    public void normalItem_Within_SellByDate_Has_Quality_DecreaseBy1() {
        Item[] items = new Item[] { new Item("Normal Item", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, app.items[0].quality);		
    }
	    
    @Test
    public void normalItem_Outside_SellByDate_Has_Quality_DecreaseBy2() {
        Item[] items = new Item[] { new Item("Normal Item", -5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18, app.items[0].quality);		
    }
      
    
    @Test
    public void normalItem_Within_SellByDate_Quality_CantGoBelow0() {
        Item[] items = new Item[] { new Item("Normal Item", 15, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);		
    }
    
    @Test
    public void normalItem_Outside_SellByDate_Quality_CantGoBelow0() {
        Item[] items = new Item[] { new Item("Normal Item", -1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);		
    }

//	Aged Brie
    
    @Test
    public void agedBrie_Within_SellByDate_Has_SellByDate_DecreaseBy1() {
        Item[] items = new Item[] { new Item("Aged Brie", 20, 20) };
        GildedRose app = new GildedRose(items);
        app.updateSellIn();
        assertEquals(19, app.items[0].sellIn);		
    }
    
    @Test
    public void agedBrie_Outside_SellByDate_Has_SellByDate_DecreaseBy1() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateSellIn();
        assertEquals(-1, app.items[0].sellIn);		
    }
    
    @Test
    public void agedBrie_Within_SellByDate_Has_Quality_IncreaseBy1() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);		
    }
    
    @Test
    public void agedBrie_Outside_SellByDate_Has_Quality_IncreaseBy2() {
        Item[] items = new Item[] { new Item("Aged Brie", -5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);		
    }
    
    @Test
    public void agedBrie_Within_SellByDate_Has_Quality_NeverAbove50() {
        Item[] items = new Item[] { new Item("Aged Brie", 20, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);		
    }
    
    @Test
    public void agedBrie_Outside_SellByDate_Has_Quality_NeverAbove50() {
        Item[] items = new Item[] { new Item("Aged Brie", -5, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);		
    }
    
//	Backstage Passes
   
    @Test
    public void backstagePasses_Within_SellByDate_Has_SellByDate_DecreaseBy1() {
        Item[] items = new Item[] { new Item("Aged Brie", 20, 20) };
        GildedRose app = new GildedRose(items);
        app.updateSellIn();
        assertEquals(19, app.items[0].sellIn);		
    }
    
    @Test
    public void backstagePasses_Outside_SellByDate_Has_SellByDate_DecreaseBy1() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateSellIn();
        assertEquals(-1, app.items[0].sellIn);	
    }
     
    @Test
    public void backstagePasses_Within_SellByDate_Has_Quality_IncreaseBy1WhenMoreThen10DaysLeft() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);	
    }
    
    @Test
    public void backstagePasses_Within_SellByDate_Has_Quality_IncreaseBy2WhenMoreThen5DaysLeft() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);	
    }
    
    @Test
    public void backstagePasses_Within_SellByDate_Has_Quality_IncreaseBy2When10DaysLeft() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);	
    }
    
    @Test
    public void backstagePasses_Within_SellByDate_Has_Quality_IncreaseBy3WhenMoreThen0DaysLeft() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);	
    }
    
    @Test
    public void backstagePasses_Within_SellByDate_Has_Quality_IncreaseBy3When5DaysLeft() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);	
    }
    
    @Test
    public void backstagePasses_Outside_SellByDate_Has_Quality_GoesTo0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);	
    }
    
    @Test
    public void backstagePasses_Within_SellByDate_Has_Quality_NeverAbove50WhenMoreThen10DaysLeft() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);	
    }
    
    @Test
    public void backstagePasses_Within_SellByDate_Has_Quality_NeverAbove50WhenMoreThen5DaysLeft() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);	
    }
    
    @Test
    public void backstagePasses_Within_SellByDate_Has_Quality_NeverAbove50When10DaysLeft() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);	
    }
    
    @Test
    public void backstagePasses_Within_SellByDate_Has_Quality_NeverAbove50WhenMoreThen0DaysLeft() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);	
    }
    
    @Test
    public void backstagePasses_Within_SellByDate_Has_Quality_NeverAbove50When5DaysLeft() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);	
    }
    
//	Sulfuras
    
    @Test
    public void sulfuras_Within_SellByDate_Has_SellByDate_RemainStatic() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 20, 80) };
        GildedRose app = new GildedRose(items);
        app.updateSellIn();
        assertEquals(20, app.items[0].sellIn);	
    }
   
    @Test
    public void sulfuras_Outside_SellByDate_Has_SellByDate_RemainStatic() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -20, 80) };
        GildedRose app = new GildedRose(items);
        app.updateSellIn();
        assertEquals(-20, app.items[0].sellIn);	
    }
    
    @Test
    public void sulfuras_Within_SellByDate_Has_Quality_RemainStatic() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 20, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);	
    }
    
    @Test
    public void sulfuras_Outside_SellByDate_Has_Quality_RemainStatic() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -20, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);	
    }
    
//	Conjured
    
    @Test
    public void conjuredItem_Within_SellByDate_Has_SellByDate_DecreaseBy1() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateSellIn();
        assertEquals(9, app.items[0].sellIn);	
    }
    
    @Test
    public void conjuredItem_Outside_SellByDate_Has_SellByDate_DecreaseBy1() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateSellIn();
        assertEquals(-6, app.items[0].sellIn);	
    }
    
    @Test
    public void conjuredItem_Within_SellByDate_Has_Quality_DecreaseBy2() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18, app.items[0].quality);		
    }
	    
    @Test
    public void conjuredItem_Outside_SellByDate_Has_Quality_DecreaseBy4() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(16, app.items[0].quality);		
    }
          
    @Test
    public void conjuredItem_Within_SellByDate_Quality_CantGoBelow0() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 15, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);		
    }
    
    @Test
    public void conjuredItem_Outside_SellByDate_Quality_CantGoBelow0() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);		
    }


}