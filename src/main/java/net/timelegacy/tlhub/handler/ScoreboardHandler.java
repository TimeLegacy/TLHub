package net.timelegacy.tlhub.handler;

import net.timelegacy.tlcore.handler.ServerHandler;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;


public class ScoreboardHandler {

  TLHub lobby = TLHub.getInstance();

  public void updateBoard() {
      new BukkitRunnable() {
      public void run() {
          if (Bukkit.getServer().getOnlinePlayers().size() > 0) {
          for (Player p : Bukkit.getOnlinePlayers()) {
            p.setScoreboard(scoreBoard(p));
          }
        }
      }
      }.runTaskTimerAsynchronously(lobby, 0, 20);
  }

  public Scoreboard scoreBoard(Player player) {
    ScoreboardManager manager = Bukkit.getScoreboardManager();
    Scoreboard board = manager.getNewScoreboard();
    Objective stats = board.registerNewObjective("stats", "dummy");
      //TODO Remove this shit once you make static methods
      MessageUtils messageUtils = new MessageUtils();
      ServerHandler serverHandler = new ServerHandler();
    // Objective coins = board.registerNewObjective("coins",
    // "dummy");

    stats.setDisplaySlot(DisplaySlot.SIDEBAR);
      stats.setDisplayName(lobby.core.messageUtils.c(ChatColor.DARK_RED + "" + ChatColor.BOLD + "TIME LEGACY"));

      Score spacer1 = stats.getScore(lobby.core.messageUtils.c(""));
      spacer1.setScore(9); // Integer only!

      Score server = stats
              .getScore(lobby.core.messageUtils.c(ChatColor.WHITE + "Server: " + ChatColor.GRAY + messageUtils.friendlyify(serverHandler.getType(lobby.core.serverHandler.getServerUID()))));
      server.setScore(8); // Integer only!
      //TODO Fix status once API is setup
      Score status = stats.getScore(lobby.core.messageUtils
              .c(ChatColor.WHITE + "Status: " + ChatColor.GRAY + "?"));
      status.setScore(7); // Integer only!

      Score spacer2 = stats.getScore(lobby.core.messageUtils.c(""));
      spacer2.setScore(6); // Integer only!

      Score tokens = stats.getScore(lobby.core.messageUtils
              .c(ChatColor.WHITE + "Tokens: " + ChatColor.AQUA + lobby.core.coinHandler
            .getBalance(player.getName())));
      tokens.setScore(5); // Integer only!


      Score discoveries = stats
              .getScore(lobby.core.messageUtils.c(lobby.core.messageUtils.MAIN_COLOR + "Discoveries: " + ChatColor.DARK_PURPLE + "?"/*TODO Replace this with the api for it*/ + ChatColor.GRAY + "/" + ChatColor.DARK_PURPLE + "23" /*TODO Replace this with the API once its done*/));
      discoveries.setScore(4); // Integer only!


      Score keys = stats
              .getScore(lobby.core.messageUtils.c(ChatColor.WHITE + "Crates: " + ChatColor.GOLD + lobby.core.crateKeyHandler.getKeys(player)));
      keys.setScore(3); // Integer only!

      Score spacer3 = stats.getScore(lobby.core.messageUtils.c(""));
    spacer3.setScore(2); // Integer only!

    Score ip = stats.getScore(
            lobby.core.messageUtils.c(ChatColor.YELLOW + "" + ChatColor.BOLD + "play.timelegacy.net"));
    ip.setScore(1); // Integer only!

    return board;
  }
}
