package net.lordoflizardz.onemillionbananas.item.custom;

import net.lordoflizardz.onemillionbananas.item.ModItem;
import net.lordoflizardz.onemillionbananas.sound.ModSounds;
import net.lordoflizardz.onemillionbananas.util.InventoryUtil;
import net.lordoflizardz.onemillionbananas.util.ModTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DowsingRodItem extends Item {
    public DowsingRodItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                Block blockBelow = pContext.getLevel().getBlockState(positionClicked.below(i)).getBlock();

                if (isValuableBlock(blockBelow)) {
                    outputValuableCoordinates(positionClicked.below(i), player, blockBelow);
                    foundBlock = true;

                    if (InventoryUtil.hasPlayerStackInInventory(player, ModItem.DATA_TABLET.get(), true)) {
                        this.addNbtToDataTablet(player, positionClicked.below(i), blockBelow);
                    }

                    pContext.getLevel().playSound(player, positionClicked, ModSounds.DOWSING_ROD_FOUND_ORE.get(),
                            SoundSource.BLOCKS, 1f, 1f);

                    CompoundTag nbtData = new CompoundTag();
                    nbtData.putString("onemillionbananas.found", blockBelow.toString());
                    pContext.getItemInHand().setTag(nbtData);
                    break;
                }
            }

            if (!foundBlock) {
                player.sendMessage(new TranslatableComponent("item.onemillionbananas.dowsing_rod.no_valuables"), player.getUUID());
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(pContext);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.onemillionbananas.dousing_rod.tooltip.shift"));
        } else {
            pTooltipComponents.add(new TranslatableComponent("tooltip.onemillionbananas.dousing_rod.tooltip"));
        }

        if (pStack.hasTag() && !pStack.getTag().getString("onemillionbananas.found").isEmpty()) {
            String oreFound = pStack.getTag().getString("onemillionbananas.found");
            pTooltipComponents.add(new TextComponent(oreFound));
        }
    }

    private void addNbtToDataTablet(Player player, BlockPos blockPos, Block blockBelow) {
        ItemStack dataTablet = player.getInventory().getItem(InventoryUtil.getFirstInventoryIndex(player, ModItem.DATA_TABLET.get(), true));

        CompoundTag nbtData = new CompoundTag();
        nbtData.putString("onemillionbananas.last_ore", getText(blockPos, blockBelow));

        dataTablet.setTag(nbtData);
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow) {
        player.sendMessage(new TextComponent(this.getText(blockPos, blockBelow)), player.getUUID());
    }

    private String getText(BlockPos blockPos, Block blockBelow) {
        return String.format("Found %s at (%d, %d, %d)",
                blockBelow.asItem().getRegistryName().toString(), blockPos.getX(), blockPos.getY(), blockPos.getZ());
    }

    private boolean isValuableBlock(Block block) {
        return ModTags.Blocks.DOWSING_ROD_VALUABLES.contains(block);
    }
}
