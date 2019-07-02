package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class KHat extends Hat {

  public KHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("K Hat");
    setDisplayName(getRarity().getColor() + "'K' Hat");
    setPermissionNode("hub.cosmetics.hats.k");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODBiMTNjNzE2NjYyODdjNTk4OWQ4NTEwMWRiN2M2NTUwZTJlMDcwNzZkYjUyYTdiYmJiYmRkYjg0OTMxMjkifX19");
  }

}
