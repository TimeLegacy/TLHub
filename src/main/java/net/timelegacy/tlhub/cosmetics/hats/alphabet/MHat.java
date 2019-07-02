package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class MHat extends Hat {

  public MHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("M Hat");
    setDisplayName(getRarity().getColor() + "'M' Hat");
    setPermissionNode("hub.cosmetics.hats.m");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWQ3NWZlZDM2NDlmODdhNDhlNTExNjliNTdkY2NlNmQ0YThkYzk3ZGI0MThmMjJkNjBkOTZjMmE2MmIzZSJ9fX0=");
  }

}
