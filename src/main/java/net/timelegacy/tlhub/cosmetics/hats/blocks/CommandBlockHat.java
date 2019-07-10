package net.timelegacy.tlhub.cosmetics.hats.blocks;

import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.enums.Category;
import net.timelegacy.tlhub.enums.Rarity;

public class CommandBlockHat extends Hat {

  public CommandBlockHat() {
    setRarity(Rarity.COMMON);
    setCategory(Category.BLOCKS);
    setName("Command Block Hat");
    setDisplayName(getRarity().getColor() + "Command Block Hat");
    setPermissionNode("hub.cosmetics.hats.command_block");
    setTextureValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjBkYzY4YWI2M2FkNWJhNjE5NjlmZjBiODk3MDEyYjcyMTM2Yzg2Mjk2MWM4NjA1ZDIyOTQwMDdjMDdlZjU4In19fQ==");
  }

}
