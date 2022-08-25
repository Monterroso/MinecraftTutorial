package net.lordoflizardz.onemillionbananas;

import net.lordoflizardz.onemillionbananas.block.ModBlocks;
import net.lordoflizardz.onemillionbananas.block.ModWoodTypes;
import net.lordoflizardz.onemillionbananas.block.entity.ModBlockEntities;
import net.lordoflizardz.onemillionbananas.config.OneMillionBananasClientConfigs;
import net.lordoflizardz.onemillionbananas.config.OneMillionBananasCommonConfigs;
import net.lordoflizardz.onemillionbananas.effect.ModEffects;
import net.lordoflizardz.onemillionbananas.enchantment.ModEnchantments;
import net.lordoflizardz.onemillionbananas.entity.ModEntityTypes;
import net.lordoflizardz.onemillionbananas.entity.client.ModBoatRenderer;
import net.lordoflizardz.onemillionbananas.entity.client.RaccoonRenderer;
import net.lordoflizardz.onemillionbananas.entity.client.TigerRenderer;
import net.lordoflizardz.onemillionbananas.fluid.ModFluids;
import net.lordoflizardz.onemillionbananas.item.ModItem;
import net.lordoflizardz.onemillionbananas.painting.ModPaintings;
import net.lordoflizardz.onemillionbananas.potion.ModPotions;
import net.lordoflizardz.onemillionbananas.recipe.ModRecipes;
import net.lordoflizardz.onemillionbananas.screen.CobaltBlasterScreen;
import net.lordoflizardz.onemillionbananas.screen.ModMenuTypes;
import net.lordoflizardz.onemillionbananas.sound.ModSounds;
import net.lordoflizardz.onemillionbananas.util.BetterBrewingRecipe;
import net.lordoflizardz.onemillionbananas.util.ModItemProperties;
import net.lordoflizardz.onemillionbananas.util.ModTags;
import net.lordoflizardz.onemillionbananas.village.ModVillagers;
import net.lordoflizardz.onemillionbananas.world.structure.ModStructures;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

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

        ModEffects.register(eventBus);

        ModPotions.register(eventBus);

        ModEntityTypes.register(eventBus);

        GeckoLib.initialize();

        ModStructures.register(eventBus);

        ModVillagers.register(eventBus);

        eventBus.addListener(this::setup);

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, OneMillionBananasClientConfigs.SPEC, "onemillionbananas-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, OneMillionBananasCommonConfigs.SPEC, "onemillionbananas-common.toml");

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
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

        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                ModItem.COBALT_INGOT.get(), ModPotions.FREEZE_POTION.get()));

        ModVillagers.registerPOIs();
    }


}
