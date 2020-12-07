package co.volight.glacier.ficus

import co.volight.glacier.ficus.Ficus.logName
import co.volight.glacier.ficus.blocks.light.LampBlock
import co.volight.glacier.ficus.blocks.toilet.Toilet
import net.minecraft.block.Blocks
import org.apache.logging.log4j.LogManager

object Ficus {
    const val id = "ficus"
    const val logName = "[Ficus]"
    val logger = LogManager.getLogger()!!
}

@Suppress("unused")
fun init() {
    initBlocks()
    Ficus.logger.info("$logName Blocks initialized")

    initItems()
    Ficus.logger.info("$logName Items initialized")
}

fun initBlocks() {
    LampBlock.White.reg()
    LampBlock.Orange.reg()
    LampBlock.Magenta.reg()
    LampBlock.LightBlue.reg()
    LampBlock.Yellow.reg()
    LampBlock.Lime.reg()
    LampBlock.Pink.reg()
    LampBlock.Gray.reg()
    LampBlock.LightGray.reg()
    LampBlock.Cyan.reg()
    LampBlock.Purple.reg()
    LampBlock.Blue.reg()
    LampBlock.Brown.reg()
    LampBlock.Green.reg()
    LampBlock.Red.reg()
    LampBlock.Black.reg()

    Toilet.Oak.reg()
}

fun initItems() {
    LampBlock.White.regBlockItem()
    LampBlock.Orange.regBlockItem()
    LampBlock.Magenta.regBlockItem()
    LampBlock.LightBlue.regBlockItem()
    LampBlock.Yellow.regBlockItem()
    LampBlock.Lime.regBlockItem()
    LampBlock.Pink.regBlockItem()
    LampBlock.Gray.regBlockItem()
    LampBlock.LightGray.regBlockItem()
    LampBlock.Cyan.regBlockItem()
    LampBlock.Purple.regBlockItem()
    LampBlock.Blue.regBlockItem()
    LampBlock.Brown.regBlockItem()
    LampBlock.Green.regBlockItem()
    LampBlock.Red.regBlockItem()
    LampBlock.Black.regBlockItem()

    Toilet.Oak.regBlockItem()
}
