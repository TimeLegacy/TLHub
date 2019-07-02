package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class QHat extends Hat {

  public QHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("Q Hat");
    setDisplayName(getRarity().getColor() + "'Q' Hat");
    setPermissionNode("hub.cosmetics.hats.q");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTgyMTc4MzdhNjNlNzRlMjRiYWZkNmM3YzUwMGQzNjc4YTY4MzhlZDg2MjE1YTc5ZjE2ZDQ5NjI3MDFmM2EifX19");
  }

}
