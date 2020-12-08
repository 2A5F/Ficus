package co.volight.glacier.ficus.blocks

import net.minecraft.block.BlockState
import net.minecraft.entity.EntityType
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView

fun never(state: BlockState?, world: BlockView?, pos: BlockPos?, type: EntityType<*>?): Boolean {
    return false
}

fun never(state: BlockState, world: BlockView, pos: BlockPos): Boolean {
    return false
}
