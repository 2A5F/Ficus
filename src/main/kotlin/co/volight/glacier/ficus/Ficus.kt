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

    Toilet.Oak.reg()
}

fun initItems() {
    LampBlock.White.regBlockItem()

    Toilet.Oak.regBlockItem()
}
