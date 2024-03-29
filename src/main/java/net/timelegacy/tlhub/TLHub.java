package net.timelegacy.tlhub;

import net.timelegacy.tlcore.handler.ServerHandler;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import net.timelegacy.tlhub.cosmetics.menu.CosmeticMenu;
import net.timelegacy.tlhub.cosmetics.menu.GadgetsMenu;
import net.timelegacy.tlhub.cosmetics.menu.HatsMenu;
import net.timelegacy.tlhub.cosmetics.menu.ParticleMenu;
import net.timelegacy.tlhub.cosmetics.particles.BounceEffect;
import net.timelegacy.tlhub.cosmetics.particles.FireworkEffect;
import net.timelegacy.tlhub.crates.MiniCrateFinderListener;
import net.timelegacy.tlhub.event.ChecksListener;
import net.timelegacy.tlhub.event.InteractEvents;
import net.timelegacy.tlhub.event.PlayerEvents;
import net.timelegacy.tlhub.handler.DiscoveriesHandler;
import net.timelegacy.tlhub.listeners.GadgetListener;
import net.timelegacy.tlhub.listeners.KrunkersDrugsListener;
import net.timelegacy.tlhub.listeners.PlayerVisibilityListener;
import net.timelegacy.tlhub.menus.MainMenu;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TLHub extends JavaPlugin {

  private CosmeticHandler cosmeticHandler;
  private MiniCrateFinderListener miniCrateFinderListener;

  private static FileConfiguration config;
  public static boolean playersOnline;
  public static Location spawn;
  private static TLHub plugin;

  public static TLHub getPlugin() {
    return plugin;
  }

  public void onEnable() {
    registerClasses();

    cosmeticHandler.registerCosmetics();

    playersOnline = false;

    plugin = this;
    config = getConfig();

    spawn = new Location(Bukkit.getWorld("world"), 0.5, 117.5, 0.5);

//    saveDefaultConfig();
//    getConfig().options().copyDefaults(true);
//    saveConfig();

    saveResource("config.yml", false);

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

    //CosmeticHandler.register();
    ServerHandler.setType(ServerHandler.getServerUUID(), "LOBBY");

    //miniCrateFinderListener.startRunnable();
    //miniCrateFinderListener.beaconShower();
  }

  public void onDisable() {
    getServer().getScheduler().cancelTasks(this);
    miniCrateFinderListener.unloadMiniCrates();
  }

  private void registerClasses() {
    this.cosmeticHandler = new CosmeticHandler(this);
    this.miniCrateFinderListener = new MiniCrateFinderListener(this);
  }

  private void registerEvents() {
    PluginManager pm = Bukkit.getServer().getPluginManager();

    pm.registerEvents(new PlayerEvents(), this);
    pm.registerEvents(new InteractEvents(this), this);

    pm.registerEvents(new ParticleMenu(this), this);
    pm.registerEvents(new CosmeticMenu(this), this);
    pm.registerEvents(new HatsMenu(this), this);
    pm.registerEvents(new GadgetsMenu(this), this);

    pm.registerEvents(new PlayerVisibilityListener(this), this);

    pm.registerEvents(cosmeticHandler, this);
    pm.registerEvents(miniCrateFinderListener, this);

//    pm.registerEvents(new AnimalCannon(), this);
//    pm.registerEvents(new BatLauncher(), this);
//    pm.registerEvents(new DiscoBall(), this);
//    pm.registerEvents(new Evolution(), this);
//    pm.registerEvents(new ExplosiveSnowball(), this);
//    pm.registerEvents(new Firecracker(), this);
//    pm.registerEvents(new HeadRider(), this);
//    pm.registerEvents(new PaintballGun(), this);
//    pm.registerEvents(new Partner(), this);
//    pm.registerEvents(new PartyPopper(), this);
//    pm.registerEvents(new SheepBomb(), this);
//    pm.registerEvents(new SuperPunch(), this);
//    pm.registerEvents(new SheepBomb(), this);
//    pm.registerEvents(new SuperPunch(), this);
//    pm.registerEvents(new ThorsHammer(), this);
//    pm.registerEvents(new TNTFountain(), this);

    pm.registerEvents(new BounceEffect(this), this);
    pm.registerEvents(new FireworkEffect(), this);

    pm.registerEvents(new GadgetListener(this), this);
    pm.registerEvents(new ChecksListener(), this);
    pm.registerEvents(new KrunkersDrugsListener(), this);
  }

  public CosmeticHandler getCosmeticHandler() {
    return cosmeticHandler;
  }
}
