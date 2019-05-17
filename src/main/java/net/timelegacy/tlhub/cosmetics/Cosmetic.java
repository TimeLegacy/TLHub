package net.timelegacy.tlhub.cosmetics;

import java.util.regex.Pattern;
import net.timelegacy.tlcore.utils.SkullCreator;
import net.timelegacy.tlhub.TLHub;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Cosmetic {

  private final String perkPerm;
  private final String name;
  private final Material material;
  private final String slogan;
  private final String skullValue;

  private TLHub lobby = TLHub.getInstance();

  public Cosmetic(String perkPerm, Material material, String name, String slogan,
      String skullValue) {
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
      itemStack = lobby.core.itemUtils.createItem(
          SkullCreator.itemFromBase64(skullValue), 1, lobby.core.messageUtils.SECOND_COLOR + name,
          lobby.core.messageUtils.MAIN_COLOR + slogan);
    } else {
      itemStack = lobby.core.itemUtils
          .createItem(material, 1, lobby.core.messageUtils.SECOND_COLOR + name,
              lobby.core.messageUtils.MAIN_COLOR + slogan);
    }

    return itemStack;
  }

  public String getSkullValue() {
    return skullValue;
  }

}
