package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class VHat extends Hat {

  public VHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("V Hat");
    setDisplayName(getRarity().getColor() + "'V' Hat");
    setPermissionNode("hub.cosmetics.hats.v");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDUzZGE0Y2M4NDIxMDNjMjA1MTI3Nzg3OGY0YTUyZWQ0YzM5YTkyZjRiZDY0NGU4NTczZjM1NmY0NmJhY2EifX19");
  }

}
