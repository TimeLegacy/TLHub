package net.timelegacy.tlhub.cosmetics.menu;

import com.google.common.base.Strings;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MenuUtils {

  private static TLHub plugin = TLHub.getPlugin();

  public static int roundUp(double d) {
    return (d > (int) d) ? (int) d + 1 : (int) d;
  }

  public static void displayGUIError(Inventory inv, int slot, ItemStack is, ItemStack errorIs, int seconds) {
    inv.setItem(slot, errorIs);
    Bukkit.getScheduler().runTaskLater(plugin, () -> inv.setItem(slot, is), seconds * 20);
  }

  public static String centerTitle(String title) {
    return Strings.repeat(" ", 26 - ChatColor.stripColor(title).length()) + MessageUtils.colorize(title);
  }
}
