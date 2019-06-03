package net.timelegacy.tlhub;

import net.timelegacy.tlcore.handler.ServerHandler;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import net.timelegacy.tlhub.cosmetics.gadgets.*;
import net.timelegacy.tlhub.cosmetics.menu.*;
import net.timelegacy.tlhub.cosmetics.particles.BounceEffect;
import net.timelegacy.tlhub.cosmetics.particles.FireworkEffect;
import net.timelegacy.tlhub.event.InteractEvents;
import net.timelegacy.tlhub.event.PlayerEvents;
import net.timelegacy.tlhub.handler.DiscoveriesHandler;
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

    DiscoveriesHandler.setupDiscoveries();

    ServerHandler.setMaxPlayers(ServerHandler.getServerUUID(), 50);

    Bukkit.getPluginManager().registerEvents(new MainMenu(), plugin);
    registerEvents();

    CosmeticHandler.register();
    ServerHandler.setType(ServerHandler.getServerUUID(), "LOBBY");
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
