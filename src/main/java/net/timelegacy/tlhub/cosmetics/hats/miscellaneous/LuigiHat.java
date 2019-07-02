package net.timelegacy.tlhub.cosmetics.hats.miscellaneous;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class LuigiHat extends Hat {

  public LuigiHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MISCELLANEOUS);
    setName("Luigi Hat");
    setDisplayName(getRarity().getColor() + "Luigi Hat");
    setPermissionNode("hub.cosmetics.hats.luigi");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTcxZWRhY2Q5YWU5MmZkZTQ0MTM3MWUyMzg3ZWQ4MmE0YzY5OGMxNDJhZmRjMjc2MTg3YmM1NDRiZTMyOWYifX19");
  }

}
