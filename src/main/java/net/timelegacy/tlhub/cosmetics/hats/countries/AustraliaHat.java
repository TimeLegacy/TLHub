package net.timelegacy.tlhub.cosmetics.hats.countries;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class AustraliaHat extends Hat {

  public AustraliaHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.COUNTRIES);
    setName("Australia Hat");
    setDisplayName(getRarity().getColor() + "Australia Hat");
    setPermissionNode("hub.cosmetics.hats.australia");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2Y0YWEyYTI0NDc4NGQ0OGIxNTVmZjA0NGI4Y2Y5NmRmNWJkNGU4N2UwMTkyNGE3NWQ2MmE5MjQyYTE2Y2YifX19");
  }

}
