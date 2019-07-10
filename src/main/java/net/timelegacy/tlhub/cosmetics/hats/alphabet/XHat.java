package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class XHat extends Hat {

  public XHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("X Hat");
    setDisplayName(getRarity().getColor() + "'X' Hat");
    setPermissionNode("hub.cosmetics.hats.x");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2EyNTRmYzA0NGVmYjg0Y2Q1NzZhNmM4ZjExNDRmODNhY2RiMTQ5OTEyMzIwNjBhYjQ4NjY5MWEwOWIifX19");
  }

}
