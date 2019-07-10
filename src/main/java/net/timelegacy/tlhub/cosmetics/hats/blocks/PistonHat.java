package net.timelegacy.tlhub.cosmetics.hats.blocks;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class PistonHat extends Hat {

  public PistonHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.BLOCKS);
    setName("Piston Hat");
    setDisplayName(getRarity().getColor() + "Piston Hat");
    setPermissionNode("hub.cosmetics.hats.piston");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWE4NjhjZTkxN2MwOWFmOGU0YzM1MGE1ODA3MDQxZjY1MDliZjJiODlhY2E0NWU1OTFmYmJkN2Q0YjExN2QifX19");
  }

}
