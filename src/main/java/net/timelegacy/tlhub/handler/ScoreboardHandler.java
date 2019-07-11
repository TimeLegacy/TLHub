package net.timelegacy.tlhub.handler;

import net.timelegacy.tlcore.datatype.PlayerProfile;
import net.timelegacy.tlcore.handler.CoinHandler;
import net.timelegacy.tlcore.handler.CrateKeyHandler;
import net.timelegacy.tlcore.handler.ServerHandler;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlcore.utils.ScoreboardUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardHandler {

  public static void setupScoreBoard() {
    Scoreboard board = ScoreboardUtils.getScoreboard();
    Objective stats = board.registerNewObjective("stats", "dummy");

    stats.setDisplaySlot(DisplaySlot.SIDEBAR);
    stats.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "TIME LEGACY");

    Team spacer1 = board.registerNewTeam("spacer1");
    spacer1.addEntry("§1");
    stats.getScore("§1").setScore(9);

    String serverString = ChatColor.WHITE + "Server: " + ChatColor.GRAY
        + MessageUtils.friendlyify(ServerHandler.getType(ServerHandler.getServerUUID()));
    Team server = board.registerNewTeam("server");
    server.addEntry(serverString);
    stats.getScore(serverString).setScore(8);


    String statusString = ChatColor.WHITE + "Status: ";
    Team status = board.registerNewTeam("status");
    status.addEntry(statusString);
    stats.getScore(statusString).setScore(7);

    Team spacer2 = board.registerNewTeam("spacer2");
    spacer2.addEntry("§2");
    stats.getScore("§2").setScore(6);

    String discoveriesString = ChatColor.WHITE + "Discoveries: ";
    Team discoveries = board.registerNewTeam("discoveries");
    discoveries.addEntry(discoveriesString);
    stats.getScore(discoveriesString).setScore(5);

    String tokensString = ChatColor.WHITE + "Tokens: ";
    Team tokens = board.registerNewTeam("tokens");
    tokens.addEntry(tokensString);
    stats.getScore(tokensString).setScore(4);

    String keysString = ChatColor.WHITE + "Crates: ";
    Team keys = board.registerNewTeam("crates");
    keys.addEntry(keysString);
    stats.getScore(keysString).setScore(3);

    Team spacer3 = board.registerNewTeam("spacer3");
    spacer3.addEntry("§3");
    stats.getScore("§3").setScore(2);

    String ipString = ChatColor.YELLOW + "play.timelegacy.net";
    Team ip = board.registerNewTeam("ip");
    ip.addEntry(ipString);
    stats.getScore(ipString).setScore(1);
  }

  public static void updateEverything(Player player) {
    updateStatus(player);
    updateDiscoveries(player);
    updateTokens(player);
    updateCrates(player);

  }

  public static void updateDiscoveries(Player player) {
    player.getScoreboard().getTeam("discoveries").setSuffix(ChatColor.LIGHT_PURPLE.toString()
        + DiscoveriesHandler.getExploredDiscoveries(player)
        + ChatColor.GRAY
        + "/"
        + ChatColor.LIGHT_PURPLE
        + DiscoveriesHandler.getTotalAvailableDiscoveries());
  }

  public static void updateTokens(Player player) {
    player.getScoreboard().getTeam("tokens").setSuffix(ChatColor.AQUA.toString() + CoinHandler.getBalance(player.getUniqueId()));
  }

  public static void updateCrates(Player player) {
    player.getScoreboard().getTeam("crates").setSuffix(ChatColor.GOLD.toString() + CrateKeyHandler.getBalance(player.getUniqueId()));
  }

  public static void updateStatus(Player player) {// TODO Fix status once API is setup
    PlayerProfile playerProfile = new PlayerProfile(player.getUniqueId());
    String status = ChatColor.GRAY + "?";

    switch (playerProfile.getStatus().toString()) {
      case "ACTIVE":
        status = ChatColor.GREEN + "ACTIVE";
        break;
      case "AWAY":
        status = ChatColor.YELLOW + "AWAY";
        break;
      case "DND":
        status = ChatColor.RED + "DO NOT DISTURB";
        break;
    }

    player.getScoreboard().getTeam("status").setSuffix(status);
  }
}
