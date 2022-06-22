package net.lordoflizardz.onemillionbananas.enchantment;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class LightningStrikeEnchantment extends Enchantment {
    protected LightningStrikeEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot ...pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        super.doPostAttack(pAttacker, pTarget, pLevel);
        if (!pAttacker.level.isClientSide()) {
            ServerLevel world = (ServerLevel) pAttacker.level;
            ServerPlayer player = (ServerPlayer) pAttacker;
            BlockPos position = pTarget.blockPosition();

            for (int i = 0; i < pLevel; i++) {
                EntityType.LIGHTNING_BOLT.spawn(world, null, player, position, MobSpawnType.TRIGGERED, true, true);
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
