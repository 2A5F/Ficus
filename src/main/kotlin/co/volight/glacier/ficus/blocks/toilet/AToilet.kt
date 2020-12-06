package co.volight.glacier.ficus.blocks.toilet

import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.block.*
import net.minecraft.entity.Entity
import net.minecraft.entity.ai.pathing.NavigationType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.fluid.FluidState
import net.minecraft.fluid.Fluids
import net.minecraft.item.ItemPlacementContext
import net.minecraft.server.world.ServerWorld
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.state.property.DirectionProperty
import net.minecraft.state.property.Properties
import net.minecraft.util.ActionResult
import net.minecraft.util.BlockRotation
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.BlockView
import net.minecraft.world.World
import net.minecraft.world.WorldAccess
import net.minecraft.world.explosion.Explosion
import java.util.*

abstract class AToilet(val baseBlockState: BlockState, settings: Settings) : Block(settings), Waterloggable {
    companion object {
        @JvmStatic
        val FACING: DirectionProperty = HorizontalFacingBlock.FACING
        @JvmStatic
        val WATERLOGGED: BooleanProperty = Properties.WATERLOGGED
    }

    init {
        defaultState = stateManager.defaultState.with(FACING, Direction.NORTH).with(WATERLOGGED, false)
    }

    val baseBlock = baseBlockState.block

    @Environment(EnvType.CLIENT)
    override fun randomDisplayTick(state: BlockState, world: World, pos: BlockPos, random: Random) {
        baseBlock.randomDisplayTick(state, world, pos, random)
    }

    override fun onBlockBreakStart(state: BlockState, world: World, pos: BlockPos, player: PlayerEntity) {
        baseBlockState.onBlockBreakStart(world, pos, player)
    }

    override fun onBroken(world: WorldAccess, pos: BlockPos, state: BlockState) {
        baseBlock.onBroken(world, pos, state)
    }

    override fun getBlastResistance(): Float {
        return baseBlock.blastResistance
    }

    override fun onBlockAdded(
        state: BlockState,
        world: World,
        pos: BlockPos,
        oldState: BlockState,
        notify: Boolean
    ) {
        if (!state.isOf(state.block)) {
            baseBlockState.neighborUpdate(world, pos, Blocks.AIR, pos, false)
            baseBlock.onBlockAdded(baseBlockState, world, pos, oldState, false)
        }
    }

    override fun onStateReplaced(
        state: BlockState,
        world: World,
        pos: BlockPos,
        newState: BlockState,
        moved: Boolean
    ) {
        if (!state.isOf(newState.block)) {
            baseBlockState.onStateReplaced(world, pos, newState, moved)
        }
    }

    override fun onSteppedOn(world: World, pos: BlockPos, entity: Entity) {
        baseBlock.onSteppedOn(world, pos, entity)
    }

    override fun hasRandomTicks(state: BlockState): Boolean {
        return baseBlock.hasRandomTicks(state)
    }

    override fun randomTick(state: BlockState, world: ServerWorld, pos: BlockPos, random: Random) {
        baseBlock.randomTick(state, world, pos, random)
    }

    override fun scheduledTick(state: BlockState, world: ServerWorld, pos: BlockPos, random: Random) {
        baseBlock.scheduledTick(state, world, pos, random)
    }

    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hand: Hand,
        hit: BlockHitResult
    ): ActionResult {
        return baseBlockState.onUse(world, player, hand, hit)
    }

    override fun onDestroyedByExplosion(world: World, pos: BlockPos, explosion: Explosion) {
        baseBlock.onDestroyedByExplosion(world, pos, explosion)
    }

    override fun getPlacementState(ctx: ItemPlacementContext): BlockState {
        val blockPos = ctx.blockPos
        val fluidState = ctx.world.getFluidState(blockPos)
        return defaultState.with(FACING, ctx.playerFacing)
            .with(WATERLOGGED, fluidState.fluid === Fluids.WATER)
    }

    override fun getStateForNeighborUpdate(
        state: BlockState,
        direction: Direction,
        newState: BlockState,
        world: WorldAccess,
        pos: BlockPos,
        posFrom: BlockPos
    ): BlockState {
        if (state.get(WATERLOGGED) as Boolean) {
            world.fluidTickScheduler.schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(world))
        }
        return if (direction.axis.isHorizontal) state
            else super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom)
    }

    open fun isToilet(state: BlockState): Boolean {
        return state.block is AToilet
    }

    override fun rotate(state: BlockState, rotation: BlockRotation): BlockState {
        return state.with(FACING, rotation.rotate(state.get(FACING) as Direction)) as BlockState
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(FACING, WATERLOGGED)
    }

    override fun getFluidState(state: BlockState): FluidState {
        return if (state.get(StairsBlock.WATERLOGGED)) Fluids.WATER.getStill(false)
            else super.getFluidState(state)
    }

    override fun canPathfindThrough(
        state: BlockState,
        world: BlockView,
        pos: BlockPos,
        type: NavigationType
    ): Boolean {
        return false
    }

    override fun hasSidedTransparency(state: BlockState): Boolean {
        return true
    }

}