package net.timelegacy.tlhub.cosmetics.hats.miscellaneous;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class MasterballHat extends Hat {

  public MasterballHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MISCELLANEOUS);
    setName("Masterball Hat");
    setDisplayName(getRarity().getColor() + "Masterball Hat");
    setPermissionNode("hub.cosmetics.hats.masterball");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGFhMGQ5NDQ2NDJiOGFiNjlmOGI0ZDY2ODczMzEyZTA2YzBkM2ViZjhjMDMxYWQ0Yjg2ODVmOGFhZGI5MWQ1In19fQ==");
  }

}
