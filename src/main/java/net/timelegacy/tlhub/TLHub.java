package net.timelegacy.tlhub;

import org.bukkit.plugin.java.JavaPlugin;

public class TLHub extends JavaPlugin {

  private TLHub plugin;

  @Override
  public void onEnable() {
    plugin = this;

    System.out.println("Hub loading...");
  }

  @Override
  public void onDisable() {

  }

  public TLHub getPlugin() {
    return plugin;
  }
}
