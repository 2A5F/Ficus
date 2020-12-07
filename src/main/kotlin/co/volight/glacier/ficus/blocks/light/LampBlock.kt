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
    object Black: BlockRegWithItem<LampBlock> {
        override val name: String = "black_lamp_block"
        override val impl: LampBlock by lazy {
            LampBlock(Settings.of(Material.GLASS, MaterialColor.BLACK).strength(0.3f)
                .sounds(BlockSoundGroup.GLASS).luminance { 15 })
        }
    }
    object LightGray: BlockRegWithItem<LampBlock> {
        override val name: String = "light_gray_lamp_block"
        override val impl: LampBlock by lazy {
            LampBlock(Settings.of(Material.GLASS, MaterialColor.LIGHT_GRAY).strength(0.3f)
                .sounds(BlockSoundGroup.GLASS).luminance { 15 })
        }
    }
    object Gray: BlockRegWithItem<LampBlock> {
        override val name: String = "gray_lamp_block"
        override val impl: LampBlock by lazy {
            LampBlock(Settings.of(Material.GLASS, MaterialColor.GRAY).strength(0.3f)
                .sounds(BlockSoundGroup.GLASS).luminance { 15 })
        }
    }
    object Blue: BlockRegWithItem<LampBlock> {
        override val name: String = "blue_lamp_block"
        override val impl: LampBlock by lazy {
            LampBlock(Settings.of(Material.GLASS, MaterialColor.BLUE).strength(0.3f)
                .sounds(BlockSoundGroup.GLASS).luminance { 15 })
        }
    }
    object LightBlue: BlockRegWithItem<LampBlock> {
        override val name: String = "light_blue_lamp_block"
        override val impl: LampBlock by lazy {
            LampBlock(Settings.of(Material.GLASS, MaterialColor.LIGHT_BLUE).strength(0.3f)
                .sounds(BlockSoundGroup.GLASS).luminance { 15 })
        }
    }
    object Green: BlockRegWithItem<LampBlock> {
        override val name: String = "green_lamp_block"
        override val impl: LampBlock by lazy {
            LampBlock(Settings.of(Material.GLASS, MaterialColor.GREEN).strength(0.3f)
                .sounds(BlockSoundGroup.GLASS).luminance { 15 })
        }
    }
    object Lime: BlockRegWithItem<LampBlock> {
        override val name: String = "lime_lamp_block"
        override val impl: LampBlock by lazy {
            LampBlock(Settings.of(Material.GLASS, MaterialColor.LIME).strength(0.3f)
                .sounds(BlockSoundGroup.GLASS).luminance { 15 })
        }
    }
    object Cyan: BlockRegWithItem<LampBlock> {
        override val name: String = "cyan_lamp_block"
        override val impl: LampBlock by lazy {
            LampBlock(Settings.of(Material.GLASS, MaterialColor.CYAN).strength(0.3f)
                .sounds(BlockSoundGroup.GLASS).luminance { 15 })
        }
    }
    object Magenta: BlockRegWithItem<LampBlock> {
        override val name: String = "magenta_lamp_block"
        override val impl: LampBlock by lazy {
            LampBlock(Settings.of(Material.GLASS, MaterialColor.MAGENTA).strength(0.3f)
                .sounds(BlockSoundGroup.GLASS).luminance { 15 })
        }
    }
    object Orange: BlockRegWithItem<LampBlock> {
        override val name: String = "orange_lamp_block"
        override val impl: LampBlock by lazy {
            LampBlock(Settings.of(Material.GLASS, MaterialColor.ORANGE).strength(0.3f)
                .sounds(BlockSoundGroup.GLASS).luminance { 15 })
        }
    }
    object Pink: BlockRegWithItem<LampBlock> {
        override val name: String = "pink_lamp_block"
        override val impl: LampBlock by lazy {
            LampBlock(Settings.of(Material.GLASS, MaterialColor.PINK).strength(0.3f)
                .sounds(BlockSoundGroup.GLASS).luminance { 15 })
        }
    }
    object Red: BlockRegWithItem<LampBlock> {
        override val name: String = "red_lamp_block"
        override val impl: LampBlock by lazy {
            LampBlock(Settings.of(Material.GLASS, MaterialColor.RED).strength(0.3f)
                .sounds(BlockSoundGroup.GLASS).luminance { 15 })
        }
    }
    object Purple: BlockRegWithItem<LampBlock> {
        override val name: String = "purple_lamp_block"
        override val impl: LampBlock by lazy {
            LampBlock(Settings.of(Material.GLASS, MaterialColor.PURPLE).strength(0.3f)
                .sounds(BlockSoundGroup.GLASS).luminance { 15 })
        }
    }
    object Yellow: BlockRegWithItem<LampBlock> {
        override val name: String = "yellow_lamp_block"
        override val impl: LampBlock by lazy {
            LampBlock(Settings.of(Material.GLASS, MaterialColor.YELLOW).strength(0.3f)
                .sounds(BlockSoundGroup.GLASS).luminance { 15 })
        }
    }
    object Brown: BlockRegWithItem<LampBlock> {
        override val name: String = "brown_lamp_block"
        override val impl: LampBlock by lazy {
            LampBlock(Settings.of(Material.GLASS, MaterialColor.BROWN).strength(0.3f)
                .sounds(BlockSoundGroup.GLASS).luminance { 15 })
        }
    }
}