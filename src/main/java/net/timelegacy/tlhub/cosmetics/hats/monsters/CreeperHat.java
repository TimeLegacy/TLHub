package net.timelegacy.tlhub.cosmetics.hats.monsters;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class CreeperHat extends Hat {

  public CreeperHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MONSTERS);
    setName("Creeper Hat");
    setDisplayName(getRarity().getColor() + "Creeper Hat");
    setPermissionNode("hub.cosmetics.hats.creeper");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODMxYmEzOWExNmNhNDQyY2FiOTM1MDQwZGRjNzI2ZWRhZDlkZDI3NmVjZmFmNmZlZTk5NzY3NjhiYjI3NmJjMCJ9fX0=");
  }

}
