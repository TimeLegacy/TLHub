package net.timelegacy.tlhub.handler;

import net.timelegacy.tlcore.handler.CoinHandler;
import net.timelegacy.tlcore.handler.CrateKeyHandler;
import net.timelegacy.tlcore.handler.ServerHandler;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ScoreboardHandler {

  private static TLHub plugin = TLHub.getPlugin();

  public static void updateBoard() {
    new BukkitRunnable() {
      public void run() {
        if (Bukkit.getServer().getOnlinePlayers().size() > 0) {
          for (Player p : Bukkit.getOnlinePlayers()) {
            p.setScoreboard(scoreBoard(p));
          }
        }
      }
    }.runTaskTimer(plugin, 0, 20);
  }

  public static Scoreboard scoreBoard(Player player) {
    ScoreboardManager manager = Bukkit.getScoreboardManager();
    Scoreboard board = manager.getNewScoreboard();
    Objective stats = board.registerNewObjective("stats", "dummy");

    stats.setDisplaySlot(DisplaySlot.SIDEBAR);
    stats.setDisplayName(
        MessageUtils.colorize(ChatColor.RED + "" + ChatColor.BOLD + "TIME LEGACY"));

    Score spacer1 = stats.getScore(MessageUtils.colorize("&f"));
    spacer1.setScore(9); // Integer only!

    Score server =
        stats.getScore(
            ChatColor.WHITE
                + "Server: "
                + ChatColor.GRAY
                + MessageUtils.friendlyify(ServerHandler.getType(ServerHandler.getServerUID())));
    server.setScore(8); // Integer only!
    // TODO Fix status once API is setup
    Score status = stats.getScore(ChatColor.WHITE + "Status: " + ChatColor.GRAY + "?");
    status.setScore(7); // Integer only!

    Score spacer2 = stats.getScore(MessageUtils.colorize("&7"));
    spacer2.setScore(6); // Integer only!

    Score tokens =
        stats.getScore(
            ChatColor.WHITE
                + "Tokens: "
                + ChatColor.AQUA
                + CoinHandler.getBalance(player.getName()));
    tokens.setScore(5); // Integer only!

    Score discoveries =
        stats.getScore(
            ChatColor.WHITE
                + "Discoveries: "
                + ChatColor.LIGHT_PURPLE
                + "?" /*TODO Replace this with the api for it*/
                + ChatColor.GRAY
                + "/"
                + ChatColor.LIGHT_PURPLE
                + "23" /*TODO Replace this with the API once its done*/);
    discoveries.setScore(4); // Integer only!

    Score keys =
        stats.getScore(
            ChatColor.WHITE
                + "Crates: "
                + ChatColor.GOLD
                + CrateKeyHandler.getBalance(player.getName()));
    keys.setScore(3); // Integer only!

    Score spacer3 = stats.getScore(MessageUtils.colorize("&8"));
    spacer3.setScore(2); // Integer only!

    Score ip = stats.getScore(ChatColor.YELLOW + "play.timelegacy.net");
    ip.setScore(1); // Integer only!

    return board;
  }
}
