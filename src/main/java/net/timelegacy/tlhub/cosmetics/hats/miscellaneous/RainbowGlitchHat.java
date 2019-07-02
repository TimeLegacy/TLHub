package net.timelegacy.tlhub.cosmetics.hats.miscellaneous;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class RainbowGlitchHat extends Hat {

  public RainbowGlitchHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MISCELLANEOUS);
    setName("Rainbow Glitch Hat");
    setDisplayName(getRarity().getColor() + "Rainbow Glitch Hat");
    setPermissionNode("hub.cosmetics.hats.rainbow_glitch");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDFmZTI3YTEzYzVmYzE3NTE1Y2FlNjk1ODUyNzE2MzI2YjJiNWRmNDdkOGQ2Yjk1YTc4OWFlMzhjYWM3YjEifX19");
  }

}
