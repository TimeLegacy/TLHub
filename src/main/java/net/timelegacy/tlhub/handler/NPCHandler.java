package net.timelegacy.tlhub.handler;

import net.timelegacy.tlhub.TLHub;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.Vector;

public class NPCHandler {

  TLHub lobby = TLHub.getInstance();

  private void shopVillager(Location l, String name) {
    Villager villager = l.getWorld().spawn(l, Villager.class);
    villager.setAdult();
    villager.setAgeLock(true);
    villager.setCanPickupItems(false);
    villager.setBreed(false);
    villager.setProfession(Profession.LIBRARIAN);

    freezeAndLook(villager);

    lobby.core.hologramUtils
        .createHologram(new Location(l.getWorld(), l.getX(), l.getY() + 0.4, l.getZ()),
            lobby.core.messageUtils.c(lobby.core.messageUtils.SECOND_COLOR + name));
    lobby.core.hologramUtils
        .createHologram(new Location(l.getWorld(), l.getX(), l.getY(), l.getZ()),
            lobby.core.messageUtils.c(lobby.core.messageUtils.MAIN_COLOR + "&lRIGHT-CLICK"));
  }

  private void crateSkeleton(Location l, String name) {
    Skeleton skeleton = l.getWorld().spawn(l, Skeleton.class);
    skeleton.setSkeletonType(Skeleton.SkeletonType.WITHER);
    skeleton.setFireTicks(0);
    skeleton.getEquipment().setItemInHand(new ItemStack(Material.CHEST, 1));

    freezeAndLook(skeleton);

    lobby.core.hologramUtils
        .createHologram(new Location(l.getWorld(), l.getX(), l.getY() + 0.5, l.getZ()),
            lobby.core.messageUtils.c(lobby.core.messageUtils.SECOND_COLOR + name));
    lobby.core.hologramUtils
        .createHologram(new Location(l.getWorld(), l.getX(), l.getY() + 0.2, l.getZ()),
            lobby.core.messageUtils.c(lobby.core.messageUtils.MAIN_COLOR + "&lRIGHT-CLICK"));
  }

  private void gameGolem(Location l, String game) {
    IronGolem golem = l.getWorld().spawn(l, IronGolem.class);

    golem.setCanPickupItems(false);
    golem.setMetadata("type", new FixedMetadataValue(lobby, game));

    golem.setMaxHealth(10);

    freezeAndLook(golem);

    // Cough Cough, the correct way to freeze an npc

    lobby.core.hologramUtils
        .createHologram(new Location(l.getWorld(), l.getX(), l.getY() + 1, l.getZ()),
            lobby.core.messageUtils.c(lobby.core.messageUtils.SECOND_COLOR + "&l" + game));
    lobby.core.hologramUtils
        .createHologram(new Location(l.getWorld(), l.getX(), l.getY() + 0.6, l.getZ()),
            lobby.core.messageUtils.c(lobby.core.messageUtils.MAIN_COLOR + "&lRIGHT-CLICK"));
  }

  private void freezeAndLook(Entity entity) {
    Location spawn = lobby.spawn;
    Vector dirBetweenLocations = spawn.toVector().subtract(entity.getLocation().toVector());
    Location loc = entity.getLocation();
    loc.setDirection(dirBetweenLocations);

    entity.teleport(loc);
    //TODO no ai 1.13 (EntityUtils)

  }

  public void spawn() {

    gameGolem(new Location(Bukkit.getWorld("world"), 64.5, 61.0, 1027.5), "BedWars");
    gameGolem(new Location(Bukkit.getWorld("world"), 62.5, 61.0, 1029.5), "SurvivalGames");
    gameGolem(new Location(Bukkit.getWorld("world"), 59.5, 61.0, 1029.5), "MagmaRunner");
    gameGolem(new Location(Bukkit.getWorld("world"), 56.5, 61.0, 1029.5), "&kCoMInG SoON");
    gameGolem(new Location(Bukkit.getWorld("world"), 54.5, 61.0, 1027.5), "&kCoMInG SoON");

    shopVillager(new Location(Bukkit.getWorld("world"), 94.5, 62, 1005.999), "The Trader");
    crateSkeleton(new Location(Bukkit.getWorld("world"), 51.5, 62, 1013.5), "The Crate Keeper");
  }

}
