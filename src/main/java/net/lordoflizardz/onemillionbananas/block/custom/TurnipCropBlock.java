package net.lordoflizardz.onemillionbananas.block.custom;

import net.lordoflizardz.onemillionbananas.item.ModItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BeetrootBlock;

public class TurnipCropBlock extends BeetrootBlock {
    public TurnipCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItem.TURNIP_SEEDS.get();
    }
}
