package net.timelegacy.tlhub.cosmetics.hats.animals;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class MonkeyHat extends Hat {

  public MonkeyHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ANIMALS);
    setName("Monkey Hat");
    setDisplayName(getRarity().getColor() + "Monkey Hat");
    setPermissionNode("hub.cosmetics.hats.monkey");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTdiYTUzNjU0Yzc5MjY1NjIzYjBhYWM2ZDJjNjExZmU4NjFiN2ZhMjJiMzkyZWY0MzY3NGMxMWQ4YzgyMTRjIn19fQ==");
  }

}
