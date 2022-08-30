package net.lordoflizardz.onemillionbananas.event;

import net.lordoflizardz.onemillionbananas.OneMillionBananas;
import net.lordoflizardz.onemillionbananas.entity.ModEntityTypes;
import net.lordoflizardz.onemillionbananas.entity.client.armor.CobaltArmorRenderer;
import net.lordoflizardz.onemillionbananas.entity.custom.RaccoonEntity;
import net.lordoflizardz.onemillionbananas.entity.custom.TigerEntity;
import net.lordoflizardz.onemillionbananas.item.custom.CobaltArmorItem;
import net.lordoflizardz.onemillionbananas.recipe.CobaltBlasterRecipe;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = OneMillionBananas.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegisterEvent event) {
//        event.register(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, helper -> {
//            helper.register(new ResourceLocation(OneMillionBananas.MOD_ID,"turnip_seeds_from_grass"),
//                    new TurnipSeedsFromGrassAdditionModifier.Serializer());
//            helper.register(new ResourceLocation(OneMillionBananas.MOD_ID,"dowsing_rod_in_igloo"),
//                    new DowsingRodInIglooAdditionModifier.Serializer());
//        });

        event.register(ForgeRegistries.Keys.RECIPE_TYPES, recipeTypeRegisterHelper -> {
            recipeTypeRegisterHelper.register(new ResourceLocation(OneMillionBananas.MOD_ID, CobaltBlasterRecipe.Type.ID),
                    CobaltBlasterRecipe.Type.INSTANCE);
        });
    }

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.RACCOON.get(), RaccoonEntity.setAttributes());
        event.put(ModEntityTypes.TIGER.get(), TigerEntity.setAttributes());
    }


    @SubscribeEvent
    public static void registerRecipeTypes(final RegisterEvent event) {
        Registry.register(Registry.RECIPE_TYPE, CobaltBlasterRecipe.Type.ID, CobaltBlasterRecipe.Type.INSTANCE);

    }

    @SubscribeEvent
    public static void registerRecipeTypes(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(CobaltArmorItem.class, new CobaltArmorRenderer());
    }
}