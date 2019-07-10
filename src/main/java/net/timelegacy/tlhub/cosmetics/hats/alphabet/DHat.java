package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class DHat extends Hat {

  public DHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("D Hat");
    setDisplayName(getRarity().getColor() + "'D' Hat");
    setPermissionNode("hub.cosmetics.hats.d");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzc3MmU0ZDdmNjk5ZGE2NDM0OWY2NjUxMWMyNjVhNmQzZTIwNmY5ZWNhNDI3ZWFiM2FlZDIxN2RjMmYwYTBkIn19fQ==");
  }

}
