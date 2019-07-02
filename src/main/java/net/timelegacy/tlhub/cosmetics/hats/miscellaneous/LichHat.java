package net.timelegacy.tlhub.cosmetics.hats.miscellaneous;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class LichHat extends Hat {

  public LichHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MISCELLANEOUS);
    setName("Lich Hat");
    setDisplayName(getRarity().getColor() + "Lich Hat");
    setPermissionNode("hub.cosmetics.hats.lich");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTE2ODAyZGQwMDkzODY5M2U0NGMyNjM2NzhmMTJhYTU5YjRkYTlkMjUxM2Q1NTZmYzkwMzkwZTA1ODg0YWI3ZSJ9fX0=");
  }

}
