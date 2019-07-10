package net.timelegacy.tlhub.cosmetics.hats.countries;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class IrelandHat extends Hat {

  public IrelandHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.COUNTRIES);
    setName("Ireland Hat");
    setDisplayName(getRarity().getColor() + "Ireland Hat");
    setPermissionNode("hub.cosmetics.hats.ireland");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWNhN2Q4ZDczZTlkNGE4YzAyMWZmOTE4NDVkNjFlMDQxOTg3NjkxOWUwZDdhMTMzOGQ4YzdkZTBlZjk1ZDIifX19");
  }

}
