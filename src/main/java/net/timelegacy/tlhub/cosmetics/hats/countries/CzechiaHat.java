package net.timelegacy.tlhub.cosmetics.hats.countries;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class CzechiaHat extends Hat {

  public CzechiaHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.COUNTRIES);
    setName("Czechia Hat");
    setDisplayName(getRarity().getColor() + "Czechia Hat");
    setPermissionNode("hub.cosmetics.hats.czechia");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDgxNTJiNzMzNGQ3ZWNmMzM1ZTQ3YTRmMzVkZWZiZDJlYjY5NTdmYzdiZmU5NDIxMjY0MmQ2MmY0NmU2MWUifX19");
  }

}
