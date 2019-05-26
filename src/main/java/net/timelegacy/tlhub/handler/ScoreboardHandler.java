package net.timelegacy.tlhub.handler;

import net.timelegacy.tlcore.handler.CoinHandler;
import net.timelegacy.tlcore.handler.CrateKeyHandler;
import net.timelegacy.tlcore.handler.ServerHandler;
import net.timelegacy.tlcore.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScoreboardHandler {

  public static Scoreboard setupScoreBoard() {
    ScoreboardManager manager = Bukkit.getScoreboardManager();
    Scoreboard board = manager.getNewScoreboard();
    Objective stats = board.registerNewObjective("stats", "dummy");

    stats.setDisplaySlot(DisplaySlot.SIDEBAR);
    stats.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "TIME LEGACY");

    Team spacer1 = board.registerNewTeam("spacer1");
    spacer1.addEntry("§1");
    stats.getScore("§1").setScore(9);

    String serverString =
            ChatColor.WHITE
                    + "Server: "
                    + ChatColor.GRAY
                    + MessageUtils.friendlyify(ServerHandler.getType(ServerHandler.getServerUID()));
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

    return board;
  }

  public static void updateEverything(Player player) {
    updateStatus(player);
    updateDiscoveries(player);
    updateTokens(player);
    updateCrates(player);

  }

  public static void updateDiscoveries(Player player) {
    player
            .getScoreboard()
            .getTeam("discoveries")
            .setSuffix(
                    ChatColor.LIGHT_PURPLE.toString()
                            + DiscoveriesHandler.getDiscoveries(player)
                            + ChatColor.GRAY
                            + "/"
                            + ChatColor.LIGHT_PURPLE
                            + DiscoveriesHandler.getTotalAvailableDiscoveries());
  }

  public static void updateTokens(Player player) {
    player
            .getScoreboard()
            .getTeam("tokens")
            .setSuffix(ChatColor.AQUA.toString() + CoinHandler.getBalance(player.getName()));
  }

  public static void updateCrates(Player player) {
    player
            .getScoreboard()
            .getTeam("crates")
            .setSuffix(ChatColor.GOLD.toString() + CrateKeyHandler.getBalance(player.getName()));
  }

  public static void updateStatus(Player player) {// TODO Fix status once API is setup
    player.getScoreboard().getTeam("status").setSuffix(ChatColor.GRAY + "?");
  }
}
