package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class SharkHat extends Hat {

  public SharkHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Shark Hat");
    setDisplayName(getRarity().getColor() + "Shark Hat");
    setPermissionNode("hub.cosmetics.hats.shark");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjEyNGM1NDFkZWRhNGIyNjZmZjE0ZTYxYjBhMTMyNDRiMmQ0YjdjMThkMmI2YzhkZDIxNzZkNWQzNjVmYmQifX19");
  }

}
