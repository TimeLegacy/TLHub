package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class PenguinHat extends Hat {

  public PenguinHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Penguin Hat");
    setDisplayName(getRarity().getColor() + "Penguin Hat");
    setPermissionNode("hub.cosmetics.hats.penguin");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzJmYjQ3ODk0ZDBmYmFkMmEwYTdiNjc1MzY4MGYxYzFkYjBjNThiY2IyN2Y3MmFkOTM3ZmM2OTNlZDMxIn19fQ==");
  }

}
