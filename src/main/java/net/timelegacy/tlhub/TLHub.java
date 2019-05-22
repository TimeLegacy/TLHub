package net.timelegacy.tlhub;

import net.timelegacy.tlcore.handler.ServerHandler;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import net.timelegacy.tlhub.cosmetics.gadgets.AnimalCannon;
import net.timelegacy.tlhub.cosmetics.gadgets.BatLauncher;
import net.timelegacy.tlhub.cosmetics.gadgets.DiscoBall;
import net.timelegacy.tlhub.cosmetics.gadgets.Evolution;
import net.timelegacy.tlhub.cosmetics.gadgets.ExplosiveSnowball;
import net.timelegacy.tlhub.cosmetics.gadgets.Firecracker;
import net.timelegacy.tlhub.cosmetics.gadgets.HeadRider;
import net.timelegacy.tlhub.cosmetics.gadgets.PaintballGun;
import net.timelegacy.tlhub.cosmetics.gadgets.Partner;
import net.timelegacy.tlhub.cosmetics.gadgets.PartyPopper;
import net.timelegacy.tlhub.cosmetics.gadgets.SheepBomb;
import net.timelegacy.tlhub.cosmetics.gadgets.SuperPunch;
import net.timelegacy.tlhub.cosmetics.gadgets.TNTFountain;
import net.timelegacy.tlhub.cosmetics.gadgets.ThorsHammer;
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
    Bukkit.getServer().getPluginManager().registerEvents(new CosmeticHandler(), plugin);

    Bukkit.getServer().getPluginManager().registerEvents(new AnimalCannon(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new BatLauncher(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new DiscoBall(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new Evolution(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new ExplosiveSnowball(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new Firecracker(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new HeadRider(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new PaintballGun(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new Partner(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new PartyPopper(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new SheepBomb(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new SuperPunch(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new SheepBomb(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new SuperPunch(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new ThorsHammer(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new TNTFountain(), plugin);

    Bukkit.getServer().getPluginManager().registerEvents(new BounceEffect(), plugin);
    Bukkit.getServer().getPluginManager().registerEvents(new FireworkEffect(), plugin);
  }
}
