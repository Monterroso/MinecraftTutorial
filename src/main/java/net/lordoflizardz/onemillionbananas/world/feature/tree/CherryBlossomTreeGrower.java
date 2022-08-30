package net.lordoflizardz.onemillionbananas.world.feature.tree;

import net.lordoflizardz.onemillionbananas.world.feature.ModConfiguredFeature;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class CherryBlossomTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected Holder< ? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pLargeHive) {
        return ModConfiguredFeature.CHERRY_BLOSSOM_TREE;
    }
}
