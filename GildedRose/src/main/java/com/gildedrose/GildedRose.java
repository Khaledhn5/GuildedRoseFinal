package com.gildedrose;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  //___________________________________________________

  private void ElementUpdate(Item i){
    i.sellIn -= 1;
    if (i.sellIn <= 0) i.quality -= 2;
    else i.quality -= 1;
    if (i.quality <0) i.quality = 0;
  }

  //___________________________________________________

  private void AgedUpdate(Item i){
    i.sellIn -= 1;
    if (i.sellIn <= 0) i.quality += 2;
    else i.quality += 1;
    if (i.quality >50) i.quality = 50;
  }

  //___________________________________________________

  private void BackstageUpdate(Item i){
    if (i.sellIn<=0) i.quality = 0;
    else if (i.sellIn<6) i.quality += 3;
    else if (i.sellIn<11) i.quality += 2;
    else i.quality += 1;
    i.sellIn -= 1;
    if (i.quality>50) i.quality = 50;
  }

  //___________________________________________________

  private void ConjuredUpdate(Item i){
    i.sellIn -= 1;
    i.quality -= 2;
    if (i.quality < 0) i.quality = 0;
  }

  //___________________________________________________

  public void updateQuality() {
    for (Item item : items) {
      switch (item.name) {
        case "Aged Brie" -> AgedUpdate(item);
        case "Backstage passes to a TAFKAL80ETC concert" -> BackstageUpdate(item);
        case "Conjured Mana Cake" -> ConjuredUpdate(item);
        case "Sulfuras, Hand of Ragnaros" -> {
          assert true;
        }
        default -> ElementUpdate(item);
      }
    }
  }
}
