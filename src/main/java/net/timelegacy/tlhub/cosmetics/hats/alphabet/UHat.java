package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class UHat extends Hat {

  public UHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("U Hat");
    setDisplayName(getRarity().getColor() + "'U' Hat");
    setPermissionNode("hub.cosmetics.hats.u");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDEwZjNjY2VkMjJkNjkxMjRkZjg5NWU5MjgxNTVhMDc4OGMxZjRkNWI3YjgyYTNjMmNhOWE0MzZkZTRhZSJ9fX0=");
  }

}
