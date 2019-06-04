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
import net.timelegacy.tlhub.handler.DiscoveriesHandler;
import net.timelegacy.tlhub.menus.MainMenu;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TLHub extends JavaPlugin {

  private static FileConfiguration config;
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
    PluginManager pm = Bukkit.getServer().getPluginManager();
    
    pm.registerEvents(new PlayerEvents(), plugin);
    pm.registerEvents(new InteractEvents(), plugin);

    pm.registerEvents(new ParticleMenu(), plugin);
    pm.registerEvents(new CosmeticMenu(), plugin);
    pm.registerEvents(new PetsMenu(), plugin);
    pm.registerEvents(new HatsMenu(), plugin);
    pm.registerEvents(new GadgetsMenu(), plugin);
    pm.registerEvents(new CosmeticHandler(), plugin);

    pm.registerEvents(new AnimalCannon(), plugin);
    pm.registerEvents(new BatLauncher(), plugin);
    pm.registerEvents(new DiscoBall(), plugin);
    pm.registerEvents(new Evolution(), plugin);
    pm.registerEvents(new ExplosiveSnowball(), plugin);
    pm.registerEvents(new Firecracker(), plugin);
    pm.registerEvents(new HeadRider(), plugin);
    pm.registerEvents(new PaintballGun(), plugin);
    pm.registerEvents(new Partner(), plugin);
    pm.registerEvents(new PartyPopper(), plugin);
    pm.registerEvents(new SheepBomb(), plugin);
    pm.registerEvents(new SuperPunch(), plugin);
    pm.registerEvents(new SheepBomb(), plugin);
    pm.registerEvents(new SuperPunch(), plugin);
    pm.registerEvents(new ThorsHammer(), plugin);
    pm.registerEvents(new TNTFountain(), plugin);

    pm.registerEvents(new BounceEffect(), plugin);
    pm.registerEvents(new FireworkEffect(), plugin);
  }
}
