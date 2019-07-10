package net.timelegacy.tlhub.cosmetics.hats.food;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class WhiteChocolateHat extends Hat {

  public WhiteChocolateHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.FOOD);
    setName("White Chocolate Hat");
    setDisplayName(getRarity().getColor() + "White Chocolate Hat");
    setPermissionNode("hub.cosmetics.hats.white_chocolate");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWVkNTUyNjBkY2NjOGRhNTkzMzhjNzVlNDFkNTQ0YTJlMWU3ZGJlZjMxYTY5ZmU0MmMwMWIzMjk4YmYyZCJ9fX0=");
  }

}
