package net.lordoflizardz.onemillionbananas.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier COBALT = new ForgeTier(1, 5, 100f,
            5f, 3, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItem.COBALT_INGOT.get()));
}
