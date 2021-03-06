package net.lordoflizardz.onemillionbananas;

import net.lordoflizardz.onemillionbananas.block.ModBlocks;
import net.lordoflizardz.onemillionbananas.block.ModWoodTypes;
import net.lordoflizardz.onemillionbananas.block.entity.ModBlockEntities;
import net.lordoflizardz.onemillionbananas.enchantment.ModEnchantments;
import net.lordoflizardz.onemillionbananas.fluid.ModFluids;
import net.lordoflizardz.onemillionbananas.item.ModItem;
import net.lordoflizardz.onemillionbananas.painting.ModPaintings;
import net.lordoflizardz.onemillionbananas.recipe.ModRecipes;
import net.lordoflizardz.onemillionbananas.screen.CobaltBlasterScreen;
import net.lordoflizardz.onemillionbananas.screen.ModMenuTypes;
import net.lordoflizardz.onemillionbananas.sound.ModSounds;
import net.lordoflizardz.onemillionbananas.util.ModItemProperties;
import net.lordoflizardz.onemillionbananas.util.ModTags;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
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

        ModSounds.register(eventBus);

        ModEnchantments.register(eventBus);

        ModPaintings.register(eventBus);

        ModFluids.register(eventBus);

        ModBlockEntities.register(eventBus);

        ModMenuTypes.register(eventBus);

        ModRecipes.register(eventBus);

        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_BLOSSOM_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_BLOSSOM_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TURNIP_CROP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PINK_ROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_PINK_ROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.COBALT_BLASTER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_BLOSSOM_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_BLOSSOM_LEAVES.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModFluids.HONEY_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.HONEY_FLUID.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.HONEY_FLOWING.get(), RenderType.translucent());

        ModItemProperties.addCustomItemProperties();

        MenuScreens.register(ModMenuTypes.COBALT_BLASTER_MENU.get(), CobaltBlasterScreen::new);

        WoodType.register(ModWoodTypes.CHERRY_BLOSSOM);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(ModItem.TURNIP_SEEDS.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModItem.TURNIP.get(), 0.65f);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PINK_ROSE.getId(), ModBlocks.POTTED_PINK_ROSE);
        });

        BlockEntityRenderers.register(ModBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
        Sheets.addWoodType(ModWoodTypes.CHERRY_BLOSSOM);
    }


}
