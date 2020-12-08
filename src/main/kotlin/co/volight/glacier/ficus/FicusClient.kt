package co.volight.glacier.ficus

import co.volight.glacier.ficus.Ficus.logName
import co.volight.glacier.ficus.blocks.light.GlowGlass
import co.volight.glacier.ficus.blocks.toilet.Toilet
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.render.RenderLayer

@Suppress("unused")
fun initClient() {
    initBlockLayer()
    Ficus.logger.info("$logName Block Layer initialized")
}

fun initBlockLayer() {
    BlockRenderLayerMap.INSTANCE.putBlock(GlowGlass.impl, RenderLayer.getCutout())

    BlockRenderLayerMap.INSTANCE.putBlock(Toilet.Oak.impl, RenderLayer.getTranslucent())
}