package net.timelegacy.tlhub.cosmetics.hats.planets;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class MercuryHat extends Hat {

  public MercuryHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.PLANETS);
    setName("Mercury Hat");
    setDisplayName(getRarity().getColor() + "Mercury Hat");
    setPermissionNode("hub.cosmetics.hats.mercury");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzE3OGYyMzU3NjhlZDJmMGYxYTA3YWIwMmI5MmY1OTljYzQyYzc0MWQyZjczM2U1MzY4YjVhMTA0ODRiM2NiIn19fQ==");
  }

}
