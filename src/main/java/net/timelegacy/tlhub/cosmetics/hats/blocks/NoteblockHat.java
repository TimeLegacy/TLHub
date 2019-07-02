package net.timelegacy.tlhub.cosmetics.hats.blocks;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class NoteblockHat extends Hat {

  public NoteblockHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.BLOCKS);
    setName("Noteblock Hat");
    setDisplayName(getRarity().getColor() + "Noteblock Hat");
    setPermissionNode("hub.cosmetics.hats.noteblock");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGNlZWI3N2Q0ZDI1NzI0YTljYWYyYzdjZGYyZDg4Mzk5YjE0MTdjNmI5ZmY1MjEzNjU5YjY1M2JlNDM3NmUzIn19fQ==");
  }

}
