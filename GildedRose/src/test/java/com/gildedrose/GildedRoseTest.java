package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals("foo", element.name, "the name changed");
  }

  //___________________________________________________________

  @Test
  @DisplayName("Test that the quality is changed")
  void testquantity() {
    Item element = new Item("+5 Dexterity Vest", 10, 20);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(19, element.quality, "the quality changed");
  }

  //___________________________________________________________

  @Test
  @DisplayName("Test that the quality is augmented for Aged Brie")
  void testAugment() {
    Item element = new Item("Aged Brie", 2, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(1, element.quality, "the quality changed +1");
  }

  //___________________________________________________________

  @Test
  @DisplayName("Test that the quality can't be more than 50")
  void testPlus50() {
    Item element = new Item("Aged Brie", 2, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "the quality still 50");
  }

  //___________________________________________________________

  @Test
  @DisplayName("Test that the quality is unchanged")
  void testunchanged() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(80, element.quality, "the quality unchanged");
  }

  //___________________________________________________________

  @Test
  @DisplayName("Test that the quality can't be more than 50")
  void test_Plus50() {
    Item element = new Item("Aged Brie", 2, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "the quality unchanged");
  }

  //___________________________________________________________

  @Test
  @DisplayName("Test quality still unchanged ")
  void testStillSame() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 5, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(10, element.quality, "Quality should be the same");

  }

  //___________________________________________________________

  @Test
  @DisplayName("Test quality increment for Aged Brie")
  void testAgedBrie() {
    Item element = new Item("Aged Brie", 5, 40);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(41, element.quality, "Quality should increment by 1");
  }

  //___________________________________________________________

  @Test
  @DisplayName("Test quality increment for Backstage")
  void testBackstage() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(42, element.quality, "Quality should increment by 2");
  }

  //___________________________________________________________

  @Test
  @DisplayName("Test quality increment for Backstage 2 ")
  void testBackstage2() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(43, element.quality, "Quality should increment by 3");
  }

  //___________________________________________________________

  @Test
  @DisplayName("Test Sellin decrement for regular item")
  void testSellin() {
    Item element = new Item("Regular", 5, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(4, element.sellIn, "Sellin should decrement by 1");
  }

  //___________________________________________________________

  @Test
  @DisplayName("Test quality decrement for regular item by 2 when sellin <0")
  void testQualityDec() {
    Item element = new Item("Regular", -4, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(8, element.quality, "Quality should decrement by 2");
  }

  //___________________________________________________________

  @Test
  @DisplayName("Test quality for Backstage = 0 when sellin <0")
  void testBackstage0() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", -4, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "Quality should be 0");
  }

  //___________________________________________________________

  @Test
  @DisplayName("Test quality increment for Aged Brie by 2")
  void testAgieInc() {
    Item element = new Item("Aged Brie", -4, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(12, element.quality, "Quality should inc by 2");
  }

  //___________________________________________________________

  @Test
  @DisplayName("Test Item toString method")
  void testItemToString() {
    Item element = new Item("Backstage passes", 3, 25);
    String expectedString = "Backstage passes, 3, 25";
    assertEquals(expectedString, element.toString(), "toString should return the expected string");
  }

  //___________________________________________________________

  @Test
  @DisplayName("Test quality increment for Aged Brie when sellIn is zero")
  void testAgedBrieSellInIsZero() {
    Item element = new Item("Aged Brie", 0, 40);
    GildedRose app = new GildedRose(new Item[] { element });
    app.updateQuality();
    assertEquals(42, element.quality, "Quality should increment by 2");
  }

  //___________________________________________________________

  @Test
  @DisplayName("Test quality becomes zero for Backstage when sellIn is zero")
  void testBackstageSellInIsZero() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40);
    GildedRose app = new GildedRose(new Item[] { element });
    app.updateQuality();
    assertEquals(0, element.quality, "Quality should be zero");
  }

  //___________________________________________________________

  @Test
  @DisplayName("Test quality increment for Aged Brie when sellIn is negative")
  void testAgedBrieSellInIsNegative() {
    Item element = new Item("Aged Brie", -1, 40);
    GildedRose app = new GildedRose(new Item[] { element });
    app.updateQuality();
    assertEquals(42, element.quality, "Quality should increment by 2");
  }

  //___________________________________________________________

  @Test
  @DisplayName("test AgedBrie quality 50")
  void testAgedBriequality50(){
    Item element = new Item("Aged Brie", -1, 50);
    GildedRose app = new GildedRose(new Item[] { element });
    app.updateQuality();
    assertEquals(50, element.quality, "Quality should be the same");
  }

  //___________________________________________________________

  @Test
  @DisplayName("test Backstage SellIn")
  void testBackstageSellIn(){
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40);
    GildedRose app =new GildedRose(new Item[] { element });
    app.updateQuality();
    assertEquals(41, element.quality, "Quality should increment by 1");
  }

  //___________________________________________________________

  @Test
  @DisplayName("test Backstage SellIn 2")
  void testBackstageSellIn2(){
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
    GildedRose app =new GildedRose(new Item[] { element });
    app.updateQuality();
    assertEquals(50, element.quality, "Quality should increment by 1");
  }

  //___________________________________________________________

  @Test
  @DisplayName("test Backstage SellIn 3")
  void testBackstageSellIn3(){
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 48);
    GildedRose app =new GildedRose(new Item[] { element });
    app.updateQuality();
    assertEquals(50, element.quality, "Quality should increment by 1");
  }

  //___________________________________________________________

  @Test
  @DisplayName("test Backstage SellIn 4")
  void testBackstageSellIn4(){
    Item element = new Item("Sulfuras, Hand of Ragnaros", -1, 40);
    GildedRose app =new GildedRose(new Item[] { element });
    app.updateQuality();
    assertEquals(40, element.quality, "Quality should decrement by 1");
  }

  //___________________________________________________________

  @Test
  @DisplayName("test Conjured")
  void testConjured(){
    Item element = new Item("Conjured Mana Cake", 9, 40);
    GildedRose app =new GildedRose(new Item[] { element });
    app.updateQuality();
    assertEquals(38, element.quality, "Quality should decrement by 2");
  }

  //___________________________________________________________

  @Test
  @DisplayName("test Conjured negative")
  void testConjuredN(){
    Item element = new Item("Conjured Mana Cake", 9, -2);
    GildedRose app =new GildedRose(new Item[] { element });
    app.updateQuality();
    assertEquals(0, element.quality, "Quality should decrement by 2");
  }

}


