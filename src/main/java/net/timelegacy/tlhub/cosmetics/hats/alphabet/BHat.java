package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class BHat extends Hat {

  public BHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("B Hat");
    setDisplayName(getRarity().getColor() + "'B' Hat");
    setPermissionNode("hub.cosmetics.hats.b");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTE3MGJiYzc5NDNhYzg3N2NkOTNlOTM3ZjA5ODNjMzQ0MDljMjg1ODhjMTdmNWZkNjhjMjFmZmZlMDg4Y2U2YiJ9fX0=");
  }

}
