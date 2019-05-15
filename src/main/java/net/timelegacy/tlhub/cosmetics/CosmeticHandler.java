package net.timelegacy.tlhub.cosmetics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.other.BounceEffect;
import net.timelegacy.tlhub.cosmetics.other.FireworkEffect;
import net.timelegacy.tlhub.cosmetics.particleeffects.AngelWings;
import net.timelegacy.tlhub.cosmetics.particleeffects.BloodHelix;
import net.timelegacy.tlhub.cosmetics.particleeffects.CandyCane;
import net.timelegacy.tlhub.cosmetics.particleeffects.Cone;
import net.timelegacy.tlhub.cosmetics.particleeffects.Enchanted;
import net.timelegacy.tlhub.cosmetics.particleeffects.EnderAura;
import net.timelegacy.tlhub.cosmetics.particleeffects.FlameFairy;
import net.timelegacy.tlhub.cosmetics.particleeffects.FrozenWalk;
import net.timelegacy.tlhub.cosmetics.particleeffects.GreenSparks;
import net.timelegacy.tlhub.cosmetics.particleeffects.InLove;
import net.timelegacy.tlhub.cosmetics.particleeffects.Music;
import net.timelegacy.tlhub.cosmetics.particleeffects.RainCloud;
import net.timelegacy.tlhub.cosmetics.particleeffects.SantaHat;
import net.timelegacy.tlhub.cosmetics.particleeffects.SnowCloud;
import net.timelegacy.tlhub.cosmetics.particleeffects.Walks;
import net.timelegacy.tlhub.menus.CosmeticMenu;
import net.timelegacy.tlhub.menus.ParticleMenu;
import net.timelegacy.tlhub.menus.PetsMenu;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class CosmeticHandler implements Listener {

  // Menus
  public ParticleMenu particleMenu;
  public CosmeticMenu cosmeticMenu;
  public PetsMenu petsMenu;
  // Effects
  public BounceEffect bounce;
  public FireworkEffect firework;
  // Particles
  public AngelWings angleWings;
  public BloodHelix bloodHelix;
  public CandyCane candyCane;
  public Cone cone;
  public Enchanted enchanted;
  public EnderAura enderAura;
  public FlameFairy flameFairy;
  public FrozenWalk frozenWalk;
  public GreenSparks greenSparks;
  public InLove inLove;
  public Music music;
  public RainCloud rainCloud;
  public SantaHat santaHat;
  public SnowCloud snowCloud;
  public Walks walks;
  //Lists
  public List<Cosmetic> cosmeticsList;

  private TLHub lobby = TLHub.getInstance();
  private HashMap<Player, String> cooldown = new HashMap<Player, String>();
  private HashMap<Player, String> effects = new HashMap<Player, String>();
  private HashMap<Player, String> pets = new HashMap<Player, String>();
  private HashMap<Player, Entity> petEntity = new HashMap<>();

  /**
   * TODO - MAKE THE COSMETIC MENUS & PETS MENUS DYNAMIC & HATS DYNAMIC
   */

  public void register() {
    //Lists
    cosmeticsList = new ArrayList<>();

    // Menus
    particleMenu = new ParticleMenu();
    cosmeticMenu = new CosmeticMenu();
    petsMenu = new PetsMenu();

    //Load
    load();

    // Effects
    bounce = new BounceEffect();
    firework = new FireworkEffect();

    // Particles
    angleWings = new AngelWings();
    bloodHelix = new BloodHelix();
    candyCane = new CandyCane();
    cone = new Cone();
    enchanted = new Enchanted();
    enderAura = new EnderAura();
    flameFairy = new FlameFairy();
    frozenWalk = new FrozenWalk();
    greenSparks = new GreenSparks();
    inLove = new InLove();
    music = new Music();
    rainCloud = new RainCloud();
    santaHat = new SantaHat();
    snowCloud = new SnowCloud();
    walks = new Walks();

    // Menu Listeners
    Bukkit.getServer().getPluginManager().registerEvents(new ParticleMenu(), TLHub.getInstance());
    Bukkit.getServer().getPluginManager().registerEvents(new CosmeticMenu(), TLHub.getInstance());
    Bukkit.getServer().getPluginManager().registerEvents(new PetsMenu(), TLHub.getInstance());
    Bukkit.getServer().getPluginManager().registerEvents(this, TLHub.getInstance());

    // Particle Runnables
    angleWings.particleRunnable();
    bloodHelix.particleRunnable();
    candyCane.particleRunnable();
    cone.particleRunnable();
    enchanted.particleRunnable();
    enderAura.particleRunnable();
    flameFairy.particleRunnable();
    frozenWalk.particleRunnable();
    greenSparks.particleRunnable();
    inLove.particleRunnable();
    music.particleRunnable();
    rainCloud.particleRunnable();
    santaHat.particleRunnable();
    snowCloud.particleRunnable();
    walks.particleRunnable();

    syncPets();

    // Effect Listeners
    Bukkit.getServer().getPluginManager().registerEvents(new BounceEffect(), TLHub.getInstance());
    Bukkit.getServer().getPluginManager().registerEvents(new FireworkEffect(), TLHub.getInstance());
  }

  @EventHandler
  public void onLeave(PlayerQuitEvent e) {
    Player p = e.getPlayer();

    if (hasParticle(p)) {
      removeParticle(p);
    }

    if (hasPet(p)) {
      removePet(p);
    }

  }

  public void setParticle(Player p, String cosmetic) {
    if (effects.containsKey(p)) {
      effects.remove(p);
      effects.put(p, cosmetic.toUpperCase());

    } else {
      effects.put(p, cosmetic);
    }
  }

  public boolean particleEnabled(Player p, String cosmetic) {
    return effects.containsKey(p) && effects.get(p).equalsIgnoreCase(cosmetic);
  }

  public boolean hasParticle(Player p) {
    return effects.containsKey(p);
  }

  public void removeParticle(Player p) {
    effects.remove(p);
  }

  public void setPet(Player p, String cosmetic) {
    if (pets.containsKey(p)) {
      removePet(p);

      pets.put(p, cosmetic.toUpperCase());
    } else {
      pets.put(p, cosmetic);
    }
  }

  public boolean hasPet(Player p) {
    return pets.containsKey(p);
  }

  public void removePet(Player p) {
    pets.remove(p);
    if (petEntity.containsKey(p)) {
      petEntity.get(p).remove();
      petEntity.remove(p);
    }
  }

  public void syncPets() {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(lobby, () -> {
      for (Map.Entry<Player, String> pe : pets.entrySet()) {

        if (pets.containsKey(pe.getKey()) && !petEntity.containsKey(pe.getKey())) {
          ArmorStand armorStand = pe.getKey().getWorld()
              .spawn(pe.getKey().getLocation(), ArmorStand.class);

          for (Cosmetic cosmetic : cosmeticsList) {
            if (cosmetic.getCosmeticIdentifier().equalsIgnoreCase(pe.getValue())) {
              //armorStand.getEquipment().setHelmet(lobby.core.itemUtils.getCustomSkull(cosmetic.getSkullValue()));
              //TODO fix pets
            }
          }

          //rabbit.setBaby(true);
          armorStand.setSmall(true);

          //rabbit.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 9999999, 1));
          armorStand.setVisible(false);

          armorStand.setCustomName(pe.getKey().getUniqueId().toString());
          armorStand.setCustomNameVisible(false);

          petEntity.put(pe.getKey(), armorStand);
        }

        follow(pe.getKey(), petEntity.get(pe.getKey()));

      }
    }, 0, 1);
  }

  private void follow(Player target, Entity follower) {
    int direction = getDirection(target);
    if (target.isOnGround()) {
      Location location = target.getLocation()
          .subtract(direction == 1 ? -1.25 : (direction == 4) ? 1.25 : 0, 0,
              direction == 2 ? -1.25 : (direction == 3) ? 1.25 : 0);
      follower.teleport(location);

      Bukkit.getScheduler().scheduleSyncDelayedTask(lobby,
          () -> lobby.core.particleUtils.display(Particle.FIREWORKS_SPARK, location.add(0, 1, 0)),
          2L);

    }

  }

  private int getDirection(Player player) {
    // 1 = north, 2 = east, 3 = west, 4 = south

    float yaw = player.getLocation().getYaw();
    if (yaw < 0) {
      yaw += 360;
    }
    if (yaw >= 315 || yaw < 45) {
      return 4;
    } else if (yaw < 135) {
      return 3;
    } else if (yaw < 225) {
      return 1;
    } else if (yaw < 315) {
      return 2;
    }
    return 1;
  }

  public void addCooldown(Player p, long seconds, String type) {
    String cooldownType = type.toUpperCase();
    cooldown.put(p, cooldownType);

    Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(
        TLHub.getInstance(), () -> cooldown.remove(p, cooldownType), 20L * seconds);
  }

  public boolean hasCooldown(Player p, String type) {
    String cooldownType = type.toUpperCase();

    return cooldown.containsKey(p) && cooldown.get(p).equalsIgnoreCase(cooldownType);
  }

  public void load() {
    //Pets
    lobby.cosmetics.cosmeticsList.add(new Cosmetic("LOBBY.PET.FROG", null, "Frog", "Ribit, Ribit!",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTE1NTQxMmZkMTFkY2QwYWJhNzdhMTgzNzg1ODM1MzdlNzYyNWM2ZjcxZmU0NTJmN2E3MTdkYWUzMzI2ZjIyYSJ9fX0="));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PET.PUFFERFISH", null, "Pufferfish", "Don't scare me! I'll hurt you.",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTcwOTAyOTk3MzJjNTFlZGFmNmM1ZGQ2YWUzZWRkNTk0MzNkYTM3YTc4NzhiOWY0YWY1NDI4ZDdlZDI1N2Y0YiJ9fX0="));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PET.PINK_BUNNY", null, "Pink Bunny", "I like to bounce.",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWIzYTdhYTY5Y2RiNDEyN2Q1NWExYjQ3NmRmNzQ1MGYwMzJiYWQ3YzE1OWNjOTdjYzllNjVlMDIzMjQ5NWU0ZCJ9fX0="));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PET.SHARK", null, "Shark", "Woof, Woof. I'm not a dog.",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTk0YWU0MzNiMzAxYzdmYjdjNjhjYmE2MjViMGJkMzZiMGIxNDE5MGYyMGUzNGE3YzhlZTBkOWRlMDZkNTNiOSJ9fX0="));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PET.COP_DOGE", null, "Cop Doge", "I'm a cop doge.",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzZjMzZjNjc3MzRjMmQ5NzcwYzZiNDRmMDFlZjEzMTNhYzQ4MWFkY2MzZjM2OWIyZDM1MDgyOWVhMmExY2RjZSJ9fX0="));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PET.KING_DOGE", null, "King Doge", "I'm your king!",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzI4NTk1MGZkNjc4NThlNzZjNDM5YjBiNWI4N2M2OWE2YzUyYTRkZjkzNmUyMjRkODQzYjE0YzIyNTY1OTQ5ZSJ9fX0="));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PET.CYBORG_PARROT", null, "Cyborg Parrot", "Bee boop, bee bop.",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2IyYjQ0ODIzMTM5YWFlZjgzMTIyOGI0YmJkYmUzYmY3YWM2ZGFhOWJhYWIxMjMwNTY0NmU5ZmYzNjZlMzYwYiJ9fX0="));
    lobby.cosmetics.cosmeticsList.add(new Cosmetic("LOBBY.PET.BEE", null, "Bee", "Buzz!",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjg2MThmNDFkYmIzMGQ3MWE4MzE1N2Q2OTYxYjAyM2Y4MTIzMDIxMjFkNzEwNTY5YzkwZmJjMWY0NGRjMTEzNyJ9fX0="));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PET.BURGER", null, "Royal w/ Cheese", "This is a tasty burger!",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzE4NzRjNzJjZmZkM2MyOWE0YjEyZDQzNTkwNjZkNmM4OTUyNTI5NzE3MmFiZjYyNzI3OTI5ZmViNDZmNDEifX19"));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PET.MELON", null, "Melon", "I'm 99% ish water!",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDU4NjcwNTUxZjdmZjEzYWZhYjIzOTMxOGExMGJhZDIzMjdlZTc0MmUxNTc4MzdlYTE3ODVlZjQ0M2QzYTU3NiJ9fX0="));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PET.ARTICUNO", null, "Articuno", "Gotta catch them all!",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzRiZDg5ZGM5NTI4Y2UyZDljMjk3MjU0YzMyMDUwNjE5NTFlYjZiMmYwNjNhZTg0ZGFmY2Q0ZWY3OTc4In19fQ=="));
    lobby.cosmetics.cosmeticsList.add(new Cosmetic("LOBBY.PET.BOJACK", null, "Bojack Horseman",
        "'Dead on the inside, dead on the outside.' - Bojack Horseman",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTg2NjA0MWQzZjBiMGY4YjE3ZjdkMmNjN2Y2MDY3NmFkMDU3ZWZjNzA4ZjE1YmIyMGM0YWI0M2ViODY0ZDhmZCJ9fX0="));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PET.MEESEEKS", null, "Mr. Meeseeks", "I’m Mr. Meeseeks, look at me!",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMDIwNmNjOWI4YWJkMzM2YmQ4MzdmYTc3ZjM3M2FhZjY4ZWU3ZDUzOGQ0MmFiMzQ3NWJjZmQwOTU1ODY3MSJ9fX0="));
    lobby.cosmetics.cosmeticsList.add(new Cosmetic("LOBBY.PET.MORTY", null, "Morty",
        "'Rick, what about the reality we left behind?' - Morty",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODdkNjdjOTE0MDZmNDJlZjE2OGI0NjQxMTBmMzEwNDk3YWQ1YzEzZDE5NzNhMDk4OGU0MGRiMTY2ZDI0MWNmNyJ9fX0="));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PET.RICK", null, "Rick", "Wubba Lubba Dub Dub!",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDA0M2U3ZjliNTYxZDk5ZWY2MmM3NmU1NjliMTczNzQzMThkNDEzZDQ1YzgxYmUwYWE0NTQ3NGQ4ZjY4MzcifX19"));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PET.STAN_LEE", null, "Stan Lee", "RIP Stan Lee",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjAzNTYwMmIwMDdlOWFiMmRhZDRmZDM5MGI2N2VhNzFkMDMyN2RiMjI3ODkxM2E4YWE1NmRlYmZiZTk3NjA1ZSJ9fX0="));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PET.TURTLE_KING", null, "Turtle King", "Be the king of the sea!",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWI3OGY3Njc0ZDEwNjMyNTUwNzBmZmZiMmVkYzFmMmI5MzE0ZmU2ODEzYTllYWI4NDQ0YzAzNTNhNzIzZDNkMiJ9fX0="));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PET.FLY", null, "Fly", "Everyone hates me... :(",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTM4NzgwOTZjNDJjNWY4NDY0NjE4MDkwOTVmYjkwZjcyZTkxMWIwZTdhMmFhZTIyMmNkMTMyNmE2Y2NiYiJ9fX0="));
    lobby.cosmetics.cosmeticsList.add(new Cosmetic("LOBBY.PET.PUG", null, "Pug", "Woof!",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzVmMjQyZWNlNmRkNzk5YTcyMmRjYmVlNTY1ZGU4ZWM0MWQwMTcyM2VmYWU1Mzg2ZDgxMzY5OWM3ZTM5ZmIifX19"));
    lobby.cosmetics.cosmeticsList.add(new Cosmetic("LOBBY.PET.HARAMBE", null, "Harambe", "RIP",
        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzdjMGVkOTMxY2FjODE1ZDllZTA1M2ExOTgzZTg3MTliMTIyZjJhODUyYjJmYTViZmU1MjVkZThkMWE3In19fQ=="));

    //lobby.cosmetics.cosmeticsList.add(new Cosmetic("LOBBY.PET.", null, "", "", ""));

    //Particles
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.ANGELWINGS", Material.IRON_CHESTPLATE, "Angel Wings",
            "&fYou're going to heaven.", null));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.BLOODHELIX", Material.REDSTONE, "Blood Helix",
            "&fYou're going to heaven.", null));
    lobby.cosmetics.cosmeticsList
        .add(new Cosmetic("LOBBY.PARTICLE.CONE", Material.HOPPER, "Cone", "&fCone head...?", null));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.ENCHANTED", Material.ENCHANTING_TABLE, "Enchanted",
            "&fYou're a wizard Harry!", null));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.ENDERAURA", Material.ENDER_PEARL, "Ender Aura",
            "&fWatch out for the slender man!", null));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.FLAMEFAIRY", Material.FIRE_CHARGE, "Flame Fairy",
            "&fWho said fairies didn't exist?", null));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.FROZENWALK", Material.ICE, "Frozen Walk",
            "&fBrrrr... It's chilly outside.", null));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.GREENSPARKS", Material.GRASS, "Green Sparks",
            "&fYou are the green lantern.", null));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.INLOVE", Material.ROSE_RED, "In Love", "&fAre you in love?",
            null));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.MUSIC", Material.JUKEBOX, "DJ in the House",
            "&fShots! Shots! Shots! -LilJohn", null));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.RAINCLOUD", Material.WATER_BUCKET, "Rain Cloud",
            "&fBetter get an umbrella!", null));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.SANTAHAT", Material.COAL, "Santa Hat", "&fHo Ho Ho!", null));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.SNOWCLOUD", Material.SNOWBALL, "Snow Cloud",
            "&fIs it really that time of year?", null));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.SNOWWALK", Material.SNOW_BLOCK, "Snow Walk",
            "&fAre you frosty the snowman?", null));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.CRITICALWALK", Material.IRON_SWORD, "Critical Walk",
            "&fYou're the G.O.A.T.", null));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.FIREWALK", Material.FIREWORK_STAR, "Fire Walk",
            "&fShark boy & Lava girl?", null));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.PORTALWALK", Material.NETHER_STAR, "Portal Walk",
            "&fYou're going to the underworld...", null));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.MAGICWALK", Material.ENCHANTED_BOOK, "Magic Walk",
            "&fMagic Mike?", null));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.BOUNCE", Material.DIAMOND_BOOTS, "Bounce",
            "&fBouncy Bouncy! (Shift to activate.)", null));
    lobby.cosmetics.cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.FIREWORK", Material.FIREWORK_ROCKET, "Firework",
            "&fDon't blow things up jimmy... (Shift to activate.)", null));

  }

}
