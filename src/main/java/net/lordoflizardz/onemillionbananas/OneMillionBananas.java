package net.lordoflizardz.onemillionbananas;

import net.lordoflizardz.onemillionbananas.block.ModBlocks;
import net.lordoflizardz.onemillionbananas.item.ModItem;
import net.lordoflizardz.onemillionbananas.util.ModTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OneMillionBananas.MOD_ID)
public class OneMillionBananas
{
    public static final String MOD_ID = "onemillionbananas";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public OneMillionBananas() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItem.register(eventBus);
        ModBlocks.register(eventBus);

        ModTags.register();

        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }


}
