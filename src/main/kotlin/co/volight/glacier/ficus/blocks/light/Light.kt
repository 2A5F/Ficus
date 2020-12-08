package co.volight.glacier.ficus.blocks.light

import co.volight.glacier.ficus.BlockRegWithItem
import co.volight.glacier.ficus.JoinItemGroup
import co.volight.glacier.ficus.blocks.never
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.block.*
import net.minecraft.fluid.FluidState
import net.minecraft.fluid.Fluids
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.state.property.Properties
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.BlockView
import net.minecraft.world.WorldAccess

class Light(settings: Settings): Block(settings), Waterloggable, JoinItemGroup {
    companion object {
        val WATERLOGGED: BooleanProperty = Properties.WATERLOGGED

        private fun setting() : Settings {
            return Settings.of(Material.BARRIER).strength(-1.0f, 3600000.8f)
                .dropsNothing().noCollision().nonOpaque().allowsSpawning(::never)
        }
    }

    object L15: BlockRegWithItem<Light> {
        override val name: String = "light15"
        override val impl: Light by lazy {
            Light(setting().luminance { 15 })
        }
    }
    object L14: BlockRegWithItem<Light> {
        override val name: String = "light14"
        override val impl: Light by lazy {
            Light(setting().luminance { 14 })
        }
    }
    object L13: BlockRegWithItem<Light> {
        override val name: String = "light13"
        override val impl: Light by lazy {
            Light(setting().luminance { 13 })
        }
    }
    object L12: BlockRegWithItem<Light> {
        override val name: String = "light12"
        override val impl: Light by lazy {
            Light(setting().luminance { 12 })
        }
    }
    object L11: BlockRegWithItem<Light> {
        override val name: String = "light11"
        override val impl: Light by lazy {
            Light(setting().luminance { 11 })
        }
    }
    object L10: BlockRegWithItem<Light> {
        override val name: String = "light10"
        override val impl: Light by lazy {
            Light(setting().luminance { 10 })
        }
    }
    object L9: BlockRegWithItem<Light> {
        override val name: String = "light9"
        override val impl: Light by lazy {
            Light(setting().luminance { 9 })
        }
    }
    object L8: BlockRegWithItem<Light> {
        override val name: String = "light8"
        override val impl: Light by lazy {
            Light(setting().luminance { 8 })
        }
    }
    object L7: BlockRegWithItem<Light> {
        override val name: String = "light7"
        override val impl: Light by lazy {
            Light(setting().luminance { 7 })
        }
    }
    object L6: BlockRegWithItem<Light> {
        override val name: String = "light6"
        override val impl: Light by lazy {
            Light(setting().luminance { 6 })
        }
    }
    object L5: BlockRegWithItem<Light> {
        override val name: String = "light5"
        override val impl: Light by lazy {
            Light(setting().luminance { 5 })
        }
    }
    object L4: BlockRegWithItem<Light> {
        override val name: String = "light4"
        override val impl: Light by lazy {
            Light(setting().luminance { 4 })
        }
    }
    object L3: BlockRegWithItem<Light> {
        override val name: String = "light3"
        override val impl: Light by lazy {
            Light(setting().luminance { 3 })
        }
    }
    object L2: BlockRegWithItem<Light> {
        override val name: String = "light2"
        override val impl: Light by lazy {
            Light(setting().luminance { 2 })
        }
    }
    object L1: BlockRegWithItem<Light> {
        override val name: String = "light1"
        override val impl: Light by lazy {
            Light(setting().luminance { 1 })
        }
    }
    object L0: BlockRegWithItem<Light> {
        override val name: String = "light0"
        override val impl: Light by lazy {
            Light(setting())
        }
    }

    init {
        defaultState = stateManager.defaultState.with(WATERLOGGED, false)
    }

    override fun isTranslucent(state: BlockState, world: BlockView, pos: BlockPos): Boolean {
        return true
    }

    override fun getRenderType(state: BlockState): BlockRenderType {
        return BlockRenderType.INVISIBLE
    }

    @Environment(EnvType.CLIENT)
    override fun getAmbientOcclusionLightLevel(state: BlockState, world: BlockView, pos: BlockPos): Float {
        return 1.0f
    }

    override fun getPlacementState(ctx: ItemPlacementContext): BlockState {
        val fluidState = ctx.world.getFluidState(ctx.blockPos)
        val bl = fluidState.fluid === Fluids.WATER
        return super.getPlacementState(ctx)!!.with(WATERLOGGED, bl)
    }

    override fun getStateForNeighborUpdate(
        state: BlockState,
        direction: Direction,
        newState: BlockState,
        world: WorldAccess,
        pos: BlockPos,
        posFrom: BlockPos
    ): BlockState? {
        if (state.get(WATERLOGGED)) {
            world.fluidTickScheduler.schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(world))
        }
        return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom)
    }

    override fun appendProperties(builder: StateManager.Builder<Block?, BlockState?>) {
        builder.add(WATERLOGGED)
    }

    override fun getFluidState(state: BlockState): FluidState {
        return if (state.get(ChainBlock.WATERLOGGED)) Fluids.WATER.getStill(false)
            else super.getFluidState(state)
    }
}
