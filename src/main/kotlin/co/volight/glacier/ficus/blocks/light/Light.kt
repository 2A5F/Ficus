package co.volight.glacier.ficus.blocks.light

import co.volight.glacier.ficus.BlockRegWithItem
import co.volight.glacier.ficus.JoinItemGroup
import co.volight.glacier.ficus.blocks.never
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.block.*
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView

class Light(settings: Settings): Block(settings), JoinItemGroup {
    companion object {
        fun setting() : Settings {
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
}
