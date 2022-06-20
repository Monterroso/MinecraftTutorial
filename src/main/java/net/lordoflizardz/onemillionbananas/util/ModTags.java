package net.lordoflizardz.onemillionbananas.util;

import net.lordoflizardz.onemillionbananas.OneMillionBananas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags {
    public static void register() {
        Blocks.RegisterBlockTags();
        Items.RegisterItemTags();
    }

    public static class Blocks {
        public static Tags.IOptionalNamedTag<Block> DOWSING_ROD_VALUABLES = tag("dowsing_rod_valuables");

        public static Tags.IOptionalNamedTag<Block> PAXEL_MINEABLE = tag("mineable/paxel");

        private static Tags.IOptionalNamedTag<Block> tag(String name) {
            return BlockTags.createOptional(new ResourceLocation(OneMillionBananas.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Block> forgeTag(String name) {
            return BlockTags.createOptional(new ResourceLocation("forge", name));
        }

        public static void RegisterBlockTags() {

        }
    }

    public static class Items {
        public static final Tags.IOptionalNamedTag<Item> COBOLT_INGOTS = forgeTag("ingots/cobalt");
        public static final Tags.IOptionalNamedTag<Item> COBOLT_NUGGETS = forgeTag("nuggets/cobalt");

        private static Tags.IOptionalNamedTag<Item> tag(String name) {
            return ItemTags.createOptional(new ResourceLocation(OneMillionBananas.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Item> forgeTag(String name) {
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }

        public static void RegisterItemTags() {

        }
    }
}
