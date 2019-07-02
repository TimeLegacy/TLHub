package net.timelegacy.tlhub.cosmetics.hats.food;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class PopcornHat extends Hat {

  public PopcornHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.FOOD);
    setName("Popcorn Hat");
    setDisplayName(getRarity().getColor() + "Popcorn Hat");
    setPermissionNode("hub.cosmetics.hats.popcorn");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTQ5N2IxNDdjZmFlNTIyMDU1OTdmNzJlM2M0ZWY1MjUxMmU5Njc3MDIwZTRiNGZhNzUxMmMzYzZhY2RkOGMxIn19fQ==");
  }

}
