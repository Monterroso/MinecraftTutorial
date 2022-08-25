package net.lordoflizardz.onemillionbananas.event;

import net.lordoflizardz.onemillionbananas.OneMillionBananas;
import net.lordoflizardz.onemillionbananas.block.ModBlocks;
import net.lordoflizardz.onemillionbananas.block.ModWoodTypes;
import net.lordoflizardz.onemillionbananas.block.entity.ModBlockEntities;
import net.lordoflizardz.onemillionbananas.block.entity.client.PedestalBlockEntityRenderer;
import net.lordoflizardz.onemillionbananas.entity.ModEntityTypes;
import net.lordoflizardz.onemillionbananas.entity.client.ModBoatRenderer;
import net.lordoflizardz.onemillionbananas.entity.client.RaccoonRenderer;
import net.lordoflizardz.onemillionbananas.entity.client.TigerRenderer;
import net.lordoflizardz.onemillionbananas.fluid.ModFluids;
import net.lordoflizardz.onemillionbananas.screen.CobaltBlasterScreen;
import net.lordoflizardz.onemillionbananas.screen.ModMenuTypes;
import net.lordoflizardz.onemillionbananas.util.ModItemProperties;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = OneMillionBananas.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.PEDESTAL.get(), PedestalBlockEntityRenderer::new);
    }

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
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

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WINTER_WINDOW.get(), RenderType.translucent());

        ModItemProperties.addCustomItemProperties();

        MenuScreens.register(ModMenuTypes.COBALT_BLASTER_MENU.get(), CobaltBlasterScreen::new);

        WoodType.register(ModWoodTypes.CHERRY_BLOSSOM);

        EntityRenderers.register(ModEntityTypes.RACCOON.get(), RaccoonRenderer::new);
        EntityRenderers.register(ModEntityTypes.TIGER.get(), TigerRenderer::new);
        EntityRenderers.register(ModEntityTypes.BOAT_ENTITY.get(), ModBoatRenderer::new);

    }
}