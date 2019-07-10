package net.timelegacy.tlhub.cosmetics.hats.food;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class MelonHat extends Hat {

  public MelonHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.FOOD);
    setName("Melon Hat");
    setDisplayName(getRarity().getColor() + "Melon Hat");
    setPermissionNode("hub.cosmetics.hats.melon");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzQxMTRlMmMxN2VkMjAyMzA5ODYzYjVmNjRlM2QxOGI4NmNjZjljYTNkYmJlYTJiOTM0YWQ2YTVhYWFmOWQ4MyJ9fX0=");
  }

}
