package net.timelegacy.tlhub.cosmetics.hats.blocks;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class BookshelfHat extends Hat {

  public BookshelfHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.BLOCKS);
    setName("Bookshelf Hat");
    setDisplayName(getRarity().getColor() + "Bookshelf Hat");
    setPermissionNode("hub.cosmetics.hats.bookshelf");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWRjZmY4NGI5YWJlMjM0YzA4YTI0Zjk5OGUxNzljYTRkMzdkZTQ3YzUxOWQyZWNlYWUxOGY2NGVkNWZkNyJ9fX0=");
  }

}
