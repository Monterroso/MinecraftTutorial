package net.lordoflizardz.onemillionbananas.block.custom;

import com.google.common.collect.ImmutableMap;
import net.lordoflizardz.onemillionbananas.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.function.Supplier;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {

    protected final int flammability;
    protected final int spreadSpeed;
    protected static final Map<Supplier<Block>, Supplier<Block>> STRIPPABLES =
            (new ImmutableMap.Builder<Supplier<Block>, Supplier<Block>>())
                    .put(() -> ModBlocks.CHERRY_BLOSSOM_LOG.get(), () -> ModBlocks.STRIPPED_CHERRY_BLOSSOM_LOG.get())
                    .put(() -> ModBlocks.CHERRY_BLOSSOM_WOOD.get(), () -> ModBlocks.STRIPPED_CHERRY_BLOSSOM_WOOD.get()).build();

    public ModFlammableRotatedPillarBlock(Properties properties) {
        this(properties, 5, 5);
    }

    public ModFlammableRotatedPillarBlock(Properties properties, int flammability, int spreadSpeed) {
        super(properties);
        this.flammability = flammability;
        this.spreadSpeed = spreadSpeed;
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return flammability;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return spreadSpeed;
    }

    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(ModBlocks.CHERRY_BLOSSOM_LOG.get())) {
                return ModBlocks.STRIPPED_CHERRY_BLOSSOM_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocks.CHERRY_BLOSSOM_WOOD.get())) {
                return ModBlocks.STRIPPED_CHERRY_BLOSSOM_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
