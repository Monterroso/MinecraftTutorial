package net.lordoflizardz.onemillionbananas.block;

import net.lordoflizardz.onemillionbananas.OneMillionBananas;
import net.lordoflizardz.onemillionbananas.block.custom.*;
import net.lordoflizardz.onemillionbananas.item.ModCreativeModeTab;
import net.lordoflizardz.onemillionbananas.item.ModItem;
import net.lordoflizardz.onemillionbananas.sound.ModSounds;
import net.lordoflizardz.onemillionbananas.world.feature.tree.CherryBlossomTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, OneMillionBananas.MOD_ID);

    public static final RegistryObject<Block> COBALT_BLOCK = registerBlock("cobalt_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> COBALT_ORE = registerBlock("cobalt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> DEEPSLATE_COBALT_ORE = registerBlock( "deepslate_cobalt_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> RAW_COBALT_BLOCK = registerBlock("raw_cobalt_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> SPEEDY_BLOCK = registerBlock("speedy_block",
            () -> new SpeedyBlock(BlockBehaviour.Properties.of(Material.METAL).strength(5f)
                .lightLevel((state) -> state.getValue(SpeedyBlock.ON) ? 15 : 0).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB,
            "tooltip.onemillionbananas.speedy_block.tooltip");

    public static final RegistryObject<Block> COBALT_STAIRS = registerBlock("cobalt_stairs",
            () -> new StairBlock(() -> ModBlocks.COBALT_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> COBALT_SLAB = registerBlock("cobalt_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> COBALT_PRESSURE_PLATE = registerBlock("cobalt_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> COBALT_BUTTON = registerBlock("cobalt_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops().noCollission()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> COBALT_FENCE = registerBlock("cobalt_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> COBALT_FENCE_GATE = registerBlock("cobalt_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> COBALT_WALL = registerBlock("cobalt_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> CHERRY_BLOSSOM_DOOR = registerBlock("cherry_blossom_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(3f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> CHERRY_BLOSSOM_TRAPDOOR = registerBlock("cherry_blossom_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(3f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> COBALT_LAMP_BLOCK = registerBlock("cobalt_lamp",
            () -> new CobaltLampBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(3f).requiresCorrectToolForDrops().sound(ModSounds.COBALT_LAMP_SOUNDS)
                    .lightLevel((state) -> state.getValue(CobaltLampBlock.CLICKED) ? 15 : 0)
                    .noOcclusion()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> TURNIP_CROP = BLOCKS.register("turnip_crop",
            () -> new TurnipCropBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS).noCollission().noOcclusion()));

    public static final RegistryObject<Block> PINK_ROSE = registerBlock("pink_rose",
            () -> new FlowerBlock(MobEffects.BLINDNESS, 100, BlockBehaviour.Properties.copy(Blocks.SUNFLOWER)), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> POTTED_PINK_ROSE = BLOCKS.register("potted_pink_rose",
            () -> new FlowerPotBlock(null, ModBlocks.PINK_ROSE, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

    public static final RegistryObject<Block> COBALT_BLASTER = registerBlock("cobalt_blaster",
            () -> new CobaltBlasterBlock(BlockBehaviour.Properties.of(Material.METAL).noOcclusion()), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> CHERRY_BLOSSOM_LOG = registerBlock("cherry_blossom_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> CHERRY_BLOSSOM_WOOD = registerBlock("cherry_blossom_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> STRIPPED_CHERRY_BLOSSOM_LOG = registerBlock("stripped_cherry_blossom_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> STRIPPED_CHERRY_BLOSSOM_WOOD = registerBlock("stripped_cherry_blossom_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> CHERRY_BLOSSOM_SIGN = BLOCKS.register("cherry_blossom_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD), ModWoodTypes.CHERRY_BLOSSOM));

    public static final RegistryObject<Block> CHERRY_BLOSSOM_WALL_SIGN = BLOCKS.register("cherry_blossom_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD), ModWoodTypes.CHERRY_BLOSSOM));

    public static final RegistryObject<Block> CHERRY_BLOSSOM_PLANKS = registerBlock("cherry_blossom_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> CHERRY_BLOSSOM_LEAVES = registerBlock("cherry_blossom_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> CHERRY_BLOSSOM_SAPLING = registerBlock("cherry_blossom_sapling",
            () -> new SaplingBlock(new CherryBlossomTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> WINTER_WINDOW = registerBlock("winter_window",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)), ModCreativeModeTab.COURSE_TAB);

    public static final RegistryObject<Block> PEDESTAL = registerBlock("pedestal",
            () -> new PedestalBlock(BlockBehaviour.Properties.of(Material.STONE).noOcclusion()), ModCreativeModeTab.COURSE_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab, String tooltipKey) {
        return ModItem.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)){
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(Component.translatable(tooltipKey));
            }
        });
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItem.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
