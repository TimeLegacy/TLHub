package net.timelegacy.tlhub.cosmetics.hats.alphabet;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class HHat extends Hat {

  public HHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.ALPHABET);
    setName("H Hat");
    setDisplayName(getRarity().getColor() + "'H' Hat");
    setPermissionNode("hub.cosmetics.hats.h");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDAzNDQzM2Q0MDM1MWU5NTQxMjhlODM2ZjIyZDliYmY2N2FjMTNhZGZjN2Q2NTJmNjNhNDJhN2Q3ODhhZjFkIn19fQ==");
  }

}
