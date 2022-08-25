package net.lordoflizardz.onemillionbananas.world.gen;

import net.lordoflizardz.onemillionbananas.world.feature.ModPlacedFeatures;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class ModOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event) {
            List<Supplier<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

            base.add(() -> ModPlacedFeatures.COBALT_ORE_PLACED);
    }
}
