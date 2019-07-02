package net.timelegacy.tlhub.cosmetics.hats.monsters;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class SlimeHat extends Hat {

  public SlimeHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.MONSTERS);
    setName("Slime Hat");
    setDisplayName(getRarity().getColor() + "Slime Hat");
    setPermissionNode("hub.cosmetics.hats.slime");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTZmMGJlY2Y2ZmQ2ZmE4YjEwZDU5MmI1OThiMjg3N2IzMTdiMzAxNjdjNDcwZDQyNzU4NzVlYTA5MDg3In19fQ==");
  }

}
