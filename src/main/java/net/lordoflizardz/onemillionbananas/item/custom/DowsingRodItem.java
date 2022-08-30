package net.lordoflizardz.onemillionbananas.item.custom;

import net.lordoflizardz.onemillionbananas.item.ModItem;
import net.lordoflizardz.onemillionbananas.sound.ModSounds;
import net.lordoflizardz.onemillionbananas.util.InventoryUtil;
import net.lordoflizardz.onemillionbananas.util.ModTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.server.ServerLifecycleHooks;
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
                BlockState blockBelow = pContext.getLevel().getBlockState(positionClicked.below(i));

                if (isValuableBlock(blockBelow)) {
                    outputValuableCoordinates(positionClicked.below(i), player, blockBelow.getBlock());
                    foundBlock = true;

                    if (InventoryUtil.hasPlayerStackInInventory(player, ModItem.DATA_TABLET.get(), true)) {
                        this.addNbtToDataTablet(player, positionClicked.below(i), blockBelow.getBlock());
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
                player.sendSystemMessage(Component.translatable("item.onemillionbananas.dowsing_rod.no_valuables"));
            }
        }

        if (!pContext.getLevel().isClientSide()) {
            MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
            server.getPlayerList().broadcastSystemMessage(Component.literal(pContext.getPlayer() + " has used a divining rod"), true);
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(pContext);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.onemillionbananas.dousing_rod.tooltip.shift"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.onemillionbananas.dousing_rod.tooltip"));
        }

        if (pStack.hasTag() && !pStack.getTag().getString("onemillionbananas.found").isEmpty()) {
            String oreFound = pStack.getTag().getString("onemillionbananas.found");
            pTooltipComponents.add(Component.literal(oreFound));
        }
    }

    private void addNbtToDataTablet(Player player, BlockPos blockPos, Block blockBelow) {
        ItemStack dataTablet = player.getInventory().getItem(InventoryUtil.getFirstInventoryIndex(player, ModItem.DATA_TABLET.get(), true));

        CompoundTag nbtData = new CompoundTag();
        nbtData.putString("onemillionbananas.last_ore", getText(blockPos, blockBelow));

        dataTablet.setTag(nbtData);
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow) {
        player.sendSystemMessage(Component.literal(this.getText(blockPos, blockBelow)));
    }

    private String getText(BlockPos blockPos, Block blockBelow) {
        return String.format("Found %s at (%d, %d, %d)",
                blockBelow.asItem().toString(), blockPos.getX(), blockPos.getY(), blockPos.getZ());
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(ModTags.Blocks.DOWSING_ROD_VALUABLES);
    }
}
