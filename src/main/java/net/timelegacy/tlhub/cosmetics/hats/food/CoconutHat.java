package net.timelegacy.tlhub.cosmetics.hats.food;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class CoconutHat extends Hat {

  public CoconutHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.FOOD);
    setName("Coconut Hat");
    setDisplayName(getRarity().getColor() + "Coconut Hat");
    setPermissionNode("hub.cosmetics.hats.coconut");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTMxZjI0ZDFiNWU2Y2ViYjY1YTY3YWQzYjJmM2YyZmM5Y2EyOWZiMDczN2FhNjJiNWQ3M2JmMzM4ZDIxNDFmNSJ9fX0=");
  }

}
