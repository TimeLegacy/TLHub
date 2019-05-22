package net.timelegacy.tlhub.cosmetics;

import de.erethon.headlib.HeadLib;
import java.util.UUID;
import java.util.regex.Pattern;
import net.timelegacy.tlcore.utils.ItemUtils;
import net.timelegacy.tlcore.utils.MessageUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Cosmetic {

  private final String perkPerm;
  private final String name;
  private final Material material;
  private final String slogan;
  private final String skullValue;

  public Cosmetic(
      String perkPerm, Material material, String name, String slogan, String skullValue) {
    this.perkPerm = perkPerm;
    this.name = name;
    this.material = material;
    this.slogan = slogan;
    this.skullValue = skullValue;
  }

  public String getCosmeticIdentifier() {
    // TODO - FIX THIS & switch to enums
    String[] perkthing = perkPerm.split(Pattern.quote("."));
    String node = perkthing[2];
    return node;
  }

  public String getCosmeticType() {
    // TODO - FIX THIS & switch to enums
    String[] perkthing = perkPerm.split(Pattern.quote("."));
    String node = perkthing[1];
    return node;
  }

  public String getPerkPerm() {
    return perkPerm;
  }

  public ItemStack getItemStack() {
    ItemStack itemStack;

    if (material == null && skullValue != null) {
      ItemStack itemStack1 =
          ItemUtils.createItem(
              Material.PLAYER_HEAD,
              1,
              MessageUtils.SECOND_COLOR + name,
              MessageUtils.MAIN_COLOR + slogan);
      itemStack = HeadLib.setSkullOwner(itemStack1, UUID.randomUUID(), skullValue);
    } else {
      itemStack =
          ItemUtils.createItem(
              material, 1, MessageUtils.SECOND_COLOR + name, MessageUtils.MAIN_COLOR + slogan);
    }

    return itemStack;
  }

  public String getSkullValue() {
    return skullValue;
  }
}
