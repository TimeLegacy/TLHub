package net.timelegacy.tlhub.cosmetics.hats.monsters;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class WitherHat extends Hat {

  public WitherHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MONSTERS);
    setName("Wither Hat");
    setDisplayName(getRarity().getColor() + "Wither Hat");
    setPermissionNode("hub.cosmetics.hats.wither");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2RmNzRlMzIzZWQ0MTQzNjk2NWY1YzU3ZGRmMjgxNWQ1MzMyZmU5OTllNjhmYmI5ZDZjZjVjOGJkNDEzOWYifX19");
  }

}
