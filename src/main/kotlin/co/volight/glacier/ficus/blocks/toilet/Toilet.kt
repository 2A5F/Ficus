package co.volight.glacier.ficus.blocks.toilet

import co.volight.glacier.ficus.BlockRegWithItem
import co.volight.glacier.ficus.JoinItemGroup
import net.minecraft.block.*
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.math.Direction.*
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView

class Toilet(baseBlockState: BlockState, settings: Settings) : AToilet(baseBlockState, settings), JoinItemGroup {
    object Oak: BlockRegWithItem<Toilet> {
        override val name: String = "oak_toilet"
        override val impl by lazy {
            Toilet(Blocks.OAK_PLANKS.defaultState, Settings.copy(Blocks.OAK_PLANKS))
        }
    }

    companion object {
        val SHAPE_S_MATONGDI = createCuboidShape(3.0, 0.0, 1.0, 13.0, 3.0, 12.0)
        val SHAPE_S_MATONGTI = createCuboidShape(2.0, 3.0, 0.0, 14.0, 6.0, 13.0)
        val SHAPE_S_MATONGSHUIXIANG = createCuboidShape(1.0, 4.0, 12.0, 15.0, 18.0, 16.0)
        val SHAPE_S = VoxelShapes.union(SHAPE_S_MATONGDI, SHAPE_S_MATONGTI, SHAPE_S_MATONGSHUIXIANG)

        val SHAPE_N_MATONGDI = createCuboidShape(3.0, 0.0, 4.0, 13.0, 3.0, 15.0)
        val SHAPE_N_MATONGTI = createCuboidShape(2.0, 3.0, 3.0, 14.0, 6.0, 16.0)
        val SHAPE_N_MATONGSHUIXIANG = createCuboidShape(1.0, 4.0, 0.0, 15.0, 18.0, 4.0)
        val SHAPE_N = VoxelShapes.union(SHAPE_N_MATONGDI, SHAPE_N_MATONGTI, SHAPE_N_MATONGSHUIXIANG)

        val SHAPE_E_MATONGDI = createCuboidShape(1.0, 0.0, 3.0, 12.0, 3.0, 13.0)
        val SHAPE_E_MATONGTI = createCuboidShape(0.0, 3.0, 2.0, 13.0, 6.0, 14.0)
        val SHAPE_E_MATONGSHUIXIANG = createCuboidShape(12.0, 4.0, 1.0, 16.0, 18.0, 15.0)
        val SHAPE_E = VoxelShapes.union(SHAPE_E_MATONGDI, SHAPE_E_MATONGTI, SHAPE_E_MATONGSHUIXIANG)

        val SHAPE_W_MATONGDI = createCuboidShape(4.0, 0.0, 3.0, 15.0, 3.0, 13.0)
        val SHAPE_W_MATONGTI = createCuboidShape(3.0, 3.0, 2.0, 16.0, 6.0, 14.0)
        val SHAPE_W_MATONGSHUIXIANG = createCuboidShape(0.0, 4.0, 1.0, 4.0, 18.0, 15.0)
        val SHAPE_W = VoxelShapes.union(SHAPE_W_MATONGDI, SHAPE_W_MATONGTI, SHAPE_W_MATONGSHUIXIANG)
    }

    override fun getOutlineShape(
        state: BlockState,
        world: BlockView,
        pos: BlockPos,
        context: ShapeContext
    ): VoxelShape {
        return when (state.get(FACING)) {
            WEST -> SHAPE_W
            EAST -> SHAPE_E
            SOUTH -> SHAPE_S
            NORTH -> SHAPE_N
            else -> SHAPE_N
        }
    }
}