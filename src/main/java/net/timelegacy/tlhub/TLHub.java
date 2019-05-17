package net.timelegacy.tlhub;

import net.timelegacy.tlcore.TLCore;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import net.timelegacy.tlhub.cosmetics.other.BounceEffect;
import net.timelegacy.tlhub.cosmetics.other.FireworkEffect;
import net.timelegacy.tlhub.event.InteractEvents;
import net.timelegacy.tlhub.event.PlayerEvents;
import net.timelegacy.tlhub.handler.ScoreboardHandler;
import net.timelegacy.tlhub.menus.CosmeticMenu;
import net.timelegacy.tlhub.menus.MainMenu;
import net.timelegacy.tlhub.menus.ParticleMenu;
import net.timelegacy.tlhub.menus.PetsMenu;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

public class TLHub extends JavaPlugin {

    private static TLHub plugin;
    public FileConfiguration config;

    public boolean playersOnline;

    public ScoreboardHandler scoreboardHandler;
    public CosmeticHandler cosmetics;
    public MainMenu mainMenu;

    public TLCore core;

    public Location spawn;


    public static TLHub getInstance() {
        return plugin;
    }

    public void onEnable() {

        playersOnline = false;

        plugin = this;
        config = plugin.getConfig();

        plugin.saveDefaultConfig();
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();

        plugin.getServer().getMessenger().registerOutgoingPluginChannel(plugin, "BungeeCord");

        for (Entity e : Bukkit.getWorld("world")
            .getEntities()) {
            if (e.getType() != EntityType.ITEM_FRAME) {
                e.remove();
            }
        }

        core = TLCore.getInstance();

        scoreboardHandler = new ScoreboardHandler();
        cosmetics = new CosmeticHandler();
        mainMenu = new MainMenu();

        core.serverHandler.setMaxPlayers(core.serverHandler.getServerUID(), 50);
        spawn = new Location(Bukkit.getWorld("world"), 0.5, 117.5, 0.5);

        Bukkit.getPluginManager().registerEvents(new MainMenu(), plugin);
        registerEvents();

        cosmetics.register();

        scoreboardHandler.updateBoard();
        core.serverHandler.setType(core.serverHandler.getServerUID(), "LOBBY");
        core.worldUtils.setupWorld(Bukkit.getWorld("world"), true);
    }

    public void onDisable() {
        plugin.getServer().getScheduler().cancelTasks(plugin);

        plugin.getServer().getWorld("world").save();
    }

    private void registerEvents() {
        plugin.getServer().getPluginManager().registerEvents(new PlayerEvents(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new InteractEvents(), plugin);

        Bukkit.getServer().getPluginManager().registerEvents(new ParticleMenu(), plugin);
        Bukkit.getServer().getPluginManager().registerEvents(new CosmeticMenu(), plugin);
        Bukkit.getServer().getPluginManager().registerEvents(new PetsMenu(), plugin);
        Bukkit.getServer().getPluginManager().registerEvents(new CosmeticHandler(), plugin);

        Bukkit.getServer().getPluginManager().registerEvents(new BounceEffect(), plugin);
        Bukkit.getServer().getPluginManager().registerEvents(new FireworkEffect(), plugin);
    }
}
