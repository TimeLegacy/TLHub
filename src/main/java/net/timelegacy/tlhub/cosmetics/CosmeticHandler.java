package net.timelegacy.tlhub.cosmetics;

import de.erethon.headlib.HeadLib;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.timelegacy.tlcore.handler.PerkHandler;
import net.timelegacy.tlcore.utils.MessageUtils;
import net.timelegacy.tlhub.TLHub;
import net.timelegacy.tlhub.cosmetics.gadgets.AnimalCannon;
import net.timelegacy.tlhub.cosmetics.gadgets.BatLauncher;
import net.timelegacy.tlhub.cosmetics.gadgets.DiscoBall;
import net.timelegacy.tlhub.cosmetics.gadgets.Evolution;
import net.timelegacy.tlhub.cosmetics.gadgets.ExplosiveSnowball;
import net.timelegacy.tlhub.cosmetics.gadgets.Firecracker;
import net.timelegacy.tlhub.cosmetics.gadgets.Gadget;
import net.timelegacy.tlhub.cosmetics.gadgets.HeadRider;
import net.timelegacy.tlhub.cosmetics.gadgets.PaintballGun;
import net.timelegacy.tlhub.cosmetics.gadgets.Partner;
import net.timelegacy.tlhub.cosmetics.gadgets.PartyPopper;
import net.timelegacy.tlhub.cosmetics.gadgets.SheepBomb;
import net.timelegacy.tlhub.cosmetics.gadgets.SuperPunch;
import net.timelegacy.tlhub.cosmetics.gadgets.TNTFountain;
import net.timelegacy.tlhub.cosmetics.gadgets.ThorsHammer;
import net.timelegacy.tlhub.cosmetics.hats.Hat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.AHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.BHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.CHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.DHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.EHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.FHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.GHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.HHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.IHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.JHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.KHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.LHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.MHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.NHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.OHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.PHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.QHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.RHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.SHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.THat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.UHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.VHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.WHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.XHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.YHat;
import net.timelegacy.tlhub.cosmetics.hats.alphabet.ZHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.BatHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.BeeHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.ChickenHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.ClowfishHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.CowHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.DogeHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.DonkeyHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.DuckHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.ElephantHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.FerretHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.FoxHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.HorseHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.KoalaHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.LlamaHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.MonkeyHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.MuleHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.OcelotHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.OwlHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.PandaHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.ParrotHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.PenguinHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.PigHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.PolarBearHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.PugHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.RabbitHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.ReindeerHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.SheepHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.SlothHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.SquidHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.TurtleHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.WalrusHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.WaspHat;
import net.timelegacy.tlhub.cosmetics.hats.animals.WolfHat;
import net.timelegacy.tlhub.cosmetics.hats.blocks.BookshelfHat;
import net.timelegacy.tlhub.cosmetics.hats.blocks.CactusHat;
import net.timelegacy.tlhub.cosmetics.hats.blocks.ChestHat;
import net.timelegacy.tlhub.cosmetics.hats.blocks.CommandBlockHat;
import net.timelegacy.tlhub.cosmetics.hats.blocks.EnderChestHat;
import net.timelegacy.tlhub.cosmetics.hats.blocks.MissingTextureHat;
import net.timelegacy.tlhub.cosmetics.hats.blocks.NetherPortalHat;
import net.timelegacy.tlhub.cosmetics.hats.blocks.NoteblockHat;
import net.timelegacy.tlhub.cosmetics.hats.blocks.PistonHat;
import net.timelegacy.tlhub.cosmetics.hats.blocks.PumpkinHat;
import net.timelegacy.tlhub.cosmetics.hats.blocks.SlimeBlockHat;
import net.timelegacy.tlhub.cosmetics.hats.blocks.StickyPistonHat;
import net.timelegacy.tlhub.cosmetics.hats.blocks.TNTHat;
import net.timelegacy.tlhub.cosmetics.hats.countries.AustraliaHat;
import net.timelegacy.tlhub.cosmetics.hats.countries.CanadaHat;
import net.timelegacy.tlhub.cosmetics.hats.countries.ChileHat;
import net.timelegacy.tlhub.cosmetics.hats.countries.EnglandHat;
import net.timelegacy.tlhub.cosmetics.hats.countries.FranceHat;
import net.timelegacy.tlhub.cosmetics.hats.countries.GermanyHat;
import net.timelegacy.tlhub.cosmetics.hats.countries.ItalyHat;
import net.timelegacy.tlhub.cosmetics.hats.countries.MonacoHat;
import net.timelegacy.tlhub.cosmetics.hats.countries.NetherlandsHat;
import net.timelegacy.tlhub.cosmetics.hats.countries.NorwayHat;
import net.timelegacy.tlhub.cosmetics.hats.countries.SingaporeHat;
import net.timelegacy.tlhub.cosmetics.hats.countries.SpainHat;
import net.timelegacy.tlhub.cosmetics.hats.countries.SwedenHat;
import net.timelegacy.tlhub.cosmetics.hats.countries.UnitedStatesHat;
import net.timelegacy.tlhub.cosmetics.hats.food.BreadHat;
import net.timelegacy.tlhub.cosmetics.hats.food.BurgerHat;
import net.timelegacy.tlhub.cosmetics.hats.food.CakeHat;
import net.timelegacy.tlhub.cosmetics.hats.food.CandyCaneHat;
import net.timelegacy.tlhub.cosmetics.hats.food.CheeseHat;
import net.timelegacy.tlhub.cosmetics.hats.food.ChocolateHat;
import net.timelegacy.tlhub.cosmetics.hats.food.CoconutHat;
import net.timelegacy.tlhub.cosmetics.hats.food.CookieHat;
import net.timelegacy.tlhub.cosmetics.hats.food.MelonHat;
import net.timelegacy.tlhub.cosmetics.hats.food.PinkDonutHat;
import net.timelegacy.tlhub.cosmetics.hats.food.PopcornHat;
import net.timelegacy.tlhub.cosmetics.hats.food.SandwichHat;
import net.timelegacy.tlhub.cosmetics.hats.food.StrawberryHat;
import net.timelegacy.tlhub.cosmetics.hats.food.TacoHat;
import net.timelegacy.tlhub.cosmetics.hats.food.WhiteChocolateHat;
import net.timelegacy.tlhub.cosmetics.hats.miscellaneous.AstronautHat;
import net.timelegacy.tlhub.cosmetics.hats.miscellaneous.BeachBallHat;
import net.timelegacy.tlhub.cosmetics.hats.miscellaneous.CompanionCubeHat;
import net.timelegacy.tlhub.cosmetics.hats.miscellaneous.ElfHat;
import net.timelegacy.tlhub.cosmetics.hats.miscellaneous.GhostHat;
import net.timelegacy.tlhub.cosmetics.hats.miscellaneous.JackOLanternHat;
import net.timelegacy.tlhub.cosmetics.hats.miscellaneous.JakeHat;
import net.timelegacy.tlhub.cosmetics.hats.miscellaneous.LichHat;
import net.timelegacy.tlhub.cosmetics.hats.miscellaneous.LuigiHat;
import net.timelegacy.tlhub.cosmetics.hats.miscellaneous.MarioHat;
import net.timelegacy.tlhub.cosmetics.hats.miscellaneous.MasterballHat;
import net.timelegacy.tlhub.cosmetics.hats.miscellaneous.PokeballHat;
import net.timelegacy.tlhub.cosmetics.hats.miscellaneous.RainbowGlitchHat;
import net.timelegacy.tlhub.cosmetics.hats.miscellaneous.SkullHat;
import net.timelegacy.tlhub.cosmetics.hats.miscellaneous.SnowglobeHat;
import net.timelegacy.tlhub.cosmetics.hats.miscellaneous.SnowmanHat;
import net.timelegacy.tlhub.cosmetics.hats.miscellaneous.ToasterHat;
import net.timelegacy.tlhub.cosmetics.hats.monsters.BlazeHat;
import net.timelegacy.tlhub.cosmetics.hats.monsters.CaveSpiderHat;
import net.timelegacy.tlhub.cosmetics.hats.monsters.CreeperHat;
import net.timelegacy.tlhub.cosmetics.hats.monsters.ElderGuardianHat;
import net.timelegacy.tlhub.cosmetics.hats.monsters.EnderDragonHat;
import net.timelegacy.tlhub.cosmetics.hats.monsters.EndermanHat;
import net.timelegacy.tlhub.cosmetics.hats.monsters.GhastHat;
import net.timelegacy.tlhub.cosmetics.hats.monsters.GuardianHat;
import net.timelegacy.tlhub.cosmetics.hats.monsters.MagmaCubeHat;
import net.timelegacy.tlhub.cosmetics.hats.monsters.ShulkerHat;
import net.timelegacy.tlhub.cosmetics.hats.monsters.SkeletonHat;
import net.timelegacy.tlhub.cosmetics.hats.monsters.SlimeHat;
import net.timelegacy.tlhub.cosmetics.hats.monsters.SpiderHat;
import net.timelegacy.tlhub.cosmetics.hats.monsters.WitchHat;
import net.timelegacy.tlhub.cosmetics.hats.monsters.WitherSkeletonHat;
import net.timelegacy.tlhub.cosmetics.hats.monsters.ZombieHat;
import net.timelegacy.tlhub.cosmetics.hats.monsters.ZombiePigmanHat;
import net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation.EightHat;
import net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation.ExclamationMarkHat;
import net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation.FiveHat;
import net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation.FourHat;
import net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation.HashtagHat;
import net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation.NineHat;
import net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation.OneHat;
import net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation.PlusHat;
import net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation.QuestionMarkHat;
import net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation.SevenHat;
import net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation.SixHat;
import net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation.ThreeHat;
import net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation.TwoHat;
import net.timelegacy.tlhub.cosmetics.hats.numbersandpunctuation.ZeroHat;
import net.timelegacy.tlhub.cosmetics.hats.planets.EarthHat;
import net.timelegacy.tlhub.cosmetics.hats.planets.JupiterHat;
import net.timelegacy.tlhub.cosmetics.hats.planets.MarsHat;
import net.timelegacy.tlhub.cosmetics.hats.planets.MercuryHat;
import net.timelegacy.tlhub.cosmetics.hats.planets.NeptuneHat;
import net.timelegacy.tlhub.cosmetics.hats.planets.PlutoHat;
import net.timelegacy.tlhub.cosmetics.hats.planets.SaturnHat;
import net.timelegacy.tlhub.cosmetics.hats.planets.UranusHat;
import net.timelegacy.tlhub.cosmetics.hats.planets.VenusHat;
import net.timelegacy.tlhub.cosmetics.particles.AngelWings;
import net.timelegacy.tlhub.cosmetics.particles.BloodHelix;
import net.timelegacy.tlhub.cosmetics.particles.CandyCane;
import net.timelegacy.tlhub.cosmetics.particles.Cone;
import net.timelegacy.tlhub.cosmetics.particles.Enchanted;
import net.timelegacy.tlhub.cosmetics.particles.EnderAura;
import net.timelegacy.tlhub.cosmetics.particles.FlameFairy;
import net.timelegacy.tlhub.cosmetics.particles.FrozenWalk;
import net.timelegacy.tlhub.cosmetics.particles.GreenSparks;
import net.timelegacy.tlhub.cosmetics.particles.InLove;
import net.timelegacy.tlhub.cosmetics.particles.Music;
import net.timelegacy.tlhub.cosmetics.particles.Particle;
import net.timelegacy.tlhub.cosmetics.particles.RainCloud;
import net.timelegacy.tlhub.cosmetics.particles.SantaHat;
import net.timelegacy.tlhub.cosmetics.particles.SnowCloud;
import net.timelegacy.tlhub.cosmetics.particles.Walks;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class CosmeticHandler implements Listener {

  private final TLHub plugin;

  private Map<UUID, Gadget> activeGadgets = new HashMap<>();
  private static HashMap<Player, String> effects = new HashMap<>();

  private List<Gadget> gadgets = new ArrayList<>();
  private List<Particle> particles = new ArrayList<>();
  private List<Hat> hats = new ArrayList<>();

  public CosmeticHandler(TLHub plugin) {
    this.plugin = plugin;
  }

  public void registerCosmetics() {
    registerGadgets();
    registerParticles();
    registerHats();
    registerOutfits();

    registerRunnables();
  }

  private void registerGadgets() {
    gadgets.add(new SuperPunch(plugin));
    //gadgets.add(new HeadRider(plugin));
    //gadgets.add(new Evolution(plugin));
    gadgets.add(new Partner(plugin));
    gadgets.add(new ThorsHammer(plugin));
    gadgets.add(new AnimalCannon(plugin));
    gadgets.add(new PaintballGun(plugin));
    gadgets.add(new Firecracker(plugin));
    gadgets.add(new DiscoBall(plugin));
    gadgets.add(new BatLauncher(plugin));
    gadgets.add(new PartyPopper(plugin));
    gadgets.add(new SheepBomb(plugin));
    gadgets.add(new ExplosiveSnowball(plugin));
    gadgets.add(new TNTFountain(plugin));
  }

  private void registerParticles() {
    particles.add(new AngelWings(plugin));
    particles.add(new BloodHelix(plugin));
    particles.add(new CandyCane(plugin));
    particles.add(new Cone(plugin));
    particles.add(new Enchanted(plugin));
    particles.add(new EnderAura(plugin));
    particles.add(new FlameFairy(plugin));
    particles.add(new GreenSparks(plugin));
    particles.add(new InLove(plugin));
    particles.add(new Music(plugin));
    particles.add(new RainCloud(plugin));
    particles.add(new SantaHat(plugin));
    particles.add(new SnowCloud(plugin));
  }

  private void registerHats() {
    // Alphabet
    hats.add(new AHat());
    hats.add(new BHat());
    hats.add(new CHat());
    hats.add(new DHat());
    hats.add(new EHat());
    hats.add(new FHat());
    hats.add(new GHat());
    hats.add(new HHat());
    hats.add(new IHat());
    hats.add(new JHat());
    hats.add(new KHat());
    hats.add(new LHat());
    hats.add(new MHat());
    hats.add(new NHat());
    hats.add(new OHat());
    hats.add(new PHat());
    hats.add(new QHat());
    hats.add(new RHat());
    hats.add(new SHat());
    hats.add(new THat());
    hats.add(new UHat());
    hats.add(new VHat());
    hats.add(new WHat());
    hats.add(new XHat());
    hats.add(new YHat());
    hats.add(new ZHat());

    // Numbers & Punctuation
    hats.add(new ZeroHat());
    hats.add(new OneHat());
    hats.add(new TwoHat());
    hats.add(new ThreeHat());
    hats.add(new FourHat());
    hats.add(new FiveHat());
    hats.add(new SixHat());
    hats.add(new SevenHat());
    hats.add(new EightHat());
    hats.add(new NineHat());
    hats.add(new PlusHat());
    hats.add(new HashtagHat());
    hats.add(new QuestionMarkHat());
    hats.add(new ExclamationMarkHat());

    // Animals
    hats.add(new CowHat());
    hats.add(new SheepHat());
    hats.add(new PigHat());
    hats.add(new ChickenHat());
    hats.add(new LlamaHat());
    hats.add(new BatHat());
    hats.add(new RabbitHat());
    hats.add(new WolfHat());
    hats.add(new OcelotHat());
    hats.add(new HorseHat());
    hats.add(new DonkeyHat());
    hats.add(new MuleHat());
    hats.add(new ParrotHat());
    hats.add(new SquidHat());
    hats.add(new TurtleHat());
    hats.add(new PolarBearHat());
    hats.add(new PandaHat());
    hats.add(new FoxHat());
    hats.add(new DogeHat());
    hats.add(new OwlHat());
    hats.add(new PugHat());
    hats.add(new ElephantHat());
    hats.add(new DuckHat());
    hats.add(new BeeHat());
    hats.add(new WaspHat());
    hats.add(new WalrusHat());
    hats.add(new PenguinHat());
    hats.add(new ClowfishHat());
    hats.add(new KoalaHat());
    hats.add(new SlothHat());
    hats.add(new FerretHat());
    hats.add(new MonkeyHat());
    hats.add(new ReindeerHat());

    // Monsters
    hats.add(new ZombieHat());
    hats.add(new SkeletonHat());
    hats.add(new CreeperHat());
    hats.add(new SpiderHat());
    hats.add(new CaveSpiderHat());
    hats.add(new EndermanHat());
    hats.add(new SlimeHat());
    hats.add(new WitchHat());
    hats.add(new GuardianHat());
    hats.add(new ElderGuardianHat());
    hats.add(new ZombiePigmanHat());
    hats.add(new WitherSkeletonHat());
    hats.add(new MagmaCubeHat());
    hats.add(new BlazeHat());
    hats.add(new GhastHat());
    hats.add(new ShulkerHat());
    hats.add(new EnderDragonHat());

    // Blocks
    hats.add(new NoteblockHat());
    hats.add(new CommandBlockHat());
    hats.add(new PistonHat());
    hats.add(new StickyPistonHat());
    hats.add(new CactusHat());
    hats.add(new PumpkinHat());
    hats.add(new ChestHat());
    hats.add(new EnderChestHat());
    hats.add(new BookshelfHat());
    hats.add(new TNTHat());
    hats.add(new SlimeBlockHat());
    hats.add(new NetherPortalHat());
    hats.add(new MissingTextureHat());

    // Food
    hats.add(new BreadHat());
    hats.add(new CheeseHat());
    hats.add(new CakeHat());
    hats.add(new CookieHat());
    hats.add(new ChocolateHat());
    hats.add(new WhiteChocolateHat());
    hats.add(new CandyCaneHat());
    hats.add(new MelonHat());
    hats.add(new StrawberryHat());
    hats.add(new CoconutHat());
    hats.add(new TacoHat());
    hats.add(new BurgerHat());
    hats.add(new PopcornHat());
    hats.add(new PinkDonutHat());
    hats.add(new SandwichHat());

    // Planets
    hats.add(new MercuryHat());
    hats.add(new VenusHat());
    hats.add(new EarthHat());
    hats.add(new MarsHat());
    hats.add(new JupiterHat());
    hats.add(new SaturnHat());
    hats.add(new UranusHat());
    hats.add(new NeptuneHat());
    hats.add(new PlutoHat());

    // Countries
    hats.add(new NetherlandsHat());
    hats.add(new NorwayHat());
    hats.add(new SwedenHat());
    hats.add(new ChileHat());
    hats.add(new MonacoHat());
    hats.add(new CanadaHat());
    hats.add(new UnitedStatesHat());
    hats.add(new ItalyHat());
    hats.add(new EnglandHat());
    hats.add(new GermanyHat());
    hats.add(new SingaporeHat());
    hats.add(new FranceHat());
    hats.add(new SpainHat());
    hats.add(new AustraliaHat());

    // Miscellaneous
    hats.add(new BeachBallHat());
    hats.add(new ToasterHat());
    hats.add(new SnowmanHat());
    hats.add(new SnowglobeHat());
    hats.add(new GhostHat());
    hats.add(new JackOLanternHat());
    hats.add(new SkullHat());
    hats.add(new AstronautHat());
    hats.add(new ElfHat());
    hats.add(new CompanionCubeHat());
    hats.add(new RainbowGlitchHat());
    hats.add(new PokeballHat());
    hats.add(new MasterballHat());
    hats.add(new MarioHat());
    hats.add(new LuigiHat());
    hats.add(new JakeHat());
    hats.add(new LichHat());
  }

  private void registerOutfits() {

  }

  private void registerRunnables() {
    for (Gadget gadget : gadgets) {
      gadget.registerExtraListeners();
    }

    for (Particle particle : particles) {
      particle.registerRunnable();
    }
  }

  public List<Gadget> getGadgets() {
    return gadgets;
  }

  public List<Particle> getParticles() {
    return particles;
  }

  public List<Hat> getHats() {
    return hats;
  }

  /**
   * TODO - MAKE THE COSMETIC MENUS & PETS MENUS DYNAMIC & HATS DYNAMIC
   */
  public static void register() {
    // Particle Runnables
    FrozenWalk.particleRunnable();
    Walks.particleRunnable();

    //syncPets();
  }

  public boolean hasActiveGadget(UUID uuid) {
    return activeGadgets.containsKey(uuid);
  }

  public void setActiveGadget(UUID uuid, Gadget gadget) {
    activeGadgets.put(uuid, gadget);
  }

  public void removeActiveGadget(UUID uuid) {
    activeGadgets.remove(uuid);
  }

  public Gadget getActiveGadget(UUID uuid) {
    return activeGadgets.get(uuid);
  }

  public static void setParticle(Player player, String cosmetic) {
    if (effects.containsKey(player)) {
      effects.remove(player);
      effects.put(player, cosmetic.toUpperCase());

    } else {
      effects.put(player, cosmetic);
    }
  }

  public static boolean particleEnabled(Player player, String cosmetic) {
    return effects.containsKey(player) && effects.get(player).equalsIgnoreCase(cosmetic);
  }

  public static boolean hasParticle(Player player) {
    return effects.containsKey(player);
  }

  public static void removeParticle(Player player) {
    effects.remove(player);
  }

  private static int getDirection(Player player) {
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

  public static List<Cosmetic> getCosmetics() {

    List<Cosmetic> cosmeticsList = new ArrayList<>();

    // Pets
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PET.FROG",
            null,
            "Frog",
            "Ribit, Ribit!",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTE1NTQxMmZkMTFkY2QwYWJhNzdhMTgzNzg1ODM1MzdlNzYyNWM2ZjcxZmU0NTJmN2E3MTdkYWUzMzI2ZjIyYSJ9fX0="));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PET.PUFFERFISH",
            null,
            "Pufferfish",
            "Don't scare me! I'll hurt you.",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTcwOTAyOTk3MzJjNTFlZGFmNmM1ZGQ2YWUzZWRkNTk0MzNkYTM3YTc4NzhiOWY0YWY1NDI4ZDdlZDI1N2Y0YiJ9fX0="));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PET.PINK_BUNNY",
            null,
            "Pink Bunny",
            "I like to bounce.",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWIzYTdhYTY5Y2RiNDEyN2Q1NWExYjQ3NmRmNzQ1MGYwMzJiYWQ3YzE1OWNjOTdjYzllNjVlMDIzMjQ5NWU0ZCJ9fX0="));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PET.SHARK",
            null,
            "Shark",
            "Woof, Woof. I'm not a dog.",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTk0YWU0MzNiMzAxYzdmYjdjNjhjYmE2MjViMGJkMzZiMGIxNDE5MGYyMGUzNGE3YzhlZTBkOWRlMDZkNTNiOSJ9fX0="));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PET.COP_DOGE",
            null,
            "Cop Doge",
            "I'm a cop doge.",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzZjMzZjNjc3MzRjMmQ5NzcwYzZiNDRmMDFlZjEzMTNhYzQ4MWFkY2MzZjM2OWIyZDM1MDgyOWVhMmExY2RjZSJ9fX0="));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PET.KING_DOGE",
            null,
            "King Doge",
            "I'm your king!",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzI4NTk1MGZkNjc4NThlNzZjNDM5YjBiNWI4N2M2OWE2YzUyYTRkZjkzNmUyMjRkODQzYjE0YzIyNTY1OTQ5ZSJ9fX0="));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PET.CYBORG_PARROT",
            null,
            "Cyborg Parrot",
            "Bee boop, bee bop.",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2IyYjQ0ODIzMTM5YWFlZjgzMTIyOGI0YmJkYmUzYmY3YWM2ZGFhOWJhYWIxMjMwNTY0NmU5ZmYzNjZlMzYwYiJ9fX0="));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PET.BEE",
            null,
            "Bee",
            "Buzz!",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjg2MThmNDFkYmIzMGQ3MWE4MzE1N2Q2OTYxYjAyM2Y4MTIzMDIxMjFkNzEwNTY5YzkwZmJjMWY0NGRjMTEzNyJ9fX0="));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PET.BURGER",
            null,
            "Royal w/ Cheese",
            "This is a tasty burger!",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzE4NzRjNzJjZmZkM2MyOWE0YjEyZDQzNTkwNjZkNmM4OTUyNTI5NzE3MmFiZjYyNzI3OTI5ZmViNDZmNDEifX19"));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PET.MELON",
            null,
            "Melon",
            "I'm 99% ish water!",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDU4NjcwNTUxZjdmZjEzYWZhYjIzOTMxOGExMGJhZDIzMjdlZTc0MmUxNTc4MzdlYTE3ODVlZjQ0M2QzYTU3NiJ9fX0="));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PET.ARTICUNO",
            null,
            "Articuno",
            "Gotta catch them all!",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzRiZDg5ZGM5NTI4Y2UyZDljMjk3MjU0YzMyMDUwNjE5NTFlYjZiMmYwNjNhZTg0ZGFmY2Q0ZWY3OTc4In19fQ=="));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PET.BOJACK",
            null,
            "Bojack Horseman",
            "'Dead on the inside, dead on the outside.' - Bojack Horseman",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTg2NjA0MWQzZjBiMGY4YjE3ZjdkMmNjN2Y2MDY3NmFkMDU3ZWZjNzA4ZjE1YmIyMGM0YWI0M2ViODY0ZDhmZCJ9fX0="));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PET.MEESEEKS",
            null,
            "Mr. Meeseeks",
            "I’m Mr. Meeseeks, look at me!",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMDIwNmNjOWI4YWJkMzM2YmQ4MzdmYTc3ZjM3M2FhZjY4ZWU3ZDUzOGQ0MmFiMzQ3NWJjZmQwOTU1ODY3MSJ9fX0="));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PET.MORTY",
            null,
            "Morty",
            "'Rick, what about the reality we left behind?' - Morty",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODdkNjdjOTE0MDZmNDJlZjE2OGI0NjQxMTBmMzEwNDk3YWQ1YzEzZDE5NzNhMDk4OGU0MGRiMTY2ZDI0MWNmNyJ9fX0="));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PET.RICK",
            null,
            "Rick",
            "Wubba Lubba Dub Dub!",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDA0M2U3ZjliNTYxZDk5ZWY2MmM3NmU1NjliMTczNzQzMThkNDEzZDQ1YzgxYmUwYWE0NTQ3NGQ4ZjY4MzcifX19"));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PET.STAN_LEE",
            null,
            "Stan Lee",
            "RIP Stan Lee",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjAzNTYwMmIwMDdlOWFiMmRhZDRmZDM5MGI2N2VhNzFkMDMyN2RiMjI3ODkxM2E4YWE1NmRlYmZiZTk3NjA1ZSJ9fX0="));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PET.TURTLE_KING",
            null,
            "Turtle King",
            "Be the king of the sea!",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWI3OGY3Njc0ZDEwNjMyNTUwNzBmZmZiMmVkYzFmMmI5MzE0ZmU2ODEzYTllYWI4NDQ0YzAzNTNhNzIzZDNkMiJ9fX0="));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PET.FLY",
            null,
            "Fly",
            "Everyone hates me... :(",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTM4NzgwOTZjNDJjNWY4NDY0NjE4MDkwOTVmYjkwZjcyZTkxMWIwZTdhMmFhZTIyMmNkMTMyNmE2Y2NiYiJ9fX0="));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PET.PUG",
            null,
            "Pug",
            "Woof!",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzVmMjQyZWNlNmRkNzk5YTcyMmRjYmVlNTY1ZGU4ZWM0MWQwMTcyM2VmYWU1Mzg2ZDgxMzY5OWM3ZTM5ZmIifX19"));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PET.HARAMBE",
            null,
            "Harambe",
            "RIP",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzdjMGVkOTMxY2FjODE1ZDllZTA1M2ExOTgzZTg3MTliMTIyZjJhODUyYjJmYTViZmU1MjVkZThkMWE3In19fQ=="));

    // cosmeticsList.add(new Cosmetic("LOBBY.PET.", null, "", "", ""));

    // Particles
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PARTICLE.ANGELWINGS",
            Material.IRON_CHESTPLATE,
            "Angel Wings",
            "You're going to heaven.",
            null));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PARTICLE.BLOODHELIX",
            Material.REDSTONE,
            "Blood Helix",
            "You're going to heaven.",
            null));
    cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.CONE", Material.HOPPER, "Cone", "Cone head...?", null));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PARTICLE.ENCHANTED",
            Material.ENCHANTING_TABLE,
            "Enchanted",
            "You're a wizard Harry!",
            null));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PARTICLE.ENDERAURA",
            Material.ENDER_PEARL,
            "Ender Aura",
            "Watch out for the slender man!",
            null));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PARTICLE.FLAMEFAIRY",
            Material.FIRE_CHARGE,
            "Flame Fairy",
            "Who said fairies didn't exist?",
            null));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PARTICLE.FROZENWALK",
            Material.ICE,
            "Frozen Walk",
            "Brrrr... It's chilly outside.",
            null));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PARTICLE.GREENSPARKS",
            Material.GRASS,
            "Green Sparks",
            "You are the green lantern.",
            null));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PARTICLE.INLOVE", Material.ROSE_RED, "In Love", "Are you in love?", null));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PARTICLE.MUSIC",
            Material.JUKEBOX,
            "DJ in the House",
            "Shots! Shots! Shots! -LilJohn",
            null));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PARTICLE.RAINCLOUD",
            Material.WATER_BUCKET,
            "Rain Cloud",
            "Better get an umbrella!",
            null));
    cosmeticsList.add(
        new Cosmetic("LOBBY.PARTICLE.SANTAHAT", Material.COAL, "Santa Hat", "Ho Ho Ho!", null));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PARTICLE.SNOWCLOUD",
            Material.SNOWBALL,
            "Snow Cloud",
            "Is it really that time of year?",
            null));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PARTICLE.SNOWWALK",
            Material.SNOW_BLOCK,
            "Snow Walk",
            "Are you frosty the snowman?",
            null));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PARTICLE.CRITICALWALK",
            Material.IRON_SWORD,
            "Critical Walk",
            "You're the G.O.A.T.",
            null));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PARTICLE.FIREWALK",
            Material.FIREWORK_STAR,
            "Fire Walk",
            "Shark boy & Lava girl?",
            null));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PARTICLE.PORTALWALK",
            Material.NETHER_STAR,
            "Portal Walk",
            "You're going to the underworld...",
            null));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PARTICLE.MAGICWALK",
            Material.ENCHANTED_BOOK,
            "Magic Walk",
            "Magic Mike?",
            null));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PARTICLE.BOUNCE",
            Material.DIAMOND_BOOTS,
            "Bounce",
            "Bouncy Bouncy! (Shift to activate.)",
            null));
    cosmeticsList.add(
        new Cosmetic(
            "LOBBY.PARTICLE.FIREWORK",
            Material.FIREWORK_ROCKET,
            "Firework",
            "Don't blow things up jimmy... (Shift to activate.)",
            null));

    // Hats
    for (HeadLib head : HeadLib.values()) {
      cosmeticsList.add(
          new Cosmetic(
              "LOBBY.HAT." + head.name().toUpperCase(),
              null,
              MessageUtils.friendlyify(head.name().replace("_", " ")),
              "",
              HeadLib.getTextureValue(head.toItemStack())));
    }

    // Gadgets
    cosmeticsList.add(new Cosmetic("LOBBY.GADGET.SUPER_PUNCH", Material.SLIME_BALL, "Super Punch",
        "FALCON PUUUUNNNCH!", ""));
    cosmeticsList.add(new Cosmetic("LOBBY.GADGET.HEAD_RIDER", Material.SADDLE, "Head Rider",
        "Ride players for the fun of it.", ""));
    cosmeticsList.add(
        new Cosmetic("LOBBY.GADGET.EVOLUTION", Material.BONE, "Evolution", "Evolve your Pokemon!",
            ""));
    cosmeticsList.add(new Cosmetic("LOBBY.GADGET.PARTNER", Material.PLAYER_HEAD, "Partner",
        "Never be alone again.", ""));
    cosmeticsList.add(new Cosmetic("LOBBY.GADGET.THOR_HAMMER", Material.IRON_AXE, "Thor Hammer",
        "Summon the power of the god of thunder!", ""));
    cosmeticsList.add(
        new Cosmetic("LOBBY.GADGET.ANIMAL_CANNON", Material.SHEEP_SPAWN_EGG, "Animal Cannon",
            "Be careful! PETA is watching!", ""));
    cosmeticsList.add(
        new Cosmetic("LOBBY.GADGET.PAINTBALL_GUN", Material.DIAMOND_HORSE_ARMOR, "Paintball Gun",
            "Pew pew pew!", ""));
    cosmeticsList.add(
        new Cosmetic("LOBBY.GADGET.FIRECRACKER", Material.FIREWORK_ROCKET, "Firecracker",
            "Does what it says... It goes BOOM!", ""));
    cosmeticsList.add(
        new Cosmetic("LOBBY.GADGET.DISCO_BALL", Material.PURPLE_STAINED_GLASS, "Disco Ball",
            "It's party time!", ""));
    cosmeticsList.add(new Cosmetic("LOBBY.GADGET.BAT_LAUNCHER", Material.STICK, "Bat Launcher",
        "Launch a wave of bats!", ""));
    cosmeticsList.add(
        new Cosmetic("LOBBY.GADGET.PARTY_POPPER", Material.FIRE_CHARGE, "Party Popper",
            "Want to impress your friends?", ""));
    cosmeticsList.add(new Cosmetic("LOBBY.GADGET.SHEEP_BOMB", Material.WHITE_WOOL, "Sheep Bomb",
        "Is it supposed to be flashing? Uhhh... Yes?", ""));
    cosmeticsList.add(
        new Cosmetic("LOBBY.GADGET.EXPLOSIVE_SNOWBALL", Material.SNOWBALL, "Explosive Snowball",
            "They aren't ordinary snowballs.", ""));
    cosmeticsList.add(new Cosmetic("LOBBY.GADGET.TNT_FOUNTAIN", Material.TNT, "TNT Fountain",
        "Do you have the proper training to use this?", ""));

    return cosmeticsList;
  }

  public Map<String, Integer> getTotals(Player player) {
    Map<String, Integer> totals = new HashMap<>();

    List<String> perks = PerkHandler.getPerks(player.getUniqueId());

    int hatsInt = 0;
    int gadgetsInt = 0;
    int particlesInt = 0;
    int outfitsInt = 0;
    int petsInt = 0;

    int totalInt = hatsInt + gadgetsInt + particlesInt + outfitsInt + petsInt;

    int playerInt = 0;
    int playerHats = 0;
    int playerGadgets = 0;
    int playerParticles = 0;
    //int playerOutfits = 0;
    //int playerPets = 0;

    for (Gadget gadget : gadgets) {
      if (perks.contains(gadget.getPermissionNode())) {
        playerInt++;
        playerGadgets++;
      }

      gadgetsInt++;

      totals.put("player", playerInt);
      totals.put("playerGadgets", playerGadgets);
    }

    for (Particle particle : particles) {
      if (perks.contains(particle.getPermissionNode())) {
        playerInt++;
        playerParticles++;
      }

      particlesInt++;

      totals.put("player", playerInt);
      totals.put("playerParticles", playerParticles);
    }

    for (Hat hat : hats) {
      if (perks.contains(hat.getPermissionNode())) {
        playerInt++;
        playerHats++;
      }

      hatsInt++;

      totals.put("player", playerInt);
      totals.put("playerHats", playerHats);
    }

//    for (Cosmetic cosmetic : getCosmetics()) {
//      switch (cosmetic.getCosmeticType()) {
//        case "PARTICLE":
//          if (perks.contains(cosmetic.getPerkPerm())) {
//            playerInt++;
//            playerParticles++;
//          }
//          particlesInt++;
//          break;
//        case "PET":
//          if (perks.contains(cosmetic.getPerkPerm())) {
//            playerInt++;
//            playerPets++;
//          }
//          petsInt++;
//          break;
//        case "HAT":
//          if (perks.contains(cosmetic.getPerkPerm())) {
//            playerInt++;
//            playerHats++;
//          }
//          hatsInt++;
//          break;
//        case "GADGET":
//          if (perks.contains(cosmetic.getPerkPerm())) {
//            playerInt++;
//            playerGadgets++;
//          }
//          gadgetsInt++;
//          break;
//        case "OUTFIT":
//          if (perks.contains(cosmetic.getPerkPerm())) {
//            playerInt++;
//            playerOutfits++;
//          }
//          outfitsInt++;
//          break;
//      }
//
//      totals.put("player", playerInt);
//      totals.put("playerHats", playerHats);
//      totals.put("playerGadgets", playerGadgets);
//      totals.put("playerParticles", playerParticles);
//      totals.put("playerOutfits", playerOutfits);
//      totals.put("playerPets", playerOutfits);
//    }

    totals.put("hats", hatsInt);
    totals.put("gadgets", gadgetsInt);
    totals.put("total", totalInt);
    totals.put("particles", particlesInt);
    totals.put("outfits", outfitsInt);
    totals.put("pets", petsInt);

    return totals;
  }

  @EventHandler
  public void onLeave(PlayerQuitEvent event) {
    Player player = event.getPlayer();

    if (hasParticle(player)) {
      removeParticle(player);
    }

    if (hasActiveGadget(player.getUniqueId())) {
      removeActiveGadget(player.getUniqueId());
    }
  }
}
