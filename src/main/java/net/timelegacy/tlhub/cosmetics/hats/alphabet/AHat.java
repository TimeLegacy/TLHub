package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class AHat extends Hat {

  public AHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("A Hat");
    setDisplayName(getRarity().getColor() + "'A' Hat");
    setPermissionNode("hub.cosmetics.hats.a");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGZmODhiMTIyZmY5MjUxM2M2YTI3YjdmNjdjYjNmZWE5NzQzOWUwNzg4MjFkNjg2MWI3NDMzMmEyMzk2In19fQ==");
  }
}
