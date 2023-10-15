package net.magne.nf.item.custom;

import net.magne.nf.block.custom.LithiumBlock;
import net.magne.nf.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LithiumItem extends Item {
    public LithiumItem(Properties properties) {
        super(properties);
    }

    public void lithiumReaction(Level level, BlockPos pos) {
        level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 1f, true, Level.ExplosionInteraction.TNT);
        level.playSound(null, pos, null, SoundSource.BLOCKS, 1f, 1f);
        level.removeBlock(pos, true);
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack item, Player player) {
        Inventory inventory = player.getInventory();
        Level level = player.level();
        BlockPos pos = player.getOnPos();
        if(player.isInWater() && inventory.contains(new ItemStack(ModItems.LITHIUM_INGOT.get()))) {
            lithiumReaction(level, pos);
        }
        return false;
    }
}
