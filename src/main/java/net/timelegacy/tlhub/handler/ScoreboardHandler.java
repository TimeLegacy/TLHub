package net.timelegacy.tlhub.handler;

import net.timelegacy.tlcore.datatype.CustomScoreboard;
import net.timelegacy.tlcore.datatype.PlayerProfile;
import net.timelegacy.tlcore.handler.CoinHandler;
import net.timelegacy.tlcore.handler.CrateKeyHandler;
import net.timelegacy.tlcore.handler.ServerHandler;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlcore.utils.ScoreboardUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ScoreboardHandler {

  public static void setupScoreBoard(Player player) {
    CustomScoreboard sb =
        new CustomScoreboard(player, ChatColor.RED + "" + ChatColor.BOLD + "TIME LEGACY");
    sb.create();
    sb.setLine(
        0,
        MessageUtils.colorize(
            "&1")); // -> Important not to leave empty, color code helps to avoid worries//
    sb.setLine(
        1,
        ChatColor.WHITE
            + "Server: "
            + ChatColor.GRAY
            + MessageUtils.friendlyify(ServerHandler.getType(ServerHandler.getServerUUID())));
    sb.setLine(2, ChatColor.WHITE + "Status: ");
    sb.setLine(3, MessageUtils.colorize("&2"));
    sb.setLine(4, ChatColor.WHITE + "Discoveries: ");
    sb.setLine(5, ChatColor.WHITE + "Coins: ");
    sb.setLine(6, ChatColor.WHITE + "Crates: ");
    sb.setLine(7, MessageUtils.colorize("&3"));
    sb.setLine(8, ChatColor.YELLOW + "play.timelegacy.net");

    ScoreboardUtils.saveCustomScoreboard(player.getUniqueId(), sb);
  }

  public static void updateEverything(Player player) {
    updateStatus(player);
    updateDiscoveries(player);
    updateTokens(player);
    updateCrates(player);
  }

  public static void updateDiscoveries(Player player) {
    CustomScoreboard sb = ScoreboardUtils.getCustomScoreboard(player.getUniqueId());
    sb.setLine(
        4,
        ChatColor.WHITE
            + "Discoveries: "
            + ChatColor.LIGHT_PURPLE.toString()
            + DiscoveriesHandler.getExploredDiscoveries(player)
            + ChatColor.GRAY
            + "/"
            + ChatColor.LIGHT_PURPLE
            + DiscoveriesHandler.getTotalAvailableDiscoveries());
  }

  public static void updateTokens(Player player) {
    CustomScoreboard sb = ScoreboardUtils.getCustomScoreboard(player.getUniqueId());
    sb.setLine(
        5,
        ChatColor.WHITE
            + "Coins: "
            + ChatColor.AQUA.toString()
            + CoinHandler.getBalance(player.getUniqueId()));
  }

  public static void updateCrates(Player player) {
    CustomScoreboard sb = ScoreboardUtils.getCustomScoreboard(player.getUniqueId());
    sb.setLine(
        6,
        ChatColor.WHITE
            + "Crates: "
            + ChatColor.GOLD.toString()
            + CrateKeyHandler.getBalance(player.getUniqueId()));
  }

  public static void updateStatus(Player player) { // TODO Fix status once API is setup
    PlayerProfile playerProfile = new PlayerProfile(player.getUniqueId());
    String status = ChatColor.GRAY + "?";

    switch (playerProfile.getStatus().toString()) {
      case "ACTIVE":
        status = ChatColor.GREEN + "" + ChatColor.BOLD + "ACTIVE";
        break;
      case "AWAY":
        status = ChatColor.YELLOW + "" + ChatColor.BOLD + "AWAY";
        break;
      case "DND":
        status = ChatColor.RED + "" + ChatColor.BOLD + "DND";
        break;
    }

    CustomScoreboard sb = ScoreboardUtils.getCustomScoreboard(player.getUniqueId());
    sb.setLine(2, ChatColor.WHITE + "Status: " + status);
  }
}
