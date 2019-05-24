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
import org.bukkit.scoreboard.*;

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
        stats.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "TIME LEGACY");

        Team spacer1 = board.registerNewTeam("spacer1");
        spacer1.addEntry("§1");
        stats.getScore("§1").setScore(9);


        String serverString = ChatColor.WHITE
                + "Server: "
                + ChatColor.GRAY
                + MessageUtils.friendlyify(ServerHandler.getType(ServerHandler.getServerUID()));
        Team server =
                board.registerNewTeam("server");
        server.addEntry(serverString);
        stats.getScore(serverString).setScore(8);


        // TODO Fix status once API is setup
        String statusString = ChatColor.WHITE + "Status: " + ChatColor.GRAY + "?";
        Team status = board.registerNewTeam("status");
        status.addEntry(statusString);
        stats.getScore(statusString).setScore(7);


        Team spacer2 = board.registerNewTeam("spacer2");
        spacer2.addEntry("§2");
        stats.getScore("§2").setScore(6);


        String discoveriesString = ChatColor.WHITE
                + "Discoveries: "
                + ChatColor.LIGHT_PURPLE
                + "?" /*TODO Replace this with the api for it*/
                + ChatColor.GRAY
                + "/"
                + ChatColor.LIGHT_PURPLE
                + "23" /*TODO Replace this with the API once its done*/;
        Team discoveries = board.registerNewTeam("discoveries");
        discoveries.addEntry(discoveriesString);
        stats.getScore(discoveriesString).setScore(5);


        String tokensString = ChatColor.WHITE
                + "Tokens: "
                + ChatColor.AQUA
                + CoinHandler.getBalance(player.getName());
        Team tokens = board.registerNewTeam("tokens");
        tokens.addEntry(tokensString);
        stats.getScore(tokensString).setScore(4);


        String keysString = ChatColor.WHITE
                + "Crates: "
                + ChatColor.GOLD
                + CrateKeyHandler.getBalance(player.getName());
        Team keys = board.registerNewTeam("keys");
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
}
