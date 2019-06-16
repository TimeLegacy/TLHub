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
import net.timelegacy.tlhub.cosmetics.menu.YourProfileMenu;
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
    config = getConfig();

    spawn = new Location(Bukkit.getWorld("world"), 0.5, 117.5, 0.5);

    saveDefaultConfig();
    getConfig().options().copyDefaults(true);
    saveConfig();

    getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

    for (Entity e : Bukkit.getWorld("world").getEntities()) {
      if (e.getType() != EntityType.ITEM_FRAME) {
        e.remove();
      }
    }

    DiscoveriesHandler.setupDiscoveries();

    ServerHandler.setMaxPlayers(ServerHandler.getServerUUID(), 50);

    Bukkit.getPluginManager().registerEvents(new MainMenu(), this);
    registerEvents();

    CosmeticHandler.register();
    ServerHandler.setType(ServerHandler.getServerUUID(), "LOBBY");
  }

  public void onDisable() {
    getServer().getScheduler().cancelTasks(this);
  }

  private void registerEvents() {
    PluginManager pm = Bukkit.getServer().getPluginManager();

    pm.registerEvents(new PlayerEvents(), this);
    pm.registerEvents(new InteractEvents(), this);

    pm.registerEvents(new ParticleMenu(), this);
    pm.registerEvents(new CosmeticMenu(), this);
    pm.registerEvents(new PetsMenu(), this);
    pm.registerEvents(new HatsMenu(), this);
    pm.registerEvents(new GadgetsMenu(), this);
    pm.registerEvents(new YourProfileMenu(), this);

    pm.registerEvents(new CosmeticHandler(), this);

    pm.registerEvents(new AnimalCannon(), this);
    pm.registerEvents(new BatLauncher(), this);
    pm.registerEvents(new DiscoBall(), this);
    pm.registerEvents(new Evolution(), this);
    pm.registerEvents(new ExplosiveSnowball(), this);
    pm.registerEvents(new Firecracker(), this);
    pm.registerEvents(new HeadRider(), this);
    pm.registerEvents(new PaintballGun(), this);
    pm.registerEvents(new Partner(), this);
    pm.registerEvents(new PartyPopper(), this);
    pm.registerEvents(new SheepBomb(), this);
    pm.registerEvents(new SuperPunch(), this);
    pm.registerEvents(new SheepBomb(), this);
    pm.registerEvents(new SuperPunch(), this);
    pm.registerEvents(new ThorsHammer(), this);
    pm.registerEvents(new TNTFountain(), this);

    pm.registerEvents(new BounceEffect(), this);
    pm.registerEvents(new FireworkEffect(), this);
  }
}
