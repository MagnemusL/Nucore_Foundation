package net.magne.nf.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.Tags;

public class LithiumBlock extends Block {
    public LithiumBlock(Properties properties) {
        super(properties);
    }

    public void lithiumReaction(Level level, BlockPos pos) {
        level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 1f, true, Level.ExplosionInteraction.TNT);
        level.playSound(null, pos, null, SoundSource.BLOCKS, 1f, 1f);
        level.removeBlock(pos, true);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState blockState, boolean b) {
        if(level.getBlockState(pos.below()) == Blocks.WATER.defaultBlockState()
                || level.getBlockState(pos.above()) == Blocks.WATER.defaultBlockState()
                || level.getBlockState(pos.north()) == Blocks.WATER.defaultBlockState()
                || level.getBlockState(pos.west()) == Blocks.WATER.defaultBlockState()
                || level.getBlockState(pos.east()) == Blocks.WATER.defaultBlockState()
                || level.getBlockState(pos.south()) == Blocks.WATER.defaultBlockState()) {
            lithiumReaction(level, pos);
        }
    }
}
