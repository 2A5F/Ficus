package co.volight.glacier.ficus.blocks.light

import co.volight.glacier.ficus.BlockRegWithItem
import co.volight.glacier.ficus.JoinItemGroup
import co.volight.glacier.ficus.blocks.never
import net.minecraft.block.AbstractGlassBlock
import net.minecraft.block.Material
import net.minecraft.block.MaterialColor
import net.minecraft.sound.BlockSoundGroup

class GlowGlass(settings: Settings) : AbstractGlassBlock(settings), JoinItemGroup {
    companion object: BlockRegWithItem<GlowGlass> {
        private fun setting(): Settings {
            return Settings.of(Material.GLASS).strength(0.3F).sounds(BlockSoundGroup.GLASS).nonOpaque()
                .allowsSpawning(::never).solidBlock(::never).suffocates(::never).blockVision(::never).luminance { 15 }
        }
        private fun setting(color: MaterialColor): Settings {
            return Settings.of(Material.GLASS, color).strength(0.3F).sounds(BlockSoundGroup.GLASS).nonOpaque()
                .allowsSpawning(::never).solidBlock(::never).suffocates(::never).blockVision(::never).luminance { 15 }
        }

        override val name = "glow_glass"
        override val impl by lazy {
            GlowGlass(setting())
        }
    }
}