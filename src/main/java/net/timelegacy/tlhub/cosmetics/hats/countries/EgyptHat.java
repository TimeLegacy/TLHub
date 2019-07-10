package net.timelegacy.tlhub.cosmetics.hats.countries;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class EgyptHat extends Hat {

  public EgyptHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.COUNTRIES);
    setName("Egypt Hat");
    setDisplayName(getRarity().getColor() + "Egypt Hat");
    setPermissionNode("hub.cosmetics.hats.egypt");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODI2ZTc0MmIzMmYwZjhkYjU5YzA3YjFiY2RkZTZmOGE5M2Y4NWM5MjllNTk4YzdlOTI3M2I5MjExZjJjZTc4In19fQ==");
  }

}
