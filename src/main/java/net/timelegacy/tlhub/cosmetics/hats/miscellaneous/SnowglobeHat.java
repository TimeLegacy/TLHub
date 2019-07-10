package net.timelegacy.tlhub.cosmetics.hats.miscellaneous;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class SnowglobeHat extends Hat {

  public SnowglobeHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MISCELLANEOUS);
    setName("Snowglobe Hat");
    setDisplayName(getRarity().getColor() + "Snowglobe Hat");
    setPermissionNode("hub.cosmetics.hats.snowglobe");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmRkNjYzMTM2Y2FmYTExODA2ZmRiY2E2YjU5NmFmZDg1MTY2YjRlYzAyMTQyYzhkNWFjODk0MWQ4OWFiNyJ9fX0=");
  }

}
