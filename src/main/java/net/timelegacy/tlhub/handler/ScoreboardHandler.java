package net.timelegacy.tlhub.handler;

import net.timelegacy.tlhub.TLHub;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;


public class ScoreboardHandler {

  TLHub lobby = TLHub.getInstance();

  public void updateBoard() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(TLHub.getInstance(), new Runnable() {
      public void run() {
        if (Bukkit.getOnlinePlayers().size() > 0) {
          for (Player p : Bukkit.getOnlinePlayers()) {
            p.setScoreboard(scoreBoard(p));
          }
        }
      }
    }, 0, 5 * 20);
  }

  public Scoreboard scoreBoard(Player player) {
    ScoreboardManager manager = Bukkit.getScoreboardManager();
    Scoreboard board = manager.getNewScoreboard();
    Objective stats = board.registerNewObjective("stats", "dummy");
    // Objective coins = board.registerNewObjective("coins",
    // "dummy");

    stats.setDisplaySlot(DisplaySlot.SIDEBAR);
    stats.setDisplayName(lobby.core.messageUtils.c("&f&lMineAqua"));

    Score rank1 = stats
        .getScore(lobby.core.messageUtils.c(lobby.core.messageUtils.MAIN_COLOR + "Rank"));
    rank1.setScore(10); // Integer only!

    Score rank2 = stats.getScore(lobby.core.messageUtils
        .c(lobby.core.messageUtils.SECOND_COLOR + lobby.core.messageUtils
            .friendlyify(lobby.core.rankHandler.getRank(player.getName()).getName())));
    rank2.setScore(9); // Integer only!

    Score spacer1 = stats.getScore(lobby.core.messageUtils.c("&a"));
    spacer1.setScore(8); // Integer only!

    Score coins1 = stats
        .getScore(lobby.core.messageUtils.c(lobby.core.messageUtils.MAIN_COLOR + "Coins"));
    coins1.setScore(7); // Integer only!

    Score coins2 = stats.getScore(lobby.core.messageUtils
        .c("&2" + lobby.core.messageUtils.SECOND_COLOR + lobby.core.coinHandler
            .getBalance(player.getName())));
    coins2.setScore(6); // Integer only!

    Score spacer2 = stats.getScore(lobby.core.messageUtils.c("&b"));
    spacer2.setScore(5); // Integer only!

    Score keys1 = stats
        .getScore(lobby.core.messageUtils.c(lobby.core.messageUtils.MAIN_COLOR + "Crate Keys"));
    keys1.setScore(4); // Integer only!

    Score keys2 = stats.getScore(lobby.core.messageUtils
        .c(lobby.core.messageUtils.SECOND_COLOR + lobby.core.crateKeyHandler.getKeys(player)));
    keys2.setScore(3); // Integer only!

    Score spacer3 = stats.getScore(lobby.core.messageUtils.c("&c"));
    spacer3.setScore(2); // Integer only!
    Score ip = stats.getScore(
        lobby.core.messageUtils.c(lobby.core.messageUtils.MAIN_COLOR + "&lplay.mineaqua.org"));
    ip.setScore(1); // Integer only!

    return board;
  }
}
