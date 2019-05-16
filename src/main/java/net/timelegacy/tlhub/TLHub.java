package net.timelegacy.tlhub;

import net.timelegacy.tlcore.TLCore;
import net.timelegacy.tlhub.cosmetics.CosmeticHandler;
import net.timelegacy.tlhub.event.InteractEvents;
import net.timelegacy.tlhub.event.PlayerEvents;
import net.timelegacy.tlhub.handler.GameMenuHandler;
import net.timelegacy.tlhub.handler.NPCHandler;
import net.timelegacy.tlhub.handler.ScoreboardHandler;
import net.timelegacy.tlhub.menus.MainMenu;
import net.timelegacy.tlhub.npcs.ServerGolemNPC;
import net.timelegacy.tlhub.npcs.ShopNPC;
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

    public NPCHandler entityHandler;
    public ShopNPC shopNPC;
    public ServerGolemNPC serverGolemNPC;
    public ScoreboardHandler scoreboardHandler;
    public CosmeticHandler cosmetics;
    public GameMenuHandler gameMenus;
    public MainMenu mainMenu;

    public TLCore core;

    public Location spawn;


    public static TLHub getInstance() {
        return plugin;
    }

    public void init() {

        entityHandler = new NPCHandler();
        shopNPC = new ShopNPC();
        serverGolemNPC = new ServerGolemNPC();
        scoreboardHandler = new ScoreboardHandler();
        gameMenus = new GameMenuHandler();
        cosmetics = new CosmeticHandler();
        mainMenu = new MainMenu();

        core = TLCore.getInstance();

        gameMenus.initialize();

        gameMenus.updateInv();

        core.serverHandler.setMaxPlayers(core.serverHandler.getServerUID(), 50);

        spawn = new Location(Bukkit.getWorld("world"), 0.5, 117.5, 0.5);

        Bukkit.getPluginManager().registerEvents(new MainMenu(), plugin);

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

        init();
        load();
        shopNPC.loadShopItems();

        core.serverHandler.setType(core.serverHandler.getServerUID(), "LOBBY");

        core.worldUtils.setupWorld(Bukkit.getWorld("world"), true);
    }

    public void onDisable() {
        plugin.getServer().getScheduler().cancelTasks(plugin);

        plugin.getServer().getWorld("world").save();
    }

    private void load() {
        registerEvents();
        scoreboardHandler.updateBoard();

        entityHandler.spawn();

        cosmetics.register();
    }

    private void registerEvents() {
        plugin.getServer().getPluginManager().registerEvents(new PlayerEvents(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ShopNPC(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ServerGolemNPC(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new InteractEvents(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new GameMenuHandler(), plugin);
    }
}
