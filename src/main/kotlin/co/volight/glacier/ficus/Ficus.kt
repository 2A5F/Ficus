package co.volight.glacier.ficus

import co.volight.glacier.ficus.Ficus.logName
import co.volight.glacier.ficus.blocks.light.LampBlock
import co.volight.glacier.ficus.blocks.light.Light
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

    Light.L15.reg()
    Light.L14.reg()
    Light.L13.reg()
    Light.L12.reg()
    Light.L11.reg()
    Light.L10.reg()
    Light.L9.reg()
    Light.L8.reg()
    Light.L7.reg()
    Light.L6.reg()
    Light.L5.reg()
    Light.L4.reg()
    Light.L3.reg()
    Light.L2.reg()
    Light.L1.reg()
    Light.L0.reg()

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

    Light.L15.regBlockItem()
    Light.L14.regBlockItem()
    Light.L13.regBlockItem()
    Light.L12.regBlockItem()
    Light.L11.regBlockItem()
    Light.L10.regBlockItem()
    Light.L9.regBlockItem()
    Light.L8.regBlockItem()
    Light.L7.regBlockItem()
    Light.L6.regBlockItem()
    Light.L5.regBlockItem()
    Light.L4.regBlockItem()
    Light.L3.regBlockItem()
    Light.L2.regBlockItem()
    Light.L1.regBlockItem()
    Light.L0.regBlockItem()

    Toilet.Oak.regBlockItem()
}
