package iceheart.archeology;

import iceheart.archeology.common.blocks.LightningRod;
import iceheart.archeology.core.init.BlockInit;
import iceheart.archeology.core.init.ItemInit;
import iceheart.archeology.core.world.OreGeneration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EventObject;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("archeology")
public class Archeology {
    public static String MOD_ID = "archeology";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Archeology() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
        bus.addListener(this::setup);
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGHEST, OreGeneration::generateOres);
        //MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, LightningRod::catch_lightning);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code

    }
}
