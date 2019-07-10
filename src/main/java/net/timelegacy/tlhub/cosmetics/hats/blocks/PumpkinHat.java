package net.timelegacy.tlhub.cosmetics.hats.blocks;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class PumpkinHat extends Hat {

  public PumpkinHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.BLOCKS);
    setName("Pumpkin Hat");
    setDisplayName(getRarity().getColor() + "Pumpkin Hat");
    setPermissionNode("hub.cosmetics.hats.pumpkin");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjQzODI2NjEwZmY5M2M3MDBlNWI3ZDVmYTg5ZDZlYzA1MWNlZjZmY2IxN2IwZjhlYmE2NTljMmU2Yzg5ZTFkOCJ9fX0=");
  }

}
