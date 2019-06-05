package net.timelegacy.tlhub.cosmetics.menu;

import java.util.Arrays;
import net.timelegacy.tlcore.utils.Chat.ChatUtils;
import net.timelegacy.tlcore.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class YourProfileGUI {

  public static String guiName = "&8&lYour Profile";

  public static void openGUI(Player player) {
    Inventory inv = Bukkit.createInventory(null, 9 * 6, guiName);

    inv.setItem(10, ItemUtils.createItem(new ItemStack(Material.EXPERIENCE_BOTTLE), "&eYour Character",
        Arrays.asList(
            "&7Below is your character, for now",
            "&7It only shows the current playtime",
            "&7You have gathered on the server so far.")));
    inv.setItem(13, ItemUtils.createItem(new ItemStack(Material.EXPERIENCE_BOTTLE), "&eProperties",
        Arrays.asList(
            "&7Below you will find three items.",
            "&bConversation&7, &bGender&7, and &bFriends.")));
    inv.setItem(16, ItemUtils.createItem(new ItemStack(Material.EXPERIENCE_BOTTLE), "&eCurrent State",
        Arrays.asList(
            "&7Below is your &b&lSTATE&7. States are different",
            "&7ways of showing your activity. They also effect",
            "&7how you interact with the server.",
            "",
            "&7By default, you are set to",
            "&7the &b&lACTIVE&7 state.")));

//    inv.setItem(19, ItemUtils.createSkullItem(player.getName(), "&e" + player.getName(),
//        Collections
//            .singletonList("&bPlaytime&7: &a" + Utils.formatTime(Database.getTotalOnlineTime(player.getUniqueId())))));

    inv.setItem(21, ItemUtils.createItem(new ItemStack(Material.PAPER), "&aParties",
        Arrays.asList(
            "&7This allows for you to create parties",
            "&7while you are in the hub for you and",
            "&7your friends to venture out on TimeLegacy!",
            "",
            "&b&lComing Soon!")));

//    inv.setItem(22, ItemUtils.createItem(new ItemStack(Material.INK_SAC, 1, (byte) Database.getGender(player)),
//        "&aGender",
//        Arrays.asList(
//            "&7Choose between being a &b&lMALE&7,",
//            "&d&lFEMALE, &7&lOTHER&7.",
//            "",
//            "&7&oThis doesn't affect anything.",
//            "&7&oIt's just here for Role-playing aspects.")));

    inv.setItem(23, ItemUtils.createItem(new ItemStack(Material.EMERALD), "&aFriends",
        Arrays.asList(
            "&7This allows you to manage your",
            "&7friends list. Check requests, remove",
            "&7demons, and add new people!",
            "",
            "&b&lComing Soon!")));

    //		ItemStack active = ItemUtils.createItem(new ItemStack(Material.BANNER, 1, (byte) 10),
    // Utils.color("&a&lACTIVE"),
    //        Arrays.asList(
    //            "&7You will:",
    //            "&a• &7Receive Messages",
    //            "&a• &7Receive Party Invites",
    //            "",
    //            "&7Players will be able to:",
    //            "&a• &7Interact with you."));
    //    ItemStack away = ItemUtils.createItem(new ItemStack(Material.BANNER, 1, (byte) 11),
    // Utils.color("&e&lAWAY"),
    //        Arrays.asList(
    //            "&7You will:",
    //            "&a• &7Receive Messages",
    //            "&c• &7Not Receive Party Invites",
    //            "",
    //            "&7Players will be able to:",
    //            "&c• &7Not interact with you."));
    //    ItemStack doNotDisturb = ItemUtils.createItem(new ItemStack(Material.BANNER, 1, (byte) 1),
    // Utils.color("&c&lDO NOT DISTURB"),
    //        Arrays.asList(
    //            "&7You will:",
    //            "&c• &7Not Receive Messages",
    //            "&c• &7Not Receive Party Invites",
    //            "",
    //            "&7Players will be able to:",
    //            "&c• &7Not interact with you."));
    //
    //    switch (Utils.getStateName(p)) {
    //      case "&a&lACTIVE":
    //        inv.setItem(16, active);
    //        break;
    //      case "&e&lAWAY":
    //        inv.setItem(16, away);
    //        break;
    //      case "&c&lDO NOT DISTURB":
    //        inv.setItem(16, doNotDisturb);
    //        break;
    //    }

    inv.setItem(25, ItemUtils.createItem(Material.COMPARATOR, ChatUtils.colorChat("&eSettings")));

    //		inv.setItem(16, ItemUtils.createItem(Utils.getStateItem(p), Utils.getStateName(p),
    // Arrays.asList(
    //				"&7Depending on your state, you might not be",
    //				"&7able to receive messages through your mail.",
    //				"",
    //				"&7If you are in the &c&lDO NOT DISTURB&7 state,",
    //				"&7you will not be able to receive messages.",
    //				"&7However, if you are in the &a&lACTIVE &7state,",
    //				"&7you will be able to. ",
    //				"&7The &e&lAWAY &7state means that you were put",
    //				"&7in the AFK lobby for being AFK too long.",
    //				"",
    //				"&7If you choose to be in the &e&lAWAY&7 state.",
    //				"&7You will be able to receive messages but",
    //				"&7only in the AFK lobby.")));

//    inv.setItem(
//        40,
//        ItemUtils.createNMSSkullItem(
//            ItemUtils.createSkullItem(player.getName(), ChatUtils.colorChat("&eSocial Media")),
//            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY4NWEwYmU3NDNlOTA2N2RlOTVjZDhjNmQxYmEyMWFiMjFkMzczNzFiM2Q1OTcyMTFiYjc1ZTQzMjc5In19fQ=="));

    player.openInventory(inv);
  }

  public static void clicked(Player player, int slot, ItemStack is, Inventory inv) {
    if (!is.hasItemMeta()) {
      return;
    }
    String name = is.getItemMeta().getDisplayName();

    if (name.equals(ChatUtils.colorChat("&aGender"))) {
      //GenderSelectorGUI.openGUI(player);
      return;
    }

    if (name.equals(ChatUtils.colorChat("&a&lACTIVE"))
        || name.equals(ChatUtils.colorChat("&e&lAWAY"))
        || name.equals(ChatUtils.colorChat("&c&lDO NOT DISTURB"))) {
      if (name.equals(ChatUtils.colorChat("&a&lACTIVE"))) {
       // Database.updateMode(player.getUniqueId(), 1);
        openGUI(player);
        return;
      }

      if (name.equals(ChatUtils.colorChat("&e&lAWAY"))) {
        //Database.updateMode(player.getUniqueId(), 2);
        openGUI(player);
        return;
      }

      if (name.equals(ChatUtils.colorChat("&c&lDO NOT DISTURB"))) {
        //Database.updateMode(player.getUniqueId(), 0);
        openGUI(player);
        return;
      }

      openGUI(player);
      return;
    }

    if (name.equalsIgnoreCase(ChatUtils.colorChat("&eSettings"))) {
      //YourSettingsGUI.openGUI(player);
    }

    if (name.equals(ChatUtils.colorChat("&eSocial Media"))) {
      //YourSocialMediaGUI.openGUI(player);
      return;
    }
    //
    //    if (name.equals(ChatUtils.colorChat("&aConversations"))) {
    //      YourConversationsGUI.openGUI(player);
    //    }

  }
}
