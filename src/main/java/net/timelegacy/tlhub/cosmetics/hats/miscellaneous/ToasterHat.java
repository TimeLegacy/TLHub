package net.timelegacy.tlhub.cosmetics.hats.miscellaneous;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class ToasterHat extends Hat {

  public ToasterHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MISCELLANEOUS);
    setName("Toaster Hat");
    setDisplayName(getRarity().getColor() + "Toaster Hat");
    setPermissionNode("hub.cosmetics.hats.toaster");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmM0NWUzNDNhODMzZTNhMGEzZWU0YjFhMThiNjEyMjk2MDYwNmY0Y2JlMjVjYjk3MTkxNGJjZWViZDkzMmYzZCJ9fX0=");
  }

}
