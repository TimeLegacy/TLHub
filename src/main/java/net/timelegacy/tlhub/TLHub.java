package net.timelegacy.tlhub;

import net.timelegacy.tlcore.handler.ServerHandler;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import net.timelegacy.tlhub.cosmetics.GadgetsListener;
import net.timelegacy.tlhub.cosmetics.menu.CosmeticMenu;
import net.timelegacy.tlhub.cosmetics.menu.GadgetsMenu;
import net.timelegacy.tlhub.cosmetics.menu.HatsMenu;
import net.timelegacy.tlhub.cosmetics.menu.ParticleMenu;
import net.timelegacy.tlhub.cosmetics.menu.PetsMenu;
import net.timelegacy.tlhub.cosmetics.particles.BounceEffect;
import net.timelegacy.tlhub.cosmetics.particles.FireworkEffect;
import net.timelegacy.tlhub.event.InteractEvents;
import net.timelegacy.tlhub.event.PlayerEvents;
import net.timelegacy.tlhub.handler.ScoreboardHandler;
import net.timelegacy.tlhub.menus.MainMenu;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

public class TLHub extends JavaPlugin {

  public static FileConfiguration config;
  public static boolean playersOnline;
  public static Location spawn;
  private static TLHub plugin;

  public static TLHub getPlugin() {
    return plugin;
  }

  public void onEnable() {

    playersOnline = false;

    plugin = this;
    config = plugin.getConfig();

    spawn = new Location(Bukkit.getWorld("world"), 0.5, 117.5, 0.5);

    plugin.saveDefaultConfig();
    plugin.getConfig().options().copyDefaults(true);
    plugin.saveConfig();

    plugin.getServer().getMessenger().registerOutgoingPluginChannel(plugin, "BungeeCord");

    for (Entity e : Bukkit.getWorld("world").getEntities()) {
      if (e.getType() != EntityType.ITEM_FRAME) {
        e.remove();
      }
    }

    ServerHandler.setMaxPlayers(ServerHandler.getServerUID(), 50);

    Bukkit.getPluginManager().registerEvents(new MainMenu(), plugin);
    registerEvents();

    CosmeticHandler.register();

    ScoreboardHandler.updateBoard();
    ServerHandler.setType(ServerHandler.getServerUID(), "LOBBY");
  }

  public void onDisable() {
    plugin.getServer().getScheduler().cancelTasks(plugin);
  }

  private void registerEvents() {
    plugin.getServer().getPluginManager().registerEvents(new PlayerEvents(), plugin);
    plugin.getServer().getPluginManager().registerEvents(new InteractEvents(), plugin);

    Bukkit.getServer().getPluginManager().registerEvents(new ParticleMenu(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new CosmeticMenu(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new PetsMenu(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new HatsMenu(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new GadgetsMenu(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new GadgetsListener(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new CosmeticHandler(), plugin);

    Bukkit.getServer().getPluginManager().registerEvents(new BounceEffect(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new FireworkEffect(), plugin);
  }
}
