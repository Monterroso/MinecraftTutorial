package net.lordoflizardz.onemillionbananas.event;
import net.lordoflizardz.onemillionbananas.OneMillionBananas;
import net.lordoflizardz.onemillionbananas.event.loot.DowsingRodInIglooAdditionModifier;
import net.lordoflizardz.onemillionbananas.event.loot.TurnipSeedsFromGrassAdditionModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = OneMillionBananas.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {
        event.getRegistry().registerAll(
                new TurnipSeedsFromGrassAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(OneMillionBananas.MOD_ID,"turnip_seeds_from_grass")),
                new DowsingRodInIglooAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(OneMillionBananas.MOD_ID,"dowsing_rod_in_igloo"))
        );
    }
}