package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class PandaHat extends Hat {

  public PandaHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Panda Hat");
    setDisplayName(getRarity().getColor() + "Panda Hat");
    setPermissionNode("hub.cosmetics.hats.panda");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGNhMDk2ZWVhNTA2MzAxYmVhNmQ0YjE3ZWUxNjA1NjI1YTZmNTA4MmM3MWY3NGE2MzljYzk0MDQzOWY0NzE2NiJ9fX0=");
  }

}
