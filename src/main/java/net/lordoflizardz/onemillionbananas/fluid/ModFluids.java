//package net.lordoflizardz.onemillionbananas.fluid;
//
//import net.lordoflizardz.onemillionbananas.OneMillionBananas;
//import net.lordoflizardz.onemillionbananas.block.ModBlocks;
//import net.lordoflizardz.onemillionbananas.item.ModItem;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.level.block.LiquidBlock;
//import net.minecraft.world.level.block.state.BlockBehaviour;
//import net.minecraft.world.level.material.FlowingFluid;
//import net.minecraft.world.level.material.Fluid;
//import net.minecraft.world.level.material.Material;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.fluids.FluidAttributes;
//import net.minecraftforge.fluids.ForgeFlowingFluid;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
//
//public class ModFluids {
//    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
//    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
//    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");
//
//    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, OneMillionBananas.MOD_ID);
//
//    public static final RegistryObject<FlowingFluid> HONEY_FLUID = FLUIDS.register("honey_fluid",
//            () -> new ForgeFlowingFluid.Source(ModFluids.HONEY_PROPERTIES));
//
//    public static final RegistryObject<FlowingFluid> HONEY_FLOWING = FLUIDS.register("honey_flowing",
//            () -> new ForgeFlowingFluid.Flowing(ModFluids.HONEY_PROPERTIES));
//
//    public static final ForgeFlowingFluid.Properties HONEY_PROPERTIES = new ForgeFlowingFluid.Properties(
//            () -> HONEY_FLUID.get(), () -> HONEY_FLOWING.get(), FluidAttributes.builder(
//                    WATER_STILL_RL, WATER_FLOWING_RL).density(15).luminosity(2).viscosity(5).color(0xbcb03ffb))
//            .slopeFindDistance(2).levelDecreasePerBlock(2).block( () -> ModFluids.HONEY_BLOCK.get()).bucket(() ->
//                    ModItem.HONEY_BUCKET.get());
//
//
//    public static final RegistryObject<LiquidBlock> HONEY_BLOCK = ModBlocks.BLOCKS.register("honey", () -> new LiquidBlock(
//            () -> ModFluids.HONEY_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noDrops()
//    ));
//
//    public static void register(IEventBus eventBus) {
//        FLUIDS.register(eventBus);
//    }
//
//
//}
