package me.jellysquid.mods.phosphor.common.chunk;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.EmptyBlockView;

/**
 * We can't access the package-private BlockState cache, so we re-implement a small part here.
 */
public class PhosphorBlockStateCache {
    private static final Direction[] DIRECTIONS = Direction.values();

    public final VoxelShape[] shapes;
    public final int lightSubtracted;

    public PhosphorBlockStateCache(BlockState state) {
        Block block = state.getBlock();

        this.shapes = new VoxelShape[DIRECTIONS.length];

        if (state.isOpaque()) {
            VoxelShape shape = block.getCullingShape(state, EmptyBlockView.INSTANCE, BlockPos.ORIGIN);

            for (Direction dir : DIRECTIONS) {
                this.shapes[dir.ordinal()] = VoxelShapes.extrudeFace(shape, dir);
            }
        }

        this.lightSubtracted = block.getOpacity(state, EmptyBlockView.INSTANCE, BlockPos.ORIGIN);
    }
}
