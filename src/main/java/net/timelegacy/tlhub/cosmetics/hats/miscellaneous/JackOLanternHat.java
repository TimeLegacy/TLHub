package net.timelegacy.tlhub.cosmetics.hats.miscellaneous;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class JackOLanternHat extends Hat {

  public JackOLanternHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MISCELLANEOUS);
    setName("Jack O Lantern Hat");
    setDisplayName(getRarity().getColor() + "Jack 'O Lantern Hat");
    setPermissionNode("hub.cosmetics.hats.jack_o_lantern");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmE0MDEwMjFhNzVlN2I1MzdlMzBmYzVlNjI1M2YyYzc1NWM0NzQ3OWRkZTJlNDA4NGNiNWRmZjNhNDZiNzFmZiJ9fX0=");
  }

}
