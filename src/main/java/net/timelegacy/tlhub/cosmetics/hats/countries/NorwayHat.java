package net.timelegacy.tlhub.cosmetics.hats.countries;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class NorwayHat extends Hat {

  public NorwayHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.COUNTRIES);
    setName("Norway Hat");
    setDisplayName(getRarity().getColor() + "Norway Hat");
    setPermissionNode("hub.cosmetics.hats.norway");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTA1OTZlMTY1ZWMzZjM4OWI1OWNmZGRhOTNkZDZlMzYzZTk3ZDljNjQ1NmU3YzJlMTIzOTczZmE2YzVmZGEifX19");
  }

}
