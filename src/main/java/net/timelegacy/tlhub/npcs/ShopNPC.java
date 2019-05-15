package net.timelegacy.tlhub.npcs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.timelegacy.tlhub.TLHub;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopNPC implements Listener {

  public HashMap<String, ShopItem> items = new HashMap<String, ShopItem>();
  TLHub lobby = TLHub.getInstance();

  public void loadShopItems() {
    for (ShopItem i : ShopItem.values()) {
      items.put(i.getName(), i);
      Bukkit.broadcastMessage(i.getName());
    }
  }

  public void openShop(ShopType s, Player p) {
    Inventory inv = Bukkit.createInventory(p, 9, lobby.core.messageUtils
        .c("&5Shop &7" + cleanUpName(lobby.core.messageUtils.friendlyify(s.toString()))));

    if (s == ShopType.SURVIVAL_GAMES_CHALLENGES) {
      inv.setItem(0, createItem(ShopItem.SGC_PERK_KITS_TIER1, p));
      inv.setItem(1, createItem(ShopItem.SGC_PERK_KITS_TIER2, p));

    } else {
      return;
    }

    p.openInventory(inv);
  }

  private String cleanUpName(String server) {
    String name = "error";

    if (server.equalsIgnoreCase("SGC") || server.equalsIgnoreCase("SurvivalGamesChallenges")) {
      name = "SGChallenges";
    }

    return name;
  }

  public ItemStack createItem(ShopItem si, Player p) {
    List<String> lore = new ArrayList<String>();

    ItemStack is = new ItemStack(si.getMaterial(), 1);
    ItemMeta im = is.getItemMeta();

    im.setDisplayName(si.getName());

    lore.add("&6Cost: &e" + si.getCost() + (si.getCost() == 1 ? " Coin" : " Coins"));
    lore.add("&8&m---------------------------");
    try {
      int playerCoins = lobby.core.coinHandler.getBalance(p.getName());

      /*if (p.hasPermission(si.getNode())) {*/
      if (lobby.core.perkHandler.getPerks(p).contains(si.getNode())) {
        lore.add(lobby.core.messageUtils.c("&cYou already own this item!"));
      } else if (playerCoins >= si.getCost()) {
        lore.add(lobby.core.messageUtils.c("&aYou can purchase this item!"));
      } else {
        int needed = si.getCost() - playerCoins;
        lore.add(lobby.core.messageUtils
            .c("&cYou need &b" + needed + " &cmore Coin" + (needed == 1 ? "" : "s") + "!"));
        //lore.add("&cPurchase Coins at");
        //lore.add("&c&nhttp://shop.arcadecu.be");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    im.setLore(lore);
    is.setItemMeta(im);

    return is;
  }

  @EventHandler
  public void onClick(InventoryClickEvent event) {
    Player p = (Player) event.getWhoClicked();

    if (event.getInventory().getName().startsWith(lobby.core.messageUtils.c("&5Shop &7"))) {
      event.setCancelled(true);
      if (event.getCurrentItem() == null) {
        p.closeInventory();
        return;
      }
      if (!event.getCurrentItem().hasItemMeta()) {
        p.closeInventory();
        return;
      }
      if (event.getCurrentItem().hasItemMeta() && !event.getCurrentItem().getItemMeta().hasLore()) {
        p.closeInventory();
        return;
      }

      if (event.getCurrentItem().getItemMeta().getLore()
          .contains(lobby.core.messageUtils.c("&aYou can purchase this item!"))) {
        ShopItem si = items.get(event.getCurrentItem().getItemMeta().getDisplayName());

        if (si != null) {
          try {
            lobby.core.messageUtils
                .sendMessage(p, "&bYou have purchased this perk!", "&6Coins&8: &7");

            lobby.core.perkHandler.addPerk(p, si.getNode());
            lobby.core.coinHandler.removeCoins(p.getName(), si.getCost());
          } catch (Exception e) {
            e.printStackTrace();
            lobby.core.messageUtils.sendMessage(p, "&cError purchasing item!", "&6Coins&8: &7");
          }
        } else {
          lobby.core.messageUtils.sendMessage(p, "&cError purchasing item!", "&6Coins&8: &7");
        }
      } else if (event.getCurrentItem().getItemMeta().getLore()
          .contains(lobby.core.messageUtils.c("&bYou already own this item!"))) {
        lobby.core.messageUtils.sendMessage(p, "&cYou already own this perk!", "&6Coins&8: &7");
      } else if (event.getCurrentItem().getItemMeta().getLore().contains("&cPurchase Coins at")) {
        lobby.core.messageUtils.sendMessage(p, "&cYou cannot afford this perk!", "&6Coins&8: &7");
      }

      p.closeInventory();
    }
  }

  @EventHandler
  public void shop(PlayerInteractEntityEvent event) {
    if (event.getRightClicked() instanceof Villager) {
      event.setCancelled(true);

      lobby.core.messageUtils.sendMessage(event.getPlayer(),
          lobby.core.messageUtils.ERROR_COLOR + "This shop is closed! Come back soon!", true);
    }
  }

  public enum ShopType {
    SURVIVAL_GAMES_CHALLENGES
  }

  public enum ShopItem {
    //GUNBATTLE_PERK_SPEED("&bGunBattle Perk: Speed Lv. 2", "gunbattle.perk.speed", 500, Material.POTION),
    //GUNBATTLE_PERK_GRENADE("&bGunBattle Perk: Grenades", "gunbattle.perk.grenade", 1000, Material.EGG),

    SGC_PERK_KITS_TIER1(TLHub.getInstance().core.messageUtils.c("&aKits - Tier 1"),
        "SGC_PERK_KITS_TIER1", 500, Material.WOODEN_SWORD),
    SGC_PERK_KITS_TIER2(TLHub.getInstance().core.messageUtils.c("&aKits - Tier 2"),
        "SGC_PERK_KITS_TIER2", 1000, Material.IRON_SWORD);

    private final String name;
    private final String node;
    private final int cost;
    private final Material material;

    ShopItem(String name, String node, int cost, Material material) {
      this.name = name;
      this.cost = cost;
      this.node = node;
      this.material = material;
    }

    public String getName() {
      return name;
    }

    public String getNode() {
      return node;
    }

    public int getCost() {
      return cost;
    }

    public Material getMaterial() {
      return material;
    }
  }
}
