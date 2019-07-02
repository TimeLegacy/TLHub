package net.timelegacy.tlhub.cosmetics.hats.food;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class CheeseHat extends Hat {

  public CheeseHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.FOOD);
    setName("Cheese Hat");
    setDisplayName(getRarity().getColor() + "Cheese Hat");
    setPermissionNode("hub.cosmetics.hats.cheese");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzZjMDFiZmZlY2ZkYWI2ZDNjMGYxYTdjNmRmNmFhMTkzNmYyYWE3YTUxYjU0YTRkMzIzZTFjYWNiYzUzOSJ9fX0=");
  }

}
