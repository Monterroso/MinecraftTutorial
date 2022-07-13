package net.lordoflizardz.onemillionbananas.block.entity;

import net.lordoflizardz.onemillionbananas.OneMillionBananas;
import net.lordoflizardz.onemillionbananas.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, OneMillionBananas.MOD_ID);

    public static final RegistryObject<BlockEntityType<CobaltBlasterBlockEntity>> COBALT_BLASTER =
            BLOCK_ENTITIES.register("cobalt_blaster", () ->
                    BlockEntityType.Builder.of(CobaltBlasterBlockEntity::new,
                            ModBlocks.COBALT_BLASTER.get()).build(null));

    public static void register (IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
