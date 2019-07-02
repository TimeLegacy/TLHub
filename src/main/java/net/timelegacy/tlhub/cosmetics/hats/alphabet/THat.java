package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class THat extends Hat {

  public THat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("T Hat");
    setDisplayName(getRarity().getColor() + "'T' Hat");
    setPermissionNode("hub.cosmetics.hats.t");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTIyNTdhOTM1ZjQzMWJlZTU4NWFmZDZjMmY3ZmNlNDZlMWQ5ZjVjNjhhNWRiODBkNTY3MzlhYTI5MzJhMjZjIn19fQ==");
  }

}
