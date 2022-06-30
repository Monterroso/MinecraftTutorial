package net.lordoflizardz.onemillionbananas.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Random;

public class SpeedyBlock extends Block {
    public static final BooleanProperty ON = BooleanProperty.create("on");

    public SpeedyBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(ON, false));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
            boolean currentState = pState.getValue(ON);
            pLevel.setBlock(pPos, pState.setValue(ON, !currentState), 3);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, Random pRandom) {
        super.animateTick(pState, pLevel, pPos, pRandom);
        float chanceSpawn = .35f;
        float timesPerTick = 4;
        for (int i = 0; i < timesPerTick; i++) {
            if(chanceSpawn < pRandom.nextFloat()) {
                pLevel.addParticle(ParticleTypes.SMOKE, pPos.getX() + pRandom.nextDouble(),
                        pPos.getY() + 0.5D, pPos.getZ() + pRandom.nextDouble(),
                        0d, 0.015d + pRandom.nextDouble(0.075d), 0d);
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(ON);

        super.createBlockStateDefinition(pBuilder);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (!pLevel.isClientSide() && pState.getValue(ON)) {
            if (pEntity instanceof LivingEntity entity) {
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1));

            }
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
