package co.volight.glacier.ficus

import co.volight.glacier.ficus.Ficus.logName
import co.volight.glacier.ficus.blocks.light.GlowGlass
import co.volight.glacier.ficus.blocks.toilet.Toilet
import co.volight.glacier.ficus.entities.Cube
import co.volight.glacier.ficus.entities.car.HoverCar
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.fabricmc.fabric.api.client.render.ColorProviderRegistry
import net.minecraft.block.BlockState
import net.minecraft.client.color.world.BiomeColors
import net.minecraft.client.render.RenderLayer
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockRenderView

@Suppress("unused")
fun initClient() {
    initBlockLayer()
    Ficus.logger.info("$logName Block Layer initialized")

    initBlockColors()
    Ficus.logger.info("$logName Block Colors initialized")

    initEntityRender()
    Ficus.logger.info("$logName Entity Render initialized")
}

fun initBlockLayer() {
    BlockRenderLayerMap.INSTANCE.putBlock(GlowGlass.impl, RenderLayer.getCutout())

    BlockRenderLayerMap.INSTANCE.putBlock(Toilet.Oak.impl, RenderLayer.getTranslucent())
}

fun initBlockColors() {
    ColorProviderRegistry.BLOCK.register({ _: BlockState, world: BlockRenderView?, pos: BlockPos?, _: Int ->
        if (world != null && pos != null) BiomeColors.getWaterColor(world, pos) else -1
    }, Toilet.Oak.impl)
}

fun initEntityRender() {
    Cube.regRender()
    HoverCar.Red.regRender()
}