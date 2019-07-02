package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class LHat extends Hat {

  public LHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("L Hat");
    setDisplayName(getRarity().getColor() + "'L' Hat");
    setPermissionNode("hub.cosmetics.hats.l");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWJmMDcyZTI5NmZkYzhkYTNlMDRjNTYzYTM3NzRkMmRkYmYzZjg2ZDM2YTI4NjdkNTNlM2NjZDFjOWQ0MSJ9fX0=");
  }

}
