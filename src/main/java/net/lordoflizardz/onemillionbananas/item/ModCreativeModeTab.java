package net.lordoflizardz.onemillionbananas.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab COURSE_TAB = new CreativeModeTab("coursemodtag") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItem.COBALT_INGOT.get());
        }
    };
}
