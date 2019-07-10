package net.timelegacy.tlhub.cosmetics.hats.blocks;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class StickyPistonHat extends Hat {

  public StickyPistonHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.BLOCKS);
    setName("Sticky Piston Hat");
    setDisplayName(getRarity().getColor() + "Sticky Piston Hat");
    setPermissionNode("hub.cosmetics.hats.sticky_piston");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2NhNGQyMThkZjlkMzJjZDQ3ZDljMWQyOTQ4NzcxMjJiZTU5MTliNDE4YTZjYzNkMDg5MTYyYjEzM2YyZGIifX19");
  }

}
