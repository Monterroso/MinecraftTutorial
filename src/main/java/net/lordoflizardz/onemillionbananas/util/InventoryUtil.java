package net.lordoflizardz.onemillionbananas.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class InventoryUtil {
    public static int getFirstInventoryIndex(Player player, Item item, boolean tagless) {
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack currentStack = player.getInventory().getItem(i);

            if (!currentStack.isEmpty() && currentStack.sameItem(new ItemStack(item))) {
                if (tagless && !currentStack.hasTag()) {
                    return i;
                }

                if (!tagless) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static boolean hasPlayerStackInInventory(Player player, Item item, boolean tagless) {
        int index = InventoryUtil.getFirstInventoryIndex(player, item, tagless);

        if (index == -1) {
            return false;
        }

        return true;
    }
}
