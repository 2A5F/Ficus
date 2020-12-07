package co.volight.glacier.ficus.blocks.light

import co.volight.glacier.ficus.BlockRegWithItem
import co.volight.glacier.ficus.JoinItemGroup
import net.minecraft.block.*
import net.minecraft.sound.BlockSoundGroup

class LampBlock(settings: Settings): Block(settings), JoinItemGroup {
    object White: BlockRegWithItem<LampBlock> {
        override val name: String = "white_lamp_block"
        override val impl: LampBlock by lazy {
            LampBlock(Settings.of(Material.GLASS, MaterialColor.WHITE).strength(0.3f)
                    .sounds(BlockSoundGroup.GLASS).luminance { 15 })
        }
    }
}