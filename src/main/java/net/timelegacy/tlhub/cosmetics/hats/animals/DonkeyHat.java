package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class DonkeyHat extends Hat {

  public DonkeyHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Donkey Hat");
    setDisplayName(getRarity().getColor() + "Donkey Hat");
    setPermissionNode("hub.cosmetics.hats.donkey");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjNhOTc2YzA0N2Y0MTJlYmM1Y2IxOTcxMzFlYmVmMzBjMDA0YzBmYWY0OWQ4ZGQ0MTA1ZmNhMTIwN2VkYWZmMyJ9fX0=");
  }

}
